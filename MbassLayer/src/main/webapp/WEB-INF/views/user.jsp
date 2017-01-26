<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>

<html>
<head>
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
	background: Navy;
	padding: 10px;
	margin-bottom: 0px;
	/* overflow: scroll; */
}
</style>
<title>Popup contact form</title>
<!-- <link href="css/elements.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elements.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/my_js.js" />"></script>
</head>
<!-- bgcolor="Gold" -->
<!-- Body Starts Here -->
<body id="body" style="overflow: hidden;">

	<div id="xyz">


		<nav id="myNavbar" class="navbar navbar-inverse navbar-fixed-top"
			role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->

			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><img
						src="resources/images/logo1.png"
						style="height: 50px; width: 70px; margin-top: -15px;" /></a>
				</div>
			</div>

		</nav>
		<br> <br>

		<div class="col-sm-12">
			<div class="jumbotron"
				style="margin-left: -80px; margin-right: -15px; margin-top: -40px; background-color: white">

				<div class="container-fluid"
					style="padding-right: 90px; margin-left: 0px">
					<h1 style="color: navy;">Welcome back to BridgeLabz</h1>
					<p style="color: navy;">Continue building your apps with
						BridgeMbaas...</p>
				</div>
			</div>
		</div>
		<!-- <p><a href="#" class="btn btn-success btn-lg">Get started today</a></p> -->


		<br></br> <br></br> <br></br> <br>
		<center>
			<button id="popup" onclick="div_show()">
				<h2 class="new_project">CREATE NEW PROJECT</h2>
			</button>
		</center>
		<!-- </div> -->
	</div>
	<!-- Display Popup Button -->
	<div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<!-- id="form"  name="form" -->

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
				<input id="name" name="name" placeholder="My Project" type="text">

				<a href="javascript:%20check_empty()" id="submit">Create Project</a>

			</form>
		</div>

	</div>
</body>
</html>