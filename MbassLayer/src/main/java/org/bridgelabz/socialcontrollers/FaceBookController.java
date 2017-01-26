/**
 * 
 */
package org.bridgelabz.socialcontrollers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bridgelabz.controllers.Dashboard;
import org.bridgelabz.dao.ClientCredentialsDao;
import org.bridgelabz.enums.SocialProvider;
import org.bridgelabz.model.FacebookDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bridgelabz
 *
 */

@Controller("facebook")
public class FaceBookController {

	Session session;

	private static String FB_REDIRECT_URI = "http://localhost:8086/MbassLayer/facebook";

	private static String accessToken = "";

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	ClientCredentialsDao dao;

	private String code = "";

	JSONObject jsonObj;

	@RequestMapping("/facebookrequest")
	public String facebookrequest() {
		String fbLoginUrl = "";
		try {
			ArrayList<String> arrayList = new ArrayList<>();
			System.out.println("project name:" + Dashboard.globalname);
			arrayList = dao.credentials(Dashboard.globalname, SocialProvider.FACEBOOK);
			System.out.println("app Id:" + arrayList.get(0));
			System.out.println("app password:" + arrayList.get(1));
			fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id=" + arrayList.get(0) + "&redirect_uri="
					+ URLEncoder.encode(FB_REDIRECT_URI, "UTF-8") + "&scope=email,user_posts,publish_actions";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return "redirect:" + fbLoginUrl;
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public ModelAndView facebook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// getiing the autherazation code
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		// getting accesstoken form here
		String facebookAccessToken = getAccessToken(code);

		System.out.println("Facebook accessToken : " + facebookAccessToken);

		// paasing the accesstoken to FacebookGraph graph method to access the
		// user
		// details
		// getting the graph user in json format
		String graph = getFacebookGraph(facebookAccessToken);
		// passing the graph to get graph data for getting the graph from given
		// json fromat
		Map<String, String> ProfileData = getGraphData(graph);

		// Creating a Session for storing the values of the user.
		session = sessionFactory.openSession();

		// Creating a object for FaceBookDetails For saving the data of the user
		FacebookDetails details = new FacebookDetails();
		// setting AccessToken into Database
		details.setAccessToken(facebookAccessToken);
		details.setFacebookid(ProfileData.get("id"));
		details.setProjectname(Dashboard.globalname);
		details.setBio(ProfileData.get("bio"));
		details.setEmail(ProfileData.get("email"));
		details.setFirst_name(ProfileData.get("first_name"));
		details.setGender(ProfileData.get("gender"));
		details.setLast_name(ProfileData.get("last_name"));
		details.setName(ProfileData.get("name"));
		session.save(details);
		session.close();
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Successfully LoggedInto the To FaceBook");
		return new ModelAndView("DataSaved", map);

	}

	// Getting access token By passing the AutherizedCode
	public String getAccessToken(String code) {
		System.out.println("getAccessToken method" + code);
		if ("".equals(accessToken)) {
			URL fbGraphURL;
			try {
				fbGraphURL = new URL(getGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection FacebookConnection;
			StringBuffer b = null;
			try {
				// openingConnection of fbgraph url
				FacebookConnection = fbGraphURL.openConnection();
				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(FacebookConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				// reading a accesstoken from jsp page
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APiProvider
			if (accessToken.startsWith("{")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}

	// creating a connection to graph URL for exchange the code with provider
	public String getGraphUrl(String code) {
		String fbGraphUrl = "";
		try {
			fbGraphUrl = "https://graph.facebook.com/oauth/access_token?" + "client_id="
					+ dao.credentials(Dashboard.globalname, SocialProvider.FACEBOOK).get(0) + "&redirect_uri="
					+ URLEncoder.encode(FB_REDIRECT_URI, "UTF-8") + "&client_secret="
					+ dao.credentials(Dashboard.globalname, SocialProvider.FACEBOOK).get(1) + "&code=" + code;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbGraphUrl;
	}

	// Getting FacebookGraph From Here

	public String getFacebookGraph(String accessToken) {
		String graph = null;
		try {

			String g = "https://graph.facebook.com/me?fields=id,name,email,birthday,about,gender,first_name,last_name&"
					+ accessToken;
			URL u = new URL(g);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
			graph = b.toString();
			System.out.println(graph);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in getting FB graph data. " + e);
		}
		return graph;
	}

	// getting GraphData From here
	public Map<String, String> getGraphData(String FacebookGraph) {
		Map<String, String> facebookProfile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(FacebookGraph);

			facebookProfile.put("id", json.getString("id"));
			facebookProfile.put("fullname", json.getString("name"));
			if (json.has("first_name"))
				facebookProfile.put("first_name", json.getString("first_name"));
			if (json.has("last_name"))
				facebookProfile.put("last_name", json.getString("last_name"));
			if (json.has("birthday"))
				facebookProfile.put("birthday", json.getString("birthday"));
			if (json.has("bio"))
				facebookProfile.put("bio", json.getString("bio"));
			if (json.has("gender"))
				facebookProfile.put("gender", json.getString("gender"));
			if (json.has("email"))
				facebookProfile.put("email", json.getString("email"));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return facebookProfile;
	}

}
