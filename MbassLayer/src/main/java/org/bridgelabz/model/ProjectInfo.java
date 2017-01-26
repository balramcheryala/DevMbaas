package org.bridgelabz.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ProjectInfo {

@SerializedName("projectId")
@Expose
private int projectId;
@SerializedName("projectName")
@Expose
private String projectName;
@SerializedName("projectURL")
@Expose
private String projectURL;
@SerializedName("schemaName")
@Expose
private String schemaName;
@SerializedName("projectNumber")
@Expose
private String projectNumber;

/**
* 
* @return
* The projectId
*/
public int getProjectId() {
return projectId;
}

/**
* 
* @param projectId
* The projectId
*/
public void setProjectId(int projectId) {
this.projectId = projectId;
}

/**
* 
* @return
* The projectName
*/
public String getProjectName() {
return projectName;
}

/**
* 
* @param projectName
* The projectName
*/
public void setProjectName(String projectName) {
this.projectName = projectName;
}

/**
* 
* @return
* The projectURL
*/
public String getProjectURL() {
return projectURL;
}

/**
* 
* @param projectURL
* The projectURL
*/
public void setProjectURL(String projectURL) {
this.projectURL = projectURL;
}

/**
* 
* @return
* The schemaName
*/
public String getSchemaName() {
return schemaName;
}

/**
* 
* @param schemaName
* The schemaName
*/
public void setSchemaName(String schemaName) {
this.schemaName = schemaName;
}

/**
* 
* @return
* The projectNumber
*/
public String getProjectNumber() {
return projectNumber;
}

/**
* 
* @param projectNumber
* The projectNumber
*/
public void setProjectNumber(String projectNumber) {
this.projectNumber = projectNumber;
}

}

