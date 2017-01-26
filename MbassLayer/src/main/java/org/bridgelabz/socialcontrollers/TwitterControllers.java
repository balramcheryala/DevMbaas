/**
 * 
 */
package org.bridgelabz.socialcontrollers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bridgelabz.controllers.Dashboard;
import org.bridgelabz.dao.ClientCredentialsDao;
import org.bridgelabz.enums.SocialProvider;
import org.bridgelabz.model.TwitterDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author bridgelabz
 *
 */
@Controller("twittercontroller")
public class TwitterControllers {

	Session session;

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	ClientCredentialsDao dao;

	// Twitter AccessToken
	public static Twitter twitter;

	/*
	 * 
	 * Twitter Sign In Controller
	 */
	@RequestMapping("/twittersignin")
	public void twitterSignin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// configure twitter api with consumer key and secret key
		ConfigurationBuilder cb = new ConfigurationBuilder();

		// fetching the credentials from the database
		cb.setDebugEnabled(true).setOAuthConsumerKey(dao.credentials(Dashboard.globalname,SocialProvider.TWITTER).get(0))
				.setOAuthConsumerSecret(dao.credentials(Dashboard.globalname,SocialProvider.TWITTER).get(1));
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		request.getSession().setAttribute("twitter", twitter);
		try {

			// setup callback URL
			StringBuffer callbackURL = request.getRequestURL();
			int index = callbackURL.lastIndexOf("/");
			callbackURL.replace(index, callbackURL.length(), "").append("/twitter");

			// get request object and save to session
			RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
			System.out.println(requestToken);
			request.getSession().setAttribute("requestToken", requestToken);

			// redirect to twitter authentication URL
			response.sendRedirect(requestToken.getAuthenticationURL());

		} catch (TwitterException e) {
			throw new ServletException(e);
		}

	}

	/*
	 * Twitter Controller
	 */
	@RequestMapping("/twitter")
	public ModelAndView twitter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, TwitterException {

		// Get twitter object from session
		twitter = (Twitter) request.getSession().getAttribute("twitter");

		// Get twitter request token object from session
		RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
		String verifier = request.getParameter("oauth_verifier");

		// Get twitter access token object by verifying request token
		AccessToken accessToken;
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Successfully Loggedin To Twitter");

		try {

			accessToken = twitter.getOAuthAccessToken(requestToken, verifier);

			System.out.println(accessToken);
			request.getSession().removeAttribute("requestToken");

			session = sessionFactory.openSession();
			TwitterDetails details = new TwitterDetails();
			details.setAccessToken(twitter.toString());
			details.setUserId(accessToken.getUserId());
			details.setScreenName(accessToken.getScreenName());
			details.setToken(accessToken.getToken());
			details.setTokenSecret(accessToken.getTokenSecret());
			session.save(details);
			session.close();

		} catch (TwitterException e) {

			e.printStackTrace();
		}
		return new ModelAndView("DataSaved", map);
	}

}
