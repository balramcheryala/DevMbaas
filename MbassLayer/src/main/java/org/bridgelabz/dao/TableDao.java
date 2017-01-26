package org.bridgelabz.dao;

import java.io.IOException;

import org.springframework.validation.BindingResult;

import com.google.gson.JsonArray;
public interface TableDao {
	
	public String getFile(String data, BindingResult result) throws IOException, Exception;
	public String insertJson(String data, BindingResult result) throws IOException, Exception;
	public String getDBSchema(String mSchemaName);
	public JsonArray displayAllRecords(String tableName) throws ClassNotFoundException, IOException;
	public int deleteSpecificRecord(String tableName, String column_Field_Name, String rowIdValue) throws ClassNotFoundException, IOException;
	public int updateSpecificRecord(String tableName, String column_Field_Name, String Column_Field_Value) throws ClassNotFoundException, IOException;
	public JsonArray specificRecordDisplay(String tableName, String column_Field_Name, String rowIdValue) throws ClassNotFoundException, IOException;
}
