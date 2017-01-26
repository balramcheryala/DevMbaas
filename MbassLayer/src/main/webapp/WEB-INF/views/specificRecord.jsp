<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>menu navigation</title>
<link href='resources/cssfile/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/cssfile/font-awesome.min.css">
<link rel="stylesheet" href="resources/cssfile/ionicons.min.css">
<link rel="stylesheet" href="resources/cssfile/main.css">
<link rel="stylesheet" href="resources/cssfile/w3.css">
<script src="resources/javascript/jquery.min.js"></script>
<script src="resources/javascript/highcharts.js"></script>
<script src="resources/javascript/data.js"></script>
<script src="resources/javascript/main.js"></script>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["tableName"].value;
		if (x == null || x == "") {
			alert("tableName must be filled out");
			return false;
		}
		var y = document.forms["myForm"]["columnFieldName"].value;
		if (y == null || y == "") {
			alert("columnFieldName must be filled out");
			return false;
		}
		var z = document.forms["myForm"]["rowId"].value;
		if (z == null || z == "") {
			alert("rowId must be filled out");
			return false;
		}
	}
</script>
<style type="text/css">
.foo {
	padding-right: 25px;
	height: 20px;
}

p.indent {
	padding-left: 1.5em
}

.button {
	background-color: #17626D;
	border: none;
	color: white;
	padding: 10px 65px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
}

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
	<div class="header"></div>
	<div class="side-nav">
		<div class="logo">
			<span>BridgeMBaaS</span> <br>
		</div>
		<nav>
		<ul>
			<li><a href="#"> <span><i><img alt=""
							src="resources/images/home.png" width="25px" height=25px
							style="margin-top: 20%;"></i></span><span>${projectname}</span>
			</a></li>
			<li><a href="#"> <span><i><img alt=""
							src="resources/images/account.png" width="25px" height=25px
							style="margin-top: 20%;"></i></span> <span>Auth</span>
			</a></li>
			<li><a href="dashboard"> <span><i><img alt=""
							src="resources/images/database.png" width="25px" height=25px
							style="margin-top: 20%;"></i></span> <span>Database</span>
			</a></li>
		</ul>
		</nav>
	</div>
	<div class="main-content">
		<div class="title">
			<b style="color: #AC233E">REALTIME DATABASE</b>
		</div>
		<div class="w3-container">
			<ul class="w3-navbar">
				<li><a href="insert"><b style="color: #186B4A">Insert
							JSON Key & Value Format</b></a></li>
				<li><a href="fileUploadForm"><b style="color: #186B4A">Upload
							JSON Table Schema</b></a></li>
				<li><a href="selectAll"><b style="color: #186B4A">Select_All_Records</b></a></li>
				<li><a href="specific"><b style="color: #186B4A">Select_Specific_Record</b></a></li>
				<li><a href="updateId"><b style="color: #186B4A">Update</b></a></li>
				<li><a href="deleteId"><b style="color: #186B4A">Delete</b></a></li>
			</ul>
		</div>
		<div class="widget" align="center" style="height: 525px">
			<h3>
				<b style="color: #CF483F">Provide Database Specific Record Information..!</b>
			</h3>
			<form name="myForm" action="columnRowId"
				onsubmit="return validateForm()" method="post">
				<b style="color: green">Table_Name</b>
				<p class="indent">
					<input type="text" class="foo" name="tableName">
				</p>
				<b style="color: green">Column_Field_Name</b>
				<p class="indent">
					<input type="text" class="foo" name="columnFieldName">
				</p>
				<br> <b style="color: green">Row_Id_Value</b>
				<p class="indent">
					<input type="text" class="foo" name="rowId"> <br> <br>
					<input class="button" type="submit" value="Submit">
			</form>
		</div>
	</div>
</body>
</html>

