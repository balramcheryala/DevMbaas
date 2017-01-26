package org.bridgelabz.service;

import java.util.List;

import org.bridgelabz.dao.ClientDetailsDao;
import org.bridgelabz.model.ClientDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*class implements ClientDetailsService
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClientDetailsServiceImpl implements ClientDetails {

	@Autowired
	private ClientDetailsDao cdd;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addClientDetails(ClientDetailsModel cdm) {
		cdd.addClientDetails(cdm);
	}

	public List<ClientDetailsModel> listClientDetails() {
		return cdd.listClientDetails();
	}

	public ClientDetailsModel getClientDetails(int id) {
		return cdd.getClientDetails(id);
	}

	public void deleteClientDetails(ClientDetailsModel cdm) {
		cdd.deleteClientDetails(cdm);
	}

	public void updateClientDetails(ClientDetailsModel cdm) {
		cdd.updateClientDetails(cdm);
	}

}
