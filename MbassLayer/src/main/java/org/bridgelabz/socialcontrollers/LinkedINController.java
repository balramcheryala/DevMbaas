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
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bridgelabz.controllers.Dashboard;
import org.bridgelabz.dao.ClientCredentialsDao;
import org.bridgelabz.enums.SocialProvider;
import org.bridgelabz.model.LinkedInDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bridgelabz
 *
 */
@Controller("linkedin")
public class LinkedINController {

	private static String accessToken = "";

	Session session;

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	ClientCredentialsDao dao;

	private String code = "";

	JSONObject jsonObj;

	public static String LK_REDIRECT_URI = "http://localhost:8086/MbassLayer/linkedin";

	// Invoking a authentication url
	@RequestMapping("linkedinrequest")
	public String getAuthUrl() {
		String LoginUrl = "";
		try {

			LoginUrl = "https://www.linkedin.com/oauth/v2/authorization?" + "response_type=code&client_id="
					+ dao.credentials(Dashboard.globalname, SocialProvider.LINKEDIN).get(0) + "&redirect_uri="
					+ URLEncoder.encode(LK_REDIRECT_URI, "UTF-8") + "&state=DCEe45A53sdfKef424FWf&scope=r_basicprofile";

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:" + LoginUrl;
	}

	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public ModelAndView LinkedIn(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// getiing the autherazation code
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		// getting accesstoken here by exchanging the autherization code with
		// provider
		accessToken = getAccessToken(code);

		try {
			jsonObj = new JSONObject(accessToken);
			System.out.println(jsonObj.get("access_token"));
			// paasing the accesstoken to LinkedInGraph graph method to access
			// the user
			// details

			// passing the graph to get graph data for getting the graph from
			// given
			// json fromat
			Map<String, String> ProfileData = getGraphData(jsonObj.get("access_token").toString());
			// Parsed Data Storing into the DataBase
			session = sessionFactory.openSession();
			LinkedInDetails details = new LinkedInDetails();
			details.setAccessToken(accessToken);
			details.setLinkedinId(ProfileData.get("id"));
			details.setProjectName(Dashboard.globalname);
			details.setFirstName(ProfileData.get("firstName"));
			details.setHeadline(ProfileData.get("headline"));
			details.setIndustry(ProfileData.get("industry"));
			details.setPictureUrl(ProfileData.get("pictureUrl"));
			details.setPublicProfileUrl(ProfileData.get("publicProfileUrl"));
			session.save(details);
			session.close();

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return new ModelAndView("DataSaved");

	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	// creating a connection to grapghurl
	public String getGraphUrl(String code) {
		String GraphUrl = "";
		try {
			GraphUrl = "https://www.linkedin.com/oauth/v2/accessToken?" + "grant_type=authorization_code&code=" + code
					+ "&redirect_uri=" + URLEncoder.encode(LK_REDIRECT_URI, "UTF-8") + "&client_id="
					+ dao.credentials(Dashboard.globalname, SocialProvider.LINKEDIN).get(0) + "&client_secret="
					+ dao.credentials(Dashboard.globalname, SocialProvider.LINKEDIN).get(1);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return GraphUrl;
	}

	// Exchanging Code and Generating Access Token Here
	// getting accesstoken
	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL GraphURL;
			try {
				GraphURL = new URL(getGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection Connection;
			StringBuffer b = null;
			try {
				Connection = GraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
				String inputLine;

				// reading a accesstoken from jsp page
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APiProvider
			if (accessToken.startsWith("[")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}

	/**
	 * Gets the graph.
	 *
	 * @return the graph
	 */
	public String getGraph() {
		String graph = null;
		try {

			String g = "https://api.linkedin.com/v1/people/~:(id,firstName,location,headline,industry,public-profile-url,picture-url)?oauth2_access_token="
					+ accessToken + "&format=json";
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

	/**
	 * Gets the graph data.
	 *
	 * @param Graph
	 *            the graph
	 * @return the graph data
	 */
	public Map<String, String> getGraphData(String Graph) {
		Map<String, String> Profile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(Graph);
			Profile.put("id", json.getString("id"));

			Profile.put("firstName", json.getString("firstName"));

			if (json.has("headline"))
				Profile.put("headline", json.getString("headline"));

			if (json.has("industry"))
				Profile.put("industry", json.getString("industry"));

			if (json.has("pictureUrl"))
				Profile.put("pictureUrl", json.getString("pictureUrl"));

			if (json.has("publicProfileUrl"))
				Profile.put("publicProfileUrl", json.getString("publicProfileUrl"));

		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing LinkedIn graph data. " + e);
		}
		return Profile;
	}
}
