package org.bridgelabz.dao;

import java.util.List;

import org.bridgelabz.model.Projects;

public interface CreationDao 
{
	public boolean checkProjectName(String projectname);
	public void addProjectName(Projects project);
	public List<String> retrieveNames(String yourprojectname);
	public List<String> displayallnames();
	public String retrievejsondetails(String k);
	public String addalldetailstojson(String k,String username,String password);
}
