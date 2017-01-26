package org.bridgelabz.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.bridgelabz.dao.TableDao;
import org.bridgelabz.model.UploadedFile;
import org.bridgelabz.util.JSONUtils;
import org.bridgelabz.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadController.
 */
@Controller("upload")
public class UploadController {

	/** The json util. */
	@Qualifier("file")
	@Autowired
	JSONUtils jsonUtil;
	/** The file validator. */
	@Autowired
	FileValidator fileValidator;
	
	/** The name. */
	String name;
	/** The table dao. */
	@Autowired
	TableDao tableDao;

	/**
	 * Gets the project name.
	 *
	 * @param projectname the projectname
	 * @return the project name
	 */
	public void getProjectName(String projectname) {
		name = projectname;
	}

	/**
	 * M bass home.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView mBassHome() {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("databaseDashBoard", model);
	}

	/**
	 * Gets the upload form.
	 *
	 * @param uploadedFile
	 *            the uploaded file
	 * @param result
	 *            the result
	 * @return the upload form
	 */
	@RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
	public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("uploadForm", model);
	}

	/**
	 * Json insertion.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView jsonInsertion() {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("insertJson", model);
	}

	/**
	 * Json display.
	 *
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public ModelAndView jsonDisplay() throws ClassNotFoundException, IOException {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("selectAllRecords", model);
	}

	/**
	 * Delete record.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/deleteId", method = RequestMethod.GET)
	public ModelAndView deleteRecord() {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("delete");
	}

	/**
	 * Update record.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateId", method = RequestMethod.GET)
	public ModelAndView updateRecord() {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("update");
	}

	/**
	 * Update record.
	 *
	 * @param request the request
	 * @return the model and view
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	@RequestMapping(value = "/updateRow", method = RequestMethod.POST)
	public ModelAndView updateRecord(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException {
		String projectName = name;
		String tableName = request.getParameter("tableName");
		String column_Field_Name = request.getParameter("columnFieldName");
		String Column_Field_Value = request.getParameter("columnFieldValue");
		int id = tableDao.updateSpecificRecord(tableName, column_Field_Name, Column_Field_Value);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", id);
		model.put("projectname", projectName);
		return new ModelAndView("updateJsp", model);
	}

	/**
	 * Delete record.
	 *
	 * @param request the request
	 * @return the model and view
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ModelAndView deleteRecord(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException {
		String projectName = name;
		String tableName = request.getParameter("tableName");
		String column_Field_Name = request.getParameter("columnFieldName");
		String rowIdValue = request.getParameter("rowId");
		int id = tableDao.deleteSpecificRecord(tableName, column_Field_Name, rowIdValue);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", id);
		model.put("projectname", projectName);
		return new ModelAndView("deleteJsp", model);
	}
	
	/**
	 * Display specific.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/specific",method=RequestMethod.GET)
	public ModelAndView displaySpecific()
	{
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("specificRecord",model);
	}
	
	/**
	 * Display specific record detail.
	 *
	 * @param request the request
	 * @return the model and view
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	@RequestMapping(value="/columnRowId",method=RequestMethod.POST)
	public ModelAndView displaySpecificRecordDetail(HttpServletRequest request)throws ServletException,IOException, ClassNotFoundException
		{
				String projectName = name;
				String tableName=request.getParameter("tableName");
				String column_Field_Name=request.getParameter("columnFieldName");
				String rowIdValue=request.getParameter("rowId");
				JsonArray jsonArray=new JsonArray();
				jsonArray =tableDao.specificRecordDisplay(tableName,column_Field_Name,rowIdValue);
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("projectname", projectName);
				model.put("jsonArray", jsonArray);
				return new ModelAndView("jsonOutPut",model);
				
	}
	/**
	 * Display specific record detail.
	 *
	 * @param request the request
	 * @return the string
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	@RequestMapping(value = "/displayAll", method = RequestMethod.POST)
	public ModelAndView selectAllRecords (HttpServletRequest request)  throws ServletException, IOException,ClassNotFoundException {
		String projectName = name;
		String tableName = request.getParameter("tableName");
		JsonArray jsonArray=new JsonArray();
		jsonArray = tableDao.displayAllRecords(tableName);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		model.put("jsonArray", jsonArray);
		return new ModelAndView("jsonOutPut",model);
	}

	/**
	 * Gets the DB schema.
	 *
	 * @param mSchemaName
	 *            the m schema name
	 * @return the DB schema
	 */
	public void getDBSchema(String mSchemaName) {
		tableDao.getDBSchema(mSchemaName);
	}

	/**
	 * Insert json key value file uploaded.
	 *
	 * @param uploadedFile the uploaded file
	 * @param result the result
	 * @return the model and view
	 * @throws Exception the exception
	 */
	@RequestMapping("/jsonData")
	public ModelAndView insertJsonKeyValueFileUploaded(@ModelAttribute("jsonFile") UploadedFile uploadedFile,
			BindingResult result) throws Exception {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		InputStream inputStream = null;
		MultipartFile file = uploadedFile.getFile();
		inputStream = file.getInputStream();
		String json = " ";
		InputStreamReader ios = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(ios);
		String line;
		while ((line = br.readLine()) != null) {
			json += line + "\n";
		}
		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {
			return new ModelAndView("insertJson", model);
		}
		boolean jsonStringValid = JSONUtils.isJSONValid(json);
		if (jsonStringValid == false) {
			return new ModelAndView("invalidJson", model);
		}
		tableDao.insertJson(json, result);
		return new ModelAndView("successJson", model);
	}

	/**
	 * File uploaded.
	 *
	 * @param uploadedFile
	 *            the uploaded file
	 * @param result
	 *            the result
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping("/fileUpload")
	public ModelAndView fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result)
			throws Exception {
		String projectName = name;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		InputStream inputStream = null;
		MultipartFile file = uploadedFile.getFile();
		inputStream = file.getInputStream();
		String data = " ";
		InputStreamReader ios = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(ios);
		String line;
		while ((line = br.readLine()) != null) {
			data += line + "\n";
		}

		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {

			return new ModelAndView("uploadForm", model);
		}
		boolean jsonStringValid = JSONUtils.isJSONValid(data);
		if (jsonStringValid == false) {
			return new ModelAndView("invalidJson", model);
		}
		tableDao.getFile(data, result);
		return new ModelAndView("showFile", model);
	}
}