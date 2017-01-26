package org.bridgelabz.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.bridgelabz.dao.CreationDao;
import org.bridgelabz.model.Client;
import org.bridgelabz.model.ClientInfo;
import org.bridgelabz.model.Example;
import org.bridgelabz.model.OauthClient;
import org.bridgelabz.model.ProjectInfo;
import org.bridgelabz.model.Projects;

public class CreationDaoImpl implements CreationDao
{
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("rawtypes")
	public boolean checkProjectName(String projectname) 
	{
		System.out.println("entered2");
		boolean projectFound=false;
		Session session=sessionFactory.openSession();
		String SQL_QUERY =" from Projects as p where p.projectName=? ";
		Query query=session.createQuery(SQL_QUERY);
		query.setParameter(0, projectname);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) 
		{
			System.out.println("43");
			projectFound = true;
		}
		session.close();
		return projectFound;
	}
	public void addProjectName(Projects project)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(project);
		tx.commit();
	}
	@SuppressWarnings("unchecked")
	public List<String> displayallnames()
	{
		 Session session = sessionFactory.openSession();
		 Query query=null;
		 List<String> arrlist=new ArrayList<String>();
		 String SQL_QUERY1=null;
		 System.out.println("kkkkk");
		 SQL_QUERY1 ="FROM Projects E ";
		 query = session.createQuery(SQL_QUERY1);
		 arrlist = query.list();
		 if(arrlist != null  && (arrlist.size() > 0))
		 {
			 System.out.println("ttt");
			 session.close();
			 return arrlist;
		 }
		 return null;
	}
	@SuppressWarnings("unchecked")
	public String retrievejsondetails(String k)
	{
		String file=null;
		Session session = sessionFactory.openSession();
		 Query query=null;
		 List<String> arrlist=new ArrayList<String>();
		 String SQL_QUERY1=null;
		 System.out.println("kkkkk");
		 SQL_QUERY1 ="FROM Projects E where schemaName=?";
		 
		 query = session.createQuery(SQL_QUERY1);
		 query.setParameter(0, k);
		 arrlist = query.list();
		 Gson gson=new GsonBuilder().serializeNulls().create();
		 String jsonArray=gson.toJson(arrlist);
		 System.out.println(jsonArray);
		 ObjectMapper mapper = new ObjectMapper();
	 	try {
			jsonArray= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrlist);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 PrintWriter out=null;
		try {
			file="/home/bridgeit/Desktop/"+k+".txt";
			out = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Occurred:");
		}
		 out.println(jsonArray);
		 out.close();
		 return file;
	}
	@SuppressWarnings("unchecked")
	public List<String> retrieveNames(String yourprojectname) 
	{
		 Session session = sessionFactory.openSession();
		 Query query=null;
		 List<String> arrlist=new ArrayList<String>();
		 String SQL_QUERY1=null;
		 System.out.println("kkkkk");
		 SQL_QUERY1 ="FROM Projects E";
		 
		 query = session.createQuery(SQL_QUERY1);
		// query.setParameter(0, yourprojectname);
		 arrlist = query.list();
		
		 if(arrlist != null  && (arrlist.size() > 0))
		 {
			 System.out.println("ttt");
			 session.close();
			 return arrlist;
		 }
		 return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String addalldetailstojson(String schema,String dbUser,String dbPass)
	{
		    String file=null;
		    PrintWriter out=null;
		    List<Client> clientlist=new ArrayList();
		    Example exm=new Example();
		    //String schema = request.getParameter("schemaname") ;
	        System.out.println("schemaaaa: "+schema);
	        String dbURL = "jdbc:mysql://localhost:3306/"+schema;
	        Connection conn = null; // connection to the database
	         
	        try 
	        {
	            // connects to the database
	            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	             try 
	             {
					Class.forName("com.mysql.jdbc.Driver");
				 } 
	             catch (ClassNotFoundException e) 
	             {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
	             conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	             // queries the database
	             String sql = "select * from APPS";
	             PreparedStatement statement = conn.prepareStatement(sql);
	             //statement.setInt(1, uploadId);
	             ResultSet result = statement.executeQuery();
	             ClientInfo clientinfo=new ClientInfo();
	             OauthClient oauthinfo=new OauthClient();
	             Client client=new Client();
	             if (result.next()) 
	             {
	                // gets file name and file blob data
	                String appName = result.getString("appname");
	                clientinfo.setPackageName(appName);
	                String appKey = result.getString("appkey");
	                oauthinfo.setClientId(appKey);
	                String appSecret = result.getString("appsecret");
	                oauthinfo.setClientSecret(appSecret);
	                client.setClientInfo(clientinfo);
		            client.setOauthClient(oauthinfo);
		           
		            clientlist.add(client);
	            }
	        }
	        catch(Exception e)
			{
			   System.out.println(e);
			}
            //String schema = request.getParameter("schemaname") ;
	        //System.out.println("schemaaaa: "+schema);
	        String dbURL1 = "jdbc:mysql://localhost:3306/bridgelabz";
	        Connection conn1 = null; // connection to the database
	        try 
	        {
	            // connects to the database
	            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            try 
	            {
					Class.forName("com.mysql.jdbc.Driver");
				} 
	            catch (ClassNotFoundException e) 
	            {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            conn1 = DriverManager.getConnection(dbURL1, dbUser, dbPass);
	            // queries the database
                String sql1 = "select * from bridgeprojectdetails where schemaName LIKE '%"+schema+"%'";
                PreparedStatement statement = conn1.prepareStatement(sql1);
                //statement.setInt(1, uploadId);
                ResultSet result = statement.executeQuery();
                ProjectInfo projectinfo=new ProjectInfo();
                if (result.next()) 
                {
	                // gets file name and file blob data
	                int projectId = result.getInt("projectId");
	                projectinfo.setProjectId(projectId);
	                String projectName=result.getString("projectName");
	                projectinfo.setProjectName(projectName);
	                String projectNumber=result.getString("projectNumber");
	                projectinfo.setProjectNumber(projectNumber);
	                String projectUrl=result.getString("projectURL");
	                projectinfo.setProjectURL(projectUrl);
	                String schemaName=result.getString("schemaName");
	                projectinfo.setSchemaName(schemaName);
                }
                exm.setProjectInfo(projectinfo);
                exm.setClient(clientlist);
                Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
                String jsonArray=gson.toJson(exm,Example.class);
               
                file="/home/bridgeit/Desktop/"+"bridgeembaas"+".txt";
				out = new PrintWriter(file);
	            
		        out.println(jsonArray);
				out.close();
				
	       }
		   catch(Exception e)
	       {
			   System.out.println(e);
	       }
	        return file;
	}
}    
