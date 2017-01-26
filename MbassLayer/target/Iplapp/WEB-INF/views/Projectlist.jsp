<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>
<html>
<head>
<title>Popup contact form</title>
<!-- <link href="css/elements.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elements.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/my_js.js" />"></script>
</head>

<style>
body {
	background-color: FloralWhite;
	margin: 48px 0px 0px 64px;
}

div#topdiv {
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	color: white;
	background: DarkMagenta;
	padding: 10px;
}
</style>
<!-- Body Starts Here -->
<body id="body" style="overflow: hidden;" bgcolor="Gold">
<div class="scrollD">
	<div id="xyz">
		<div id="topdiv">
		<strong>BridgeMbaaS</strong>
		</div>
		<div id="container">
			<header></header>
			<main>
			<section class="half"></section>
			<section class="half"></section>
			</main>
		</div>

		<br>
		<center>
			<h1 class="main">
				<font color=coral>Welcome To BridgeMbaaS..!</font>
			</h1>
		</center>
		<br>
		<center>
			<button id="popup" onclick="div_show()">
				<h2 class="new_project">CREATE NEW PROJECT</h2>
			</button>
		</center>
		
	</div>
	
	<div id="abc">
		
		<div id="popupContact">
			
			<%
				Logger logger = Logger.getLogger(this.getClass().getName());
			%>

			
			<form action="#" id="form" method="post" name="form">
				<img id="close"
					src="<c:url value="/resources/images/close-button-icon.png" />"
					alt="" onclick="div_hide()" />
				
				<%
					logger.info("Evaluating date ");
				%>
				<h2>Create a project</h2>
				<hr>
				<input id="name" name="name" placeholder="My Project"
					type="text">
				
				<a href="javascript:%20check_empty()" id="submit">Create Project</a>
				
			</form>
		</div>
		
	</div>
	
</form>
	<c:if test="${!empty Projectlist}">
		<div class="wrapper">
			<c:forEach items="${Projectlist}" var="projectname" varStatus="stat">
				<%
					logger.info("Entering into loop");
				%>

				<!-- <div class="wrapper"> -->
				<a class="ripplelink cyan" href="overview?projectname=${projectname.projectName}">${projectname.projectName}</a>
				<!-- </div> -->

			</c:forEach>
		</div>
	</c:if>
	<!-- </div> --><footer></footer>
	</div>
	
</body>
</html>