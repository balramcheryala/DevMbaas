package org.bridgelabz.form;

/*Class CredentialsBean.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public class ClientCredentialsBean {

	/** The id. */
	private int id;

	/** The clientid. */
	private String clientid;

	private String provider;

	private String projectName;

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider
	 *            the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the clientid.
	 *
	 * @return the clientid
	 */
	public String getClientid() {
		return clientid;
	}

	/**
	 * Sets the clientid.
	 *
	 * @param clientid
	 *            the new clientid
	 */
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**
	 * Gets the clientpassword.
	 *
	 * @return the clientpassword
	 */
	public String getClientpassword() {
		return clientpassword;
	}

	/**
	 * Sets the clientpassword.
	 *
	 * @param clientpassword
	 *            the new clientpassword
	 */
	public void setClientpassword(String clientpassword) {
		this.clientpassword = clientpassword;
	}

	/** The clientpassword. */
	private String clientpassword;
}
