package org.bridgelabz.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Projectname {
	@Size(min = 4, max = 20, message = "The length must be between {min} and {max}")
	@Pattern(regexp = "[a-zA-Z0-9-!' ]+", message = "Only digits,letters,spaces,-,! & ''  are allowed. ")
	@NotEmpty(message = "Project Name cannot be empty")
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
