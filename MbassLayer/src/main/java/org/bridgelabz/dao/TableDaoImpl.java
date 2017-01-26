package org.bridgelabz.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
// TODO: Auto-generated Javadoc

/**
 * The Class TableDaoImpl.
 */
/**
 * @author bridgeit
 *
 */
@Repository("dao")
public class TableDaoImpl implements TableDao {
	/** The m table name. */
	public String mTableName = null;
	
	/** The mcolumn field. */
	public String mcolumnField = null;
	
	/** The mcol data type. */
	public String mcol_data_type = null;
	/** The json objects keys. */
	public Map<String, String> pair = new HashMap<String, String>();
	/** The db connection. */
	private  final String jdbcDriver = "com.mysql.jdbc.Driver";
	
	/** The connection URL. */
	private  String connectionURL =null;
	
	/** The db connection. */
	static Connection dbConnection = null;
	
	/** The Constant USER. */
	static final String USER = "root";
	
	/** The Constant PASS. */
	static final String PASS = "root";
	/** The pstmt. */
	PreparedStatement pstmt = null;
	
	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.TableDao#getDBSchema(java.lang.String)
	 */
	public String getDBSchema(String DB_Schema_Name)
	{
		System.out.println("schema name: "+DB_Schema_Name);
		connectionURL="jdbc:mysql://localhost:3306/"+DB_Schema_Name;
		System.out.println("url :"+connectionURL);
		return connectionURL; 
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bridgelabz.dao.TableDao#getFile(java.lang.String,
	 * org.springframework.validation.BindingResult)
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public String getFile(String uploadedValidFile, BindingResult result) throws IOException, Exception {
		JSONObject jsonObject = new JSONObject(uploadedValidFile);
		// loop to get the dynamic key
		for (Object keys : jsonObject.keySet()) {
			mTableName = (String) keys;
		}
		String dataType = null;
		JSONObject valueObject = null;
		String strArray[] = null;
		JSONArray jsonArray = jsonObject.getJSONArray(mTableName);
		if (jsonArray != null && jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.optJSONObject(i);
				Iterator<String> iterator = (Iterator<String>) object.keys();
				while (iterator.hasNext()) {
					mcolumnField = iterator.next();
					if (mcolumnField instanceof String)
					valueObject = new JSONObject(object.get(mcolumnField).toString());
					dataType = valueObject.getString("type");
					mcol_data_type = returnDataType(dataType);
					pair.put(mcolumnField, mcol_data_type);
				}
			}
		}
		try {
			dbConnection = getConnection();
			DatabaseMetaData dbm = dbConnection.getMetaData();
			// check if table is there
			ResultSet table = dbm.getTables(null, null, mTableName, null);
			if (table.next()) {
				// Table exists
				System.out.println("table name already exist in Database..!");
			} 
			else
			{
				// Table does not exist
				// create SQL query to create new table Team
				String query = null;
				String id = "bridge_id int AUTO_INCREMENT PRIMARY KEY";
				System.out.println("tablename :" + mTableName);
				query = "create table " + mTableName + "( " + id + ",";
				Iterator itr = pair.entrySet().iterator();
				Set<Map.Entry<String, String>> entrySet = pair.entrySet();
				for (int i = 0; i < entrySet.size(); i++) {
					Map.Entry pairs = (Map.Entry) itr.next();
					query = query + pairs.getKey() + " " + pairs.getValue();
					if (i != entrySet.size() - 1) {
						query = query + ",";
					}
				}
				query = query + ");";
				System.out.println("table create query :" + query);
				// create a statement
				pstmt = dbConnection.prepareStatement(query);
				// Step 5 Executing SQL & retrieve data into ResultSet
				int sqlQueryResult = pstmt.executeUpdate();
				// output of database creation
				if (0 == sqlQueryResult) {
					System.out.println("New table created successfully");
				} else {
					System.out.println("Error in creating table");
				}
			}
				pair.clear();
			
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return "showFile";
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public  Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		try
		{
			Class.forName(jdbcDriver);
			dbConnection = DriverManager.getConnection(connectionURL, USER,PASS);
			
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		return dbConnection;
	}
	
	/**
	 * Return data type.
	 *
	 * @param data_type the data type
	 * @return the string
	 */
	public String returnDataType(String data_type) {
		String col_data_type = null;
		switch (data_type) {

		case "string":
			col_data_type = "varchar(80)";
			break;
		}
		return col_data_type;
	}


	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.TableDao#insertJson(java.lang.String, org.springframework.validation.BindingResult)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String insertJson(String jsonData, BindingResult result) throws IOException, Exception {
		JSONObject jsonObject = new JSONObject(jsonData);
		// loop to get the dynamic key
		for (Object keys : jsonObject.keySet()) {
			mTableName = (String) keys;
		}
		try {
			dbConnection = getConnection();
				Set<String> keyset = null;
				List<String> values = new ArrayList<String>();
				JSONArray jsonArray = jsonObject.getJSONArray(mTableName);
				if (jsonArray != null && jsonArray.length() > 0) {
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject object = jsonArray.optJSONObject(i);
						keyset = object.keySet();
						Iterator<String> iterator = (Iterator<String>) object.keys();
						while (iterator.hasNext()) {
							String key = iterator.next();
							String value = object.getString(key);
							values.add(value);
						}
					}
					}
				String jsonkey[] = keyset.toArray(new String[keyset.size()]);
				System.out.println("how many of keys:"+jsonkey.length);
		
				String jsonValues[] = values.toArray(new String[values.size()]);
				System.out.println("how many values :"+jsonValues.length);
				// create the MYSQL insert PreparedStatement
				String insert_Query = "insert into " + mTableName + " (";
				for (int i = 0; i < jsonkey.length; i++) {
					insert_Query = insert_Query + jsonkey[i];
					if (i != jsonkey.length - 1) {
						insert_Query = insert_Query + ",";
					}
				}
				insert_Query = insert_Query + ")" + " values" + "(";
				int index = 0;
				for (int j = 0; j < jsonkey.length; j++) {
					if (j != jsonkey.length - 1) {
						insert_Query = insert_Query + "?" + ",";
					}
				}
				insert_Query = insert_Query + "?);";
				pstmt = dbConnection.prepareStatement(insert_Query);
				for (int j = 0; j <jsonValues.length; j++) {
					pstmt.setString(++index, jsonValues[j]);
				}
				int i = pstmt.executeUpdate();
				if (i != 0) {
					System.out.println("json data inserted into Database");
				} else {
					System.out.println("not inserted");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successJson";
	}
	
	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.TableDao#displayAllRecords(java.lang.String)
	 */
	@Override
	public JsonArray displayAllRecords(String tableName)
			throws ClassNotFoundException, IOException {
		JsonArray jsonArray=new JsonArray();
		try {
			dbConnection = getConnection();
			String select_query="select * from "+tableName+';';
			pstmt=dbConnection.prepareStatement(select_query);
			ResultSet rs=pstmt.executeQuery(select_query);
			ResultSetMetaData resultSetMetaData=rs.getMetaData();
			int noOfColumn=resultSetMetaData.getColumnCount();
			for(int i=1;i<=resultSetMetaData.getColumnCount();i++);
			{
				while(rs.next())
				{
					JsonObject js=new JsonObject();
					for(int j=1;j<=noOfColumn;j++){
						js.addProperty(resultSetMetaData.getColumnLabel(j), rs.getString(j));

					}
					jsonArray.add(js);;
				}
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return jsonArray;
	}
	
	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.TableDao#deleteSpecificRecord(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteSpecificRecord(String tableName, String column_Field_Name, String rowIdValue) throws ClassNotFoundException, IOException {
		int i=0;
		try {
			dbConnection = getConnection();
			String deleteQuery="delete from "+tableName+" where "+column_Field_Name+"="+"'"+rowIdValue+"'"+';';
			pstmt=dbConnection.prepareStatement(deleteQuery);
			  i = pstmt.executeUpdate();
			    if (i != 0) {
			    	System.out.println("deleted");
			    } else {
			        System.out.println("not deleted");
			    }
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return i;
	
	}
	
	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.TableDao#updateSpecificRecord(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int updateSpecificRecord(String tableName, String column_Field_Name, String Column_Field_Value)
			throws ClassNotFoundException, IOException {
		int i=0;
		try {
			dbConnection = getConnection();
			String updateQuery="update "+tableName+" set "+column_Field_Name+"="+"'"+Column_Field_Value+"'"+';';
			pstmt=dbConnection.prepareStatement(updateQuery);
			  i = pstmt.executeUpdate();
			    if (i != 0) {
			    	 System.out.println("updated");
			    } else {
			    	System.out.println("not updated");
			    }
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return i;
	}
	
	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.TableDao#specificRecordDisplay(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JsonArray specificRecordDisplay(String tableName, String column_Field_Name, String rowIdValue) throws ClassNotFoundException, IOException {
		JsonArray jsonArray=new JsonArray();
		try {
			dbConnection = getConnection();
			String select_query="select * from "+tableName+" where "+column_Field_Name+"="+rowIdValue+';';
			pstmt=dbConnection.prepareStatement(select_query);
			ResultSet rs=pstmt.executeQuery(select_query);
			ResultSetMetaData resultSetMetaData=rs.getMetaData();
			int noOfColumn=resultSetMetaData.getColumnCount();
			for(int i=1;i<=resultSetMetaData.getColumnCount();i++);
			{
				while(rs.next())
				{
					JsonObject js=new JsonObject();
					for(int j=1;j<=noOfColumn;j++){
						js.addProperty(resultSetMetaData.getColumnLabel(j), rs.getString(j));

					}
					jsonArray.add(js);;
				}
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return jsonArray;
	}
	
}
