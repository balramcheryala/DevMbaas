package org.bridgelabz.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Example {

@SerializedName("project_info")
@Expose
private ProjectInfo projectInfo;
@SerializedName("client")
@Expose
private List<Client> client = new ArrayList<Client>();

/**
* 
* @return
* The projectInfo
*/
public ProjectInfo getProjectInfo() {
return projectInfo;
}

/**
* 
* @param projectInfo
* The project_info
*/
public void setProjectInfo(ProjectInfo projectInfo) {
this.projectInfo = projectInfo;
}

/**
* 
* @return
* The client
*/
public List<Client> getClient() {
return client;
}

/**
* 
* @param client
* The client
*/
public void setClient(List<Client> client) {
this.client = client;
}

}