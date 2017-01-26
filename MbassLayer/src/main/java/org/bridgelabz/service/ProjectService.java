package org.bridgelabz.service;

import java.util.List;

import org.bridgelabz.model.Projects;

public interface ProjectService 
{
	public boolean checkPName(String projectname);
	public void addProject(Projects project);
	public List<String> retrieveProjectNames(String yourprojectname);
	public List<String> displayallnames();
	public String retrievejsondetails(String k);
	public String addalldetailstojson(String k,String username,String password);
}
