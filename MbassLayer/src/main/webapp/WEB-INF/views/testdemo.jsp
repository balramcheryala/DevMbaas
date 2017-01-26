<html>
<title>Client Rest API</title>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

<!-- font awesome css -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
</head>

<body>
	<center>

		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-info'><i class="fa fa-twitter"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
				href='#' style="width: 12em"> Before Going to Post Please sign
				in to Providers</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-info'><i class="fa fa-twitter"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
				href='/MbassLayer/signin' style="width: 12em"> Sign in with
				Twitter</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-primary disabled'><i class="fa fa-facebook"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
				href='/MbassLayer/facebookrequest' style="width: 12em"> Sign in
				with Facebook</a>
		</div>
		<br /> <br />

		<div class="btn-group">
			<a class='btn btn-info'><i class="fa fa-twitter"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
				href='/MbassLayer/twitterpost' style="width: 12em">TWITTER POST</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-primary'><i class="fa fa-facebook"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
				href='/MbassLayer/fbpost' style="width: 12em">FACEBOOK POST</a>
		</div>
		<br /> <br /> <br /> <br />
		<div class="btn-group">
			<a class='btn btn-warning'><i class="fa fa-bell"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-warning '
				href='/MbassLayer/bufferget' style="width: 12em">BUFFER POST</a>
		</div>



		<div class="widget" align="center" style="height: 525px">
			<h2 style="color: #803540">Please select a file to upload..!</h2>
			<br />
			<form:form method="post" enctype="multipart/form-data"
				modelAttribute="uploadedFile" action="postupload">
				<table>
					<tr>
						<td><b style="color: red">Upload File:</b></td>
						<td><input type="file" name="file" /></td>
						<td style="color: red; font-style: italic;"><form:errors
								path="file" /></td>
					</tr>
					<tr>
						<td><input class="button" type="submit" value="Upload" /></td>
					</tr>
				</table>
			</form:form>
		</div>
</body>
</html>

</body>
</html>