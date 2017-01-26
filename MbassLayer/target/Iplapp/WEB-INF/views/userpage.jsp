<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>

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
			<div class="header-block header-block-search hidden-sm-down"></div>

			</header>
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
						<li><a href="#"> <i class="fa fa-home"></i>
							DataBase
					</a></li>
						<li><a href="testdemo"> <i class="fa fa-twitter"></i>
							Post
					</a></li>
			</aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content items-list-page">
			<div class="title-search-block">
				<div class="title-block">
					<div class="row">
						<div class="col-md-6">
							<h3 class="title">
								<a href="newuser" class="btn btn-primary btn-sm rounded-s">
									Add New </a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="card items">
				<ul class="item-list striped">
					<li class="item item-list-header hidden-sm-down"><c:if
							test="${!empty students}">
							<div class="table">
								<div class="table-head">
									<div class="column">Email</div>
									<div class="column">Providers</div>
									<div class="column">Created</div>
									<div class="column">SignedIn</div>
									<div class="column">UserUID</div>
									<div class="column"></div>
									<div
										class="item-col column item-col-header fixed item-col-actions-dropdown">
									</div>
								</div>
								<c:forEach items="${students}" var="bridge">
									<div class="row">
										<div class="column">${bridge.email}</div>
										<div class="column">${bridge.providers}</div>
										<div class="column">${bridge.created}</div>
										<div class="column">${bridge.signedin}</div>
										<div class="column">${bridge.useruid}</div>
										<div class="item-col fixed item-col-actions-dropdown">
											<div class="item-actions-dropdown">
												<a class="item-actions-toggle-btn"> <span
													class="inactive"> <i class="fa fa-cog"></i>
												</span> <span class="active"> <i
														class="fa fa-chevron-circle-right"></i>
												</span>
												</a>
												<div class="item-actions-block">
													<ul class="item-actions-list">
														<li><a class="remove" href="delete?id=${bridge.id}">
																<i class="fa fa-trash-o "></i>
														</a></li>
														<li><a class="edit" href="edit?id=${bridge.id}">
																<i class="fa fa-pencil"></i>
														</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>

								</c:forEach>
							</div>
						</c:if> <!-- /.modal-content -->
			</article>
		</div>
		<!-- /.modal-dialog -->
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
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />"></script>
</body>
</html>