<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>${title}</title>
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href='http://fonts.googleapis.com/css?family=Roboto:400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/vendor.css" />" />
<!-- Theme initialization -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app-orange.css" />" />
</head>
<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			


			<div class="header-block header-block-nav">
	
					
			<aside class="sidebar">
			<div class="sidebar-container">
				<div class="sidebar-header">
					<div class="brand">
						<div class="logo">
							<span class="l l1"></span> <span class="l l2"></span> <span
								class="l l3"></span> <span class="l l4"></span> <span
								class="l l5"></span>
						</div>
						${title}
					</div>
				</div>
		<nav class="menu">
				<ul class="nav metismenu" id="sidebar-menu">
					<li><a href="dashboard"> <i class="fa fa-home"></i>
							Dashboard
					</a></li>
					<li class="active open"><a href=""> <i
							class="fa fa-th-large"></i> Auth <i class="fa arrow"></i>
					</a>
						<ul>
							<li class="active"><a href="userpage"> Users </a></li>
							<li><a href="signinby"> Sign-in Method </a></li>
						</ul></li>
						<li><a href="dashboard"> <i class="fa fa-home"></i>
							DataBase
					</a></li>
						<li><a href="testdemo"> <i class="fa fa-twitter"></i>
							Post</a>
			</aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content item-editor-page">
			<div class="">
				<h3 class="title">
					${project} <span class="sparkline bar" data-type="bar"></span>
				</h3>
			</div>
			<div class="auth-content">
				<p class="text-xs-center">Edit Email Id And Password</p>

				<form:form method="POST" action="save">

					<div class="form-group">
						<label for="email">Email</label>
						<form:input path="email" class="form-control underlined"
							value="${student.email}" />
					</div>

					<div class="form-group">
						<label for="password">Password</label>
						<form:input path="password" class="form-control underlined"
							value="${student.password}" />
					</div>
					
					<button type="submit" class="btn btn-block btn-primary">Sumbit</button>
				</form:form>
			</div>

			<!-- Reference block for JS -->
			<div class="ref" id="ref">
				<div class="color-primary"></div>
				<div class="chart">
					<div class="color-primary"></div>
					<div class="color-secondary"></div>
				</div>
			</div>
			<script type="text/javascript"
				src="<c:url value="/resources/js/vendor.js" />"></script>
		</div>
</body>

</html>





