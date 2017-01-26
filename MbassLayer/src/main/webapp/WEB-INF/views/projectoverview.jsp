<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	 <script type="text/javascript">
		var schema_name = "${schema}";
		</script>	
		<div class="header">
		</div>
		<div class="side-nav">
			<div class="logo">
						<span>BridgeMBasS</span>
						<!-- </a> -->
			
			</div>
			<nav>
				<ul>
					<li>
						<a href="#">
							<span><i><img alt="" src="resources/images/home.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span >${projectname}</span>
						</a>
					</li>
					<li>
						<a href="userinfo">
							<span><i><img alt="" src="resources/images/account.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span>Auth</span>
						</a>
					</li>
					<li>
					<a href="dashboard">
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
			<!-- 525px -->
				<div class="widget" align="center" style="height:525px">
					<br>
					<div class="chart" align="center">Welcome to BridgeMaaS! Get started here.</div>
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
          <a onclick="check_emptypackagenames()" id="submit">Add App</a>
          <!-- <button id="close" onclick="div_hide()" >Cancel</button> -->
          </div>
          <!-- </div> -->
        </div>
      </form>
    </div>
  </div>
	</body>
</html>