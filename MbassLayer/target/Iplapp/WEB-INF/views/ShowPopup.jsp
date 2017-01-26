<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elements.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/my_js.js" />"></script>

</head>
<body id="body" style="overflow: hidden;" bgcolor="Coral">
	<!--  <h3><b>Your Registration Successfully Done.</b></h3> -->
	<!-- Display Popup Button -->
	<div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<!-- id="form"  name="form" -->

			<%
				Logger logger = Logger.getLogger(this.getClass().getName());
			%>

			<%-- <form method="POST" action="project" modelAttribute="projectcreate" commandName="projectcreate">  --%>
			<form action="#" id="form" method="post" name="form">
				<img id="close"
					src="<c:url value="/resources/images/close-button-icon.png" />"
					alt="" onclick="div_hide()" />
				<%-- <img src="<c:url value="/resources/images/left_arrow.png" />" alt="" /> --%>
				<%
					logger.info("Evaluating date ");
				%>
				<h2>Create a project</h2>
				<hr>
				<input id="name" name="name" placeholder="My awesome project"
					type="text">
				<%-- <form:input path="projectName"/> --%>
				<!-- <input id="email" name="email" placeholder="Email" type="text">
<textarea id="msg" name="message" placeholder="Message"></textarea> -->
				<!-- <button id="submit" onclick="check_empty()" >Create Project</button>  -->
				<!-- <button id="close" onclick="div_hide()" >Cancel</button>  -->
				<a href="javascript:%20check_empty()" id="submit">Create Project</a>
				<!-- <href="javascript:%20div_hide()" input type="close"  value="Cancel" />  -->
			</form>
		</div>
		<!-- Popup Div Ends Here -->
	</div>
</body>
</html>