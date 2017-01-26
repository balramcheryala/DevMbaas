<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
							Post
					</a></li>
			</aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content item-editor-page">
			<div class="title-block">
				<h3 class="title">
					Sign-in <span class="sparkline bar" data-type="bar"></span>
				</h3>
				
				<h3 class="title">
					${success} <span class="sparkline bar" data-type="bar"></span>
				</h3>
			</div>
			<form name="item">
				<div class="card items">
					<ul class="item-list striped">
						<li class="item item-list-header hidden-sm-down">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col item-col-header fixed item-col-img md">
									<div>
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-title">
									<div>
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-sales">
									<div>
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-stats">
									<div class="no-overflow">
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-category">
									<div class="no-overflow">
										<span></span>
									</div>
								</div>

								<div
									class="item-col item-col-header fixed item-col-actions-dropdown">
								</div>
							</div>
						</li>
						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/googlePlusIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="GOOGLE">Google Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>
<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/github-256.png"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="GITHUB">GitHub Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>

						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/twitterIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="TWITTER">Twitter Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>

						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/facebookIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="FACEBOOK">FaceBook Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>

						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/linkedinIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="LINKEDIN">LinkedInEnable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>
						<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<div class="modal fade" id="confirm-modal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">
							<i class="fa fa-warning"></i> Alert
						</h4>
					</div>
					<div class="modal-body">
						<p>Are you sure want to do this?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">No</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
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
	</div>
</body>

</html>
