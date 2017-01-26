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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bridgelabz.controllers.Dashboard;
import org.bridgelabz.dao.ClientCredentialsDao;
import org.bridgelabz.enums.SocialProvider;
import org.bridgelabz.model.GitHubDetails;
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
@Controller("github")
public class GitHubController {

	Session session;

	private static String accessToken = "";

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	ClientCredentialsDao dao;

	private String code = "";

	JSONObject jsonObj;

	private String GH_REDIRECT_URI = "http://localhost:8086/MbassLayer/github";
	// Invoking a authentication url

	@RequestMapping(value = "/githubrequest", method = RequestMethod.GET)
	public String getAuthUrl() {
		String LoginUrl = "";
		try {

			LoginUrl = "https://github.com/login/oauth/authorize?" + "client_id="
					+ dao.credentials(Dashboard.globalname, SocialProvider.GITHUB).get(0) + "&redirect_uri="
					+ GH_REDIRECT_URI + "&scope=user";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + LoginUrl;
	}

	/*
	 * GitHub Controller
	 */

	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public ModelAndView GitHub(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// getiing the autherazation code
		code = req.getParameter("code");

		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		// getting accesstoken here by exchanging the autherization code with
		// provider
		String accessToken = getAccessToken(code);

		// getting the graph user in json format
		String graph = getGitHubGraph(accessToken);

		// passing the graph to get graph data for getting the graph from given
		// json fromat
		Map<String, String> ProfileData = getGraphData(graph);

		// getting the parsed user provider id here
		session = sessionFactory.openSession();
		GitHubDetails details = new GitHubDetails();
		details.setAccessToken(accessToken);
		details.setProjectName(Dashboard.globalname);
		details.setGithubId(ProfileData.get("id"));
		details.setLogin(ProfileData.get("login"));
		details.setFollowers_url(ProfileData.get("followers_url"));
		details.setRepos_url(ProfileData.get("repos_url"));
		details.setBio(ProfileData.get("bio"));
		details.setAvatar_url(ProfileData.get("avatar_url"));
		details.setName(ProfileData.get("name"));
		details.setLocation(ProfileData.get("location"));
		details.setCreated_at(ProfileData.get("created_at"));
		details.setUpdated_at(ProfileData.get("updated_at"));
		session.save(details);
		session.close();
		return new ModelAndView("DataSaved");
	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	// creating a connection to grapghurl
	public String getGraphUrl(String code) {
		String GraphUrl = "";
		try {

			GraphUrl = "https://github.com/login/oauth/access_token?client_id="
					+ dao.credentials(Dashboard.globalname,SocialProvider.GITHUB).get(0) + "&redirect_uri=" + GH_REDIRECT_URI
					+ "&client_secret=" + dao.credentials(Dashboard.globalname, SocialProvider.GITHUB).get(1) + "&code="
					+ code;

		} catch (Exception e) {
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
				// openingConnection of fbgraph url
				Connection = GraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				// reading a accesstoken from jsp page
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with GitHub " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APiProvider
			if (accessToken.startsWith("{")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		System.out.println(accessToken);
		return accessToken;
	}

	public String getGitHubGraph(String accesstoken) {
		String graph = null;
		try {

			String g = "https://api.github.com/user?" + accessToken;
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
			throw new RuntimeException("ERROR in getting graph data. " + e);
		}
		return graph;
	}

	public Map<String, String> getGraphData(String GithubGraph) {
		Map<String, String> Profile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(GithubGraph);
			Profile.put("id", json.getString("id"));
			Profile.put("login", json.getString("login"));
			if (json.has("followers_url"))
				Profile.put("followers_url", json.getString("followers_url"));
			if (json.has("repos_url"))
				Profile.put("repos_url", json.getString("repos_url"));
			if (json.has("bio"))
				Profile.put("bio", json.getString("bio"));
			if (json.has("avatar_url"))
				Profile.put("avatar_url", json.getString("avatar_url"));
			if (json.has("name"))
				Profile.put("name", json.getString("name"));
			if (json.has("location"))
				Profile.put("location", json.getString("location"));
			if (json.has("created_at"))
				Profile.put("created_at", json.getString("created_at"));
			if (json.has("updated_at"))
				Profile.put("updated_at", json.getString("updated_at"));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return Profile;
	}

}
