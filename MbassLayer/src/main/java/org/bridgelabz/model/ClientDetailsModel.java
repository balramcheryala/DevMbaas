package org.bridgelabz.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*class ClientDetailsModel
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */


@Entity
@Table(name = "ClientDetailsModel")
public class ClientDetailsModel implements Serializable {

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -723583058586873479L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/** The email. */
	@Column(name = "email")
	private String email;

	/** The password. */
	@Column(name = "password")
	private String password;

	/** The providers. */
	@Column(name = "providers")
	private String providers;

	/** The created. */
	@Column(name = "createdDate")
	private String created;

	/** The signedin. */
	@Column(name = "signedinDate")
	private String signedin;

	/** The useruid. */
	@Column(name = "useruid")
	private String useruid;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the providers.
	 *
	 * @return the providers
	 */
	public String getProviders() {
		return providers;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the providers.
	 *
	 * @param providers
	 *            the new providers
	 */
	public void setProviders(String providers) {
		this.providers = providers;
	}



	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created
	 *            the new created
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Gets the signedin.
	 *
	 * @return the signedin
	 */
	public String getSignedin() {
		return signedin;
	}

	/**
	 * Sets the signedin.
	 *
	 * @param signedin
	 *            the new signedin
	 */
	public void setSignedin(String signedin) {
		this.signedin = signedin;
	}

	/**
	 * Gets the useruid.
	 *
	 * @return the useruid
	 */
	public String getUseruid() {
		return useruid;
	}

	/**
	 * Sets the useruid.
	 *
	 * @param string
	 *            the new useruid
	 */
	public void setUseruid(String string) {
		this.useruid = string;
	}

}
