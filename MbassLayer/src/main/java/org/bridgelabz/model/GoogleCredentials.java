package org.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*class GoogleCredentials
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

@Entity
@Table(name = "GoogleCredentials")
public class GoogleCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "app_ID")
	private String app_ID;

	@Column(name = "app_Secrete")
	private String app_Secrete;

	public String getApp_ID() {
		return app_ID;
	}

	public void setApp_ID(String app_ID) {
		this.app_ID = app_ID;
	}

	public String getApp_Secrete() {
		return app_Secrete;
	}

	public void setApp_Secrete(String app_Secrete) {
		this.app_Secrete = app_Secrete;
	}
}
