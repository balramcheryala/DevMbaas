package org.bridgelabz.model;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class OauthClient {

@SerializedName("client_id")
@Expose
private String clientId;
@SerializedName("client-secret")
@Expose
private String clientSecret;

/**
* 
* @return
* The clientId
*/
public String getClientId() {
return clientId;
}

/**
* 
* @param clientId
* The client_id
*/
public void setClientId(String clientId) {
this.clientId = clientId;
}

/**
* 
* @return
* The clientSecret
*/
public String getClientSecret() {
return clientSecret;
}

/**
* 
* @param clientSecret
* The client-secret
*/
public void setClientSecret(String clientSecret) {
this.clientSecret = clientSecret;
}

}