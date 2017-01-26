package org.bridgelabz.service;

import java.util.List;

import org.bridgelabz.dao.CreationDao;
import org.bridgelabz.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService 
{
	@Autowired
	CreationDao creationDao;
	public boolean checkPName(String projectname)
	{
		System.out.println("entered");
		return creationDao.checkProjectName(projectname);
	}
	public void addProject(Projects project)
	{
		 creationDao.addProjectName(project);
	}
	public List<String> retrieveProjectNames(String yourprojectname)
	{
		return creationDao.retrieveNames(yourprojectname);
		
	}
	public List<String> displayallnames()
	{
		return creationDao.displayallnames();
	}
	public String retrievejsondetails(String k)
	{
		return creationDao.retrievejsondetails(k);
	}
	public String addalldetailstojson(String k,String username,String password)
	{
		return creationDao.addalldetailstojson(k,username,password);
	}
}
