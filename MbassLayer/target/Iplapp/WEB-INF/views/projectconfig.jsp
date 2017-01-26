<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>menu navigation</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/elements.css" />" />
	    <script type="text/javascript" src="<c:url value="/resources/js/my_js.js" />"></script>
		<link rel='stylesheet' type='text/css' href="<c:url value="/resources/css/font.css" />">
		<link rel="stylesheet" type='text/css' href="<c:url value="/resources/css/font-awesome.min.css" />">
		<!-- <link rel="stylesheet" href="/resources/css/ionicons.min.css"> -->
		<link rel="stylesheet"  type='text/css' href="<c:url value="/resources/css/main.css" />">
		<link rel="stylesheet" type='text/css' href="<c:url value="/resources/css/w3.css" />">
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<!-- <script src="js/highcharts.js"></script> -->
		<script type="text/javascript" src="<c:url value="/resources/js/data.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
        
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        
		<style>
			.ad {
				position: absolute;
				width: 300px;
				height: 250px;
				border: 0px 0px #ddd;
				left: 50%;
				transform: translateX(-50%);
				top: 250px;
				z-index: 10;
			}
			.ad .close {
				position: absolute;
				font-family: 'ionicons';
				width: 20px;
				height: 20px;
				color: #fff;
				background-color: #999;
				font-size: 20px;
				left: -20px;
				top: -1px;
				display: table-cell;
				vertical-align: middle;
				cursor: pointer;
				text-align: center;
			}
		</style>
		<script type="text/javascript">
			$(function() {
				$('.close').click(function() {
					$('.ad').css('display', 'none');
				})
			})
		</script>
 
        
	</head>
	<body>
  		
  		<!-- <script>  -->
  		<%--  var value = "<c:out value='${schema}' />"; 
        	 document.writeln(v);  --%>
        <script type="text/javascript">
		var schema_name = "${schema}";
		</script>	
   
		<div class="header">
		</div>
		<div class="side-nav">
			<div class="logo">
			<a href="projectlist">
						<span>BridgeLabz</span>
						</a>
	
			</div>
			<nav>
				<ul>
					<li>
						<a href="#">
							<span><i><img alt="" src="resources/images/home.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<%-- <c:forEach items="${projectname}" var="projectname"> --%>
							<span>${projectname}</span>
							<%-- </c:forEach> --%>
						</a>
					</li>
					<li>
						<a href="#">
							<span><i><img alt="" src="resources/images/account.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span>Auth</span>
						</a>
					</li>
					<li>
						<a href="#">
						<span><i><img alt="" src="resources/images/database.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span>Database</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="main-content">
			<div class="title">
				Overview
			</div>
				<div class="widget" align="center">
					<br>
					<div class="chart" align="center">Welcome to BridgeMBaaS! Get started here.</div>
					<div class="dashBtn">
					<a class="w3-btn-floating-large w3-teal" href="#myPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left"><i><img alt="" src="resources/images/androidlogo.png" width="50px" height=50px style="margin-top:20%;"></i></a>
					<div class="text">Android App</div>
					<!-- href="javascript:%20div_show()" id="popup" -->
					<!-- <a href="#myPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left">Show Popup Form</a> -->
					</div>
					<div class="dashBtn">
						<a class="w3-btn-floating-large w3-skyish" href="#myPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left" ><i><img alt="" src="resources/images/ios.png" width="50px" height=50px style="margin-top:20%;"></i></a>
						<div class="text">iOS App</div>
					</div>					
					<div class="dashBtn">
						<a class="w3-btn-floating-large w3-pinksh" href="#myPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left" ><i><img alt="" src="resources/images/download.png" width="50px" height=50px style="margin-top:20%;"></i></a>
						<div class="text">Web App</div>
					</div>				
					</div>
				</div>
				<%--  <c:forEach items="${projectdetails}" var="project" varStatus="stat"> --%>
          			<!-- <a href="downloadFileServlet" id="submit">Download json file...</a> -->
          		   <%-- <a href="<c:url value="downloadFileServlet" />" id="submit" >Download json file...</a> --%>
          		  <!--  <a href="javascript:%20check_downloadfile()" id="submit">Download json file...</a> -->
         		<%--  </c:forEach> --%>
				<!-- Display Popup Button -->
	<%-- <div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<!-- id="form"  name="form" -->

			<%
				Logger logger = Logger.getLogger(this.getClass().getName());
			%>

			<form method="POST" action="project" modelAttribute="projectcreate" commandName="projectcreate"> 
			<form action="#" id="form" method="post" name="form">
				<img id="close"
					src="<c:url value="/resources/images/close-button-icon.png" />"
					alt="" onclick="div_hide()" />
				<img src="<c:url value="/resources/images/left_arrow.png" />" alt="" />
				<%
					logger.info("Evaluating date ");
				%>
				<h2>Create a project</h2>
				<hr>
				<input id="name" name="name" placeholder="My Project"
					type="text">
				<form:input path="projectName"/>
				<!-- <input id="email" name="email" placeholder="Email" type="text">
        		<textarea id="msg" name="message" placeholder="Message"></textarea> -->
				<!-- <button id="submit" onclick="check_empty()" >Create Project</button>  -->
				<!-- <button id="close" onclick="div_hide()" >Cancel</button>  -->
				<a href="javascript:%20check_empty()" id="submit">Create Project</a>
				<!-- <href="javascript:%20div_hide()" input type="close"  value="Cancel" />  -->
			</form>
		</div>
		<!-- Popup Div Ends</div> Here -->
	</div> --%>
	 <div data-role="popup" id="myPopup" class="ui-content" style="min-width:250px;">
      <form method="post" action="#">
        <div>
    	  <h3>ADD BridgeMbaas</h3>
          <h5>Package Name:</h5>
		  <label for="usrnm" class="ui-hidden-accessible">Username:</label>
          <input type="text" name="user" id="usrnm" placeholder="com.appname.platform">
          <!--  <label for="pswd" class="ui-hidden-accessible">Password:</label>
          <input type="password" name="passw" id="pswd" placeholder="Password"> -->
          <label for="log">Download a .json file for your app(recommended)</label>
          <input type="checkbox" name="login" id="log" value="1" data-mini="true">
          <!-- <input type="submit" data-inline="true" value="Add App"> -->
         
          <a href="javascript:%20check_emptypackagenames()" id="submit">Add App</a>
          <!-- <button id="close" onclick="div_hide()" >Cancel</button> -->
          </div>
          <!-- </div>  -->
        </div>
      </form>
    </div>
  </div>
 <script>
//call after page loaded
window.onload=check_downloadfile ;
</script>
	</body>
</html>