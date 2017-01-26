/**
 * 
 */
package org.bridgelabz.socialcontrollers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bridgelabz.controllers.Dashboard;
import org.bridgelabz.dao.ClientCredentialsDao;
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
@Controller("google")
public class GoogleController {

	Session session;

	private static final String GG_REDIRECT_URI = "http://localhost:8086/MbassLayer/mbaasprojects";

	private static String accessToken = "";

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	ClientCredentialsDao dao;

	private String code = "";

	JSONObject jsonObj;

	public static final String GG_APP_ID = "1063203149782-3c2mc0mgb6b1uu4ta9hj720c1ecoopdq.apps.googleusercontent.com";
	public static final String GG_APP_SECRET = "glOO8FTt5F_9C8VFdvUxf3ON";

	@RequestMapping("/googlesignin")
	public String getAuthUrl() {
		String LoginUrl = "";
		try {

			LoginUrl = "https://accounts.google.com/o/oauth2/auth?" + "&scope=email%20profile" + "&redirect_uri="
					+ GG_REDIRECT_URI + "&response_type=code&client_id=" + GG_APP_ID + "&nonce=DgkRrHXmyu3KLd0KDdfq";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + LoginUrl;
	}

	// getting Authcode here
	@RequestMapping(value = "/googlerequest", method = RequestMethod.GET)
	public ModelAndView google(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// getiing the autherazation code
		code = req.getParameter("code");

		System.out.println("Authorization Code : " + code);

		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		// getting accesstoken here by exchanging the autherization code with
		// provider
		String googleaccessToken = getAccessToken(code);

		System.out.println(googleaccessToken);
		// paasing the accesstoken to GoogleGraph graph method to access the
		// user
		// details
		// getting the graph user in json format
		String graph = getGoogleGraph(googleaccessToken);
		// passing the graph to get graph data for getting the graph from given
		// json fromat
		Map<String, String> ProfileData = getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>BRIDGEMBAAS</h1>");
		out.println("<h2>Google Application Main Menu</h2>");
		out.println("<div>Welcome " + ProfileData.get("fullname"));
		out.println("<div>Your first_name: " + ProfileData.get("first_name"));
		out.println("<div>Your last_name: " + ProfileData.get("last_name"));
		out.println("<div>You are " + ProfileData.get("gender"));
		out.println("<div>Your'e birthday " + ProfileData.get("birthday"));
		out.println("<div>About :" + ProfileData.get("bio"));
		return new ModelAndView("DataSaved");

	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	public String getGraphUrl(String code) {
		System.out.println(code);
		String GraphUrl = "";
		try {

			GraphUrl = "https://accounts.google.com/o/oauth2/token?" + "code=" + code + "grant_type=authorization_code"
					+ "&client_id=" + GG_APP_ID + "&client_secret=" + GG_APP_SECRET + "&redirect_uri="
					+ GG_REDIRECT_URI;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return GraphUrl;
	}

	// Exchanging Code and Generating Access Token Here
	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL GraphURL;
			try {
				GraphURL = new URL(getGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection GoogleConnection;
			StringBuffer b = null;
			try {
				GoogleConnection = GraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(GoogleConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Google " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APIProvider
			if (accessToken.startsWith("[")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		System.out.println(accessToken);
		return accessToken;
	}

	// get graph data
	public String getGoogleGraph(String accessToken) {
		String graph = null;
		try {

			String g = "https://www.googleapis.com/plus/v1/people/me?access_token=" + accessToken;
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

	public Map<String, String> getGraphData(String GoogleGraph) {
		Map<String, String> Profile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(GoogleGraph);
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
			throw new RuntimeException("ERROR in parsing Google graph data. " + e);
		}
		return Profile;
	}

}
