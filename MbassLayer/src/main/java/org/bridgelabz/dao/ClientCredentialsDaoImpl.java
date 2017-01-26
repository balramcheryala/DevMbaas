package org.bridgelabz.dao;

import java.util.ArrayList;
import java.util.List;

import org.bridgelabz.enums.SocialProvider;
import org.bridgelabz.model.ClientCredentialsModel;
import org.bridgelabz.model.FacebookDetails;
import org.bridgelabz.service.ClientDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*implements ClientCredentialsModelDao.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public class ClientCredentialsDaoImpl implements ClientCredentialsDao {
	@Autowired
	private SessionFactory sessionFactory;

	Session session;

	public void addClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().save(clientcredentialmodel);

	}

	public void updateClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().update(clientcredentialmodel);

	}

	@SuppressWarnings("unchecked")
	public List<ClientCredentialsModel> listClientCredentials() {

		return sessionFactory.openSession().createCriteria(ClientCredentialsModel.class).list();
	}

	public ClientCredentialsModel getClientCredentials(int id) {
		return (ClientCredentialsModel) sessionFactory.openSession().get(ClientCredentialsModel.class, id);

	}

	public void deleteClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession()
				.createQuery("DELETE FROM ClientCredentialsModel WHERE id = " + clientcredentialmodel.getId())
				.executeUpdate();

	}

	// getting accesstoken from here
	@Override
	public String AccessToken(String projectname, String tableName) {
		String accessToken = "";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery("from " + tableName + " where projectName = ?");
		query.setParameter(0, projectname);
		List<FacebookDetails> list = query.list();
		for (FacebookDetails fd : list) {
			accessToken = fd.getAccessToken();
		}
		System.out.println("access token:" + accessToken);
		return accessToken;
	}

	// getting the clientid and Client passwords Here
	@Override
	public ArrayList<String> credentials(String projectName, SocialProvider socialProvider) {
		// TODO Auto-generated method stub
		String appId;
		String appSecret;
		ArrayList<String> arrayList = new ArrayList<String>();
		Session s = sessionFactory.openSession();
		System.err.println("project name and provider:" + projectName + " " + socialProvider);
		Query query = s.createQuery("from ClientCredentialsModel where projectName = ? and provider = ?");
		query.setParameter(0, projectName);
		query.setParameter(1, socialProvider);
		List<ClientCredentialsModel> queryListData = query.list();
		for (ClientCredentialsModel eachListData : queryListData) {
			appId = eachListData.getClientid();
			appSecret = eachListData.getClientpassword();
			System.out.println("app id and secret:" + appId + " " + appSecret);
			arrayList.add(appId);
			arrayList.add(appSecret);
		}
		return arrayList;
	}

}
