package org.bridgelabz.model;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Client {

@SerializedName("client_info")
@Expose
private ClientInfo clientInfo;
@SerializedName("oauth_client")
@Expose
private OauthClient oauthClient;

/**
* 
* @return
* The clientInfo
*/
public ClientInfo getClientInfo() {
return clientInfo;
}

/**
* 
* @param clientInfo
* The client_info
*/
public void setClientInfo(ClientInfo clientInfo) {
this.clientInfo = clientInfo;
}

/**
* 
* @return
* The oauthClient
*/
public OauthClient getOauthClient() {
return oauthClient;
}

/**
* 
* @param oauthClient
* The oauth_client
*/
public void setOauthClient(OauthClient oauthClient) {
this.oauthClient = oauthClient;
}

}