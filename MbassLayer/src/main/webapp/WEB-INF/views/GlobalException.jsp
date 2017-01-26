<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>GloBal Exception Handling</title>

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

	<section class="section">
		<div class="error-card">
			<div class="error-title-block">
				<h1 class="error-title">${statusCode}</h1>
				<h2 class="error-sub-title">${error}</h2>
			</div>
			<div class="error-container">
				<p>You better try our awesome search:</p>
				<div class="row">
					<div class="col-xs-12">
						<div class="input-group">
							<input type="text" class="form-control"> <span
								class="input-group-btn">
								<button class="btn btn-primary" type="button">Search</button>
							</span>
						</div>
					</div>
				</div>
				<br> <a class="btn btn-primary" href="/MbassLayer"><i
					class="fa fa-angle-left"></i> Back to Dashboard</a>
			</div>
		</div>
	</section>
	</article>

	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
		<script type="text/javascript"
			src="<c:url value="/resources/js/vendor.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/app.js" />"></script>
	</div>
</body>

</html>