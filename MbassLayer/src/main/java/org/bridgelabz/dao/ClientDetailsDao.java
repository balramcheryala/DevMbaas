package org.bridgelabz.dao;

import java.util.List;

import org.bridgelabz.model.ClientDetailsModel;

/*interface ClientDetailsDao.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public interface ClientDetailsDao {

	public void addClientDetails(ClientDetailsModel clientdetailmodel);

	public void updateClientDetails(ClientDetailsModel clientdetailmodel);

	public List<ClientDetailsModel> listClientDetails();

	public ClientDetailsModel getClientDetails(int id);

	public void deleteClientDetails(ClientDetailsModel clientdetailmodel);
}
