package org.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*class LinkedInDetails
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

@Entity
@Table(name = "LinkedInDetails")
public class LinkedInDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "LinkedinId")
	private String LinkedinId;

	@Column(name = "projectName")
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "accessToken")
	private String accessToken;

	@Column(name = "headline")
	private String headline;

	@Column(name = "industry")
	private String industry;

	@Column(name = "pictureUrl")
	private String pictureUrl;

	@Column(name = "publicProfileUrl")
	private String publicProfileUrl;

	public String getLinkedinId() {
		return LinkedinId;
	}

	public void setLinkedinId(String linkedinId) {
		LinkedinId = linkedinId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPublicProfileUrl() {
		return publicProfileUrl;
	}

	public void setPublicProfileUrl(String publicProfileUrl) {
		this.publicProfileUrl = publicProfileUrl;
	}
}
