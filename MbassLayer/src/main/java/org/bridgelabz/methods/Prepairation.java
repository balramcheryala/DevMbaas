package org.bridgelabz.methods;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.bridgelabz.form.ClientCredentialsBean;
import org.bridgelabz.form.ClientDetailsBean;
import org.bridgelabz.model.ClientCredentialsModel;
import org.bridgelabz.model.ClientDetailsModel;
import org.hibernate.Session;

/*class Prepairation
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public class Prepairation {

	// Importing Session
	Session session;

	// Preparing prepareModel
	public ClientDetailsModel prepareModel(ClientDetailsBean clientdetailsbean) {

		ClientDetailsModel clientdetailsmodel = new ClientDetailsModel();

		clientdetailsmodel.setId(clientdetailsbean.getId());
		clientdetailsmodel.setEmail(clientdetailsbean.getEmail());
		clientdetailsmodel.setPassword(clientdetailsbean.getPassword());
		clientdetailsmodel.setProviders(providers());
		clientdetailsmodel.setSignedin(date());
		clientdetailsmodel.setCreated(date());
		clientdetailsmodel.setUseruid(randomUUID());
		clientdetailsbean.setId(null);
		return clientdetailsmodel;
	}

	// Preparing prepareModelforCredentialsBean
	public ClientCredentialsModel prepareModelforCredentialsBean(ClientCredentialsBean clientcredentialsbean) {

		ClientCredentialsModel clientcredentialsmodel = new ClientCredentialsModel();
		clientcredentialsmodel.setId(clientcredentialsbean.getId());
		clientcredentialsmodel.setClientid(clientcredentialsbean.getClientid());
		clientcredentialsmodel.setProvider(clientcredentialsbean.getProvider());
		clientcredentialsmodel.setProjectName(clientcredentialsbean.getProjectName());
		clientcredentialsmodel.setClientpassword(clientcredentialsbean.getClientpassword());

		return clientcredentialsmodel;
	}

	// Preparing prepareListofCredentialsBean
	public List<ClientDetailsBean> prepareListofBean(List<ClientDetailsModel> clientdetailsmodellist) {
		List<ClientDetailsBean> beans = null;

		if (clientdetailsmodellist != null && !clientdetailsmodellist.isEmpty()) {
			beans = new ArrayList<ClientDetailsBean>();
			ClientDetailsBean clientdetailbean = null;
			for (ClientDetailsModel clientdetailmodel : clientdetailsmodellist) {
				clientdetailbean = new ClientDetailsBean();
				clientdetailbean.setId(clientdetailmodel.getId());
				clientdetailbean.setPassword(clientdetailmodel.getPassword());
				clientdetailbean.setEmail(clientdetailmodel.getEmail());
				clientdetailbean.setProviders(providers());
				clientdetailbean.setCreated(date());
				clientdetailbean.setSignedin(date());
				clientdetailbean.setUseruid(randomUUID());
				beans.add(clientdetailbean);
			}
		}
		return beans;
	}

	// Preparing prepareListofCredentialsBean
	public List<ClientCredentialsBean> prepareListofCredentialsBean(
			List<ClientCredentialsModel> clientcredentialsmodelist) {
		List<ClientCredentialsBean> clientcredentialsbeans = null;

		if (clientcredentialsmodelist != null && !clientcredentialsmodelist.isEmpty()) {
			clientcredentialsbeans = new ArrayList<ClientCredentialsBean>();
			ClientCredentialsBean clientcredentialbean = null;
			for (ClientCredentialsModel crud : clientcredentialsmodelist) {
				clientcredentialbean = new ClientCredentialsBean();
				clientcredentialbean.setId(crud.getId());
				clientcredentialbean.setClientid(crud.getClientid());
				clientcredentialbean.setProvider(crud.getProvider());
				clientcredentialbean.setProjectName(crud.getProjectName());
				clientcredentialbean.setClientpassword(crud.getClientpassword());
				System.out.println(clientcredentialbean);
			}
		}
		return clientcredentialsbeans;

	}

	// Preparing prepareCrudBean
	public ClientDetailsBean prepareCrudBean(ClientDetailsModel clientdatailsmodel) {

		ClientDetailsBean clientdetailsbean = new ClientDetailsBean();
		clientdetailsbean.setId(clientdatailsmodel.getId());
		clientdetailsbean.setEmail(clientdatailsmodel.getEmail());
		clientdetailsbean.setPassword(clientdatailsmodel.getPassword());
		clientdetailsbean.setProviders(providers());
		clientdetailsbean.setCreated(date());
		clientdetailsbean.setSignedin(date());
		clientdetailsbean.setUseruid(randomUUID());
		return clientdetailsbean;
	}

	// Preparing prepareCredentialsBean
	public ClientCredentialsBean prepareCredentialsBean(ClientCredentialsModel clientcredentialmodel) {

		ClientCredentialsBean clientcredentialbean = new ClientCredentialsBean();
		clientcredentialbean.setId(clientcredentialmodel.getId());
		clientcredentialbean.setClientid(clientcredentialmodel.getClientid());
		clientcredentialbean.setClientpassword(clientcredentialmodel.getClientpassword());
		clientcredentialbean.setProvider(clientcredentialmodel.getProvider());
		clientcredentialbean.setProjectName(clientcredentialmodel.getProjectName());
		return clientcredentialbean;
	}

	// Preparing randomUUID
	@SuppressWarnings("static-access")
	public String randomUUID() {
		UUID uid = UUID.fromString("12300000-1ab0-11bd-b23e-10b96e4ef00d");

		return (uid.randomUUID()).toString();
	}

	// Preparing providers
	public String providers() {

		String pattern = "LOCAL";
		return pattern;
	}

	// Preparing date
	public String date() {

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		return date;
	}

}
