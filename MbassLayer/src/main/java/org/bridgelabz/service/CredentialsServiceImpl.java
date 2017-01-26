package org.bridgelabz.service;

import java.util.List;

import org.bridgelabz.dao.ClientCredentialsDao;
import org.bridgelabz.model.ClientCredentialsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*class implements ClientCredentialservice
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CredentialsServiceImpl implements ClientCredentialservice {
	@Autowired
	private ClientCredentialsDao cruddao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addClientCredentials(ClientCredentialsModel crud) {
		cruddao.addClientCredentials(crud);

	}

	public void updateClientCredentials(ClientCredentialsModel crud) {
		cruddao.updateClientCredentials(crud);

	}

	public List<ClientCredentialsModel> listClientCredentialss() {

		return cruddao.listClientCredentials();
	}

	public ClientCredentialsModel getClientCredentials(int stdid) {

		return cruddao.getClientCredentials(stdid);
	}

	public void deleteClientCredentials(ClientCredentialsModel crud) {
		cruddao.deleteClientCredentials(crud);
	}

}
