package org.bridgelabz.form;

import java.sql.Blob;

public class CustomerDTO {

	int personid;
	String packagename;
	Blob configfile;

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	public Blob getConfigfile() {
		return configfile;
	}

	public void setConfigfile(Blob configfile) {
		this.configfile = configfile;
	}
}
