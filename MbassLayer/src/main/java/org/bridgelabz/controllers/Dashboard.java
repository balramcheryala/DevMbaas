package org.bridgelabz.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.bridgelabz.form.Projectname;
import org.bridgelabz.model.Projects;
import org.bridgelabz.service.ProjectService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("project")

// This controller is used to control and handle all the activities related to
// creation of an app page.
public class Dashboard {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProjectService projectService;
	@Autowired
	UploadController controller;
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz1234567890";
	private static final int RANDOM_STRING_LENGTH = 4;

	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bridgelabz";

	static final String USER = "root";
	static final String PASS = "ammy";

	String k;
	public static String globalname;

	@RequestMapping(value = "/overview")
	public ModelAndView displaydashboard(@RequestParam(value = "projectname", required = true) String pName,
			Projectname projectname) {
		String s = k;
		controller.getDBSchema(s);
		globalname = pName;
		System.out.println(s);
		System.out.println("126666");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", pName);
		controller.getProjectName(pName);
		model.put("schema", s);
		return new ModelAndView("projectoverview", model);
	}

	@RequestMapping(value = "/addmbaas", method = RequestMethod.GET)
	public String downloadjson(@RequestParam(value = "packagename", required = true) String packagename, Map model) {

		System.out.println("inserting data in table...");
		createappclientandsecret(packagename);
		String filePath = projectService.addalldetailstojson(k, USER, PASS);
		System.out.println(filePath);
		System.out.println(packagename);
		String sql3 = "INSERT INTO APPCONFIG (packagename,configfile) values (?, ?)";

		try {
			Connection conn3;
			String DB_URL3 = "jdbc:mysql://localhost:3306/" + k;
			conn3 = DriverManager.getConnection(DB_URL3, USER, PASS);
			PreparedStatement statement = conn3.prepareStatement(sql3);
			statement.setString(1, packagename);
			InputStream inputStream = new FileInputStream(new File(filePath));
			statement.setBlob(2, inputStream, new File(filePath).length());
			statement.executeUpdate();
			System.out.println("hii4");
			statement.close();
			conn3.close();
		} catch (Exception e1) {
			System.out.println("hii2");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("789");
		return "redirect:poverview";
	}

	@RequestMapping(value = "/poverview")
	public ModelAndView displaydashboard() {
		String s = k;
		System.out.println(s);
		System.out.println("126666");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", globalname);
		model.put("schema", s);
		System.out.println("hi h r u");
		return new ModelAndView("projectconfig", model);
	}

	// This method is used to process the entered login data.
	@RequestMapping(value = "/project")
	public ModelAndView processForm(@RequestParam(value = "name", required = true) String fieldName,
			Projectname projectname) {
		System.out.println("value from js " + fieldName);

		Map<String, Object> model = new HashMap<String, Object>();
		projectname.setProjectName(fieldName);
		System.out.println(projectname.getProjectName());
		boolean pnameexists = projectService.checkPName(projectname.getProjectName());
		System.out.println("result :" + pnameexists);
		if (!pnameexists) {
			System.out.println("568vhb");

			Projects project = prepareModel(projectname);
			System.out.println("i am");
			projectService.addProject(project);
			model.put("Projectlist", projectService.retrieveProjectNames(project.getProjectName()));
			System.out.println("we are");
			return new ModelAndView("Projectlist", model);
		} else {

			System.out.println("checking ping...");
			return new ModelAndView("demo", model);
		}
	}

	@SuppressWarnings("static-access")
	private Projects prepareModel(Projectname projectname) {
		Projects project = new Projects();
		project.setProjectName(projectname.getProjectName());
		UUID uidprojectnumber = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		project.setProjectNumber(uidprojectnumber.randomUUID().toString());
		k = project.getProjectName() + generateRandomString();
		project.setProjectURL("http://localhost:8086 F/JsonUpload/" + k);
		project.setSchemaName(k);
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement s = null;
		try {
			s = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String database = "CREATE SCHEMA " + k;
			s.executeUpdate(database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("database created....");
		try {
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn1 = null;
		try {
			String DB_URL1 = "jdbc:mysql://localhost:3306/" + k;
			conn1 = DriverManager.getConnection(DB_URL1, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Creating table in given database...");
		Statement stmt = null;
		try {
			stmt = conn1.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "CREATE TABLE APPS " + "(appid INTEGER not NULL AUTO_INCREMENT, " + " appname VARCHAR(255), "
				+ " appkey VARCHAR(255), " + " appsecret VARCHAR(255), " + " PRIMARY KEY ( appid ))";
		String sql1 = "CREATE TABLE ProjectUser " + "(projectid INTEGER not NULL, " + " emailid VARCHAR(255), "
				+ " password VARCHAR(255), " + " createddate DATE, " + " PRIMARY KEY ( projectid ))";
		String sql2 = "CREATE TABLE APPCONFIG " + "(personid int(11) NOT NULL AUTO_INCREMENT,"
				+ " packagename VARCHAR(255), " + " configfile blob," + " PRIMARY KEY ( personid ))";

		try {
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not executed...");
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return project;
	}

	@SuppressWarnings("static-access")
	private void createappclientandsecret(String appname) {
		String sql3 = "INSERT INTO APPS (appname,appkey,appsecret) values (?, ?,?)";

		try {
			Connection conn3;
			String DB_URL3 = "jdbc:mysql://localhost:3306/" + k;
			conn3 = DriverManager.getConnection(DB_URL3, USER, PASS);
			PreparedStatement statement = conn3.prepareStatement(sql3);
			statement.setString(1, appname);

			statement.setString(2, UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d").randomUUID().toString());
			statement.setString(3, UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d").randomUUID().toString());
			statement.executeUpdate();
			System.out.println("hii4");
			statement.close();
			conn3.close();
		} catch (Exception e1) {
			System.out.println("hii2");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public String generateRandomString() {

		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

}
