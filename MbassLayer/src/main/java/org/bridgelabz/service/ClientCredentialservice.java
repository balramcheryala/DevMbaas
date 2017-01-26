package org.bridgelabz.service;

import java.util.List;

import org.bridgelabz.model.ClientCredentialsModel;

/*class interface ClientCredentialservice
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public interface ClientCredentialservice {

	public void addClientCredentials(ClientCredentialsModel crud);

	public void updateClientCredentials(ClientCredentialsModel crud);

	public List<ClientCredentialsModel> listClientCredentialss();

	public ClientCredentialsModel getClientCredentials(int stdid);

	public void deleteClientCredentials(ClientCredentialsModel crud);

}
