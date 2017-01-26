package org.bridgelabz.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ClientInfo {

@SerializedName("package_name")
@Expose
private String packageName;

/**
* 
* @return
* The packageName
*/
public String getPackageName() {
return packageName;
}

/**
* 
* @param packageName
* The package_name
*/
public void setPackageName(String packageName) {
this.packageName = packageName;
}

}