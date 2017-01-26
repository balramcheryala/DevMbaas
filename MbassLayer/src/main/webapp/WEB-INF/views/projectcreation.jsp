<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<body bgcolor="orange">
    <form:form method="POST" action="projectcreation.html" modelAttribute="projectcreate" commandName="projectcreate">
	<table>
		<tr>
			<td>Project Name:</td>
		</tr>
		<tr>
			<td><form:input path="projectName" /><FONT color="red"><form:errors
				path="projectName" /></FONT></td>
		</tr>
		<tr>
			<td><input type="submit" value="CREATE PROJECT" /></td>
        </tr>
	</table>
	</form:form>
</body>
</center>
</html>