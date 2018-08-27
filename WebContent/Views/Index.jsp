<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="../style/Template.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insurance</title>
</head>
<body>
	<h1 align = "center">Welcome</h1>
	<div class="row">
	<div class = "col-md-4 col-md-offset-1">
		<div class="panel">
		<div class= "text-center">
			<img class="rounded mx-auto d-block"src="https://i.pinimg.com/564x/ba/92/f0/ba92f0495f8629978a05dbd46a9deb41.jpg">
		</div>
		<br>
		<p>Just bought a house? need to know you are safe and nothing will happen?
			then choose Insurance and Co. we pride ourselves on being amazing and perfect</p>
		</div>
	</div>
		<div class="col-md-4 col-md-offset-1">
			<div class="panel">
				
				<form align = "center" action="../login" method="get">
					<p>logon</p>
					<br>
					<label>UserName:</label>
					<br>
					<input name="email">
					<br>		
					<label>Password:</label>
					<br>		
					<input name="password">		
					<br>		
					<span class="error">${error}</span>
					<br>
					<%session.removeAttribute("error"); %>
					<br>
					<input type="submit" value="Submit">
					<br>
					New User?<a href="../newRegisterUser">Register</a>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>