<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" i
		ntegrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		<link rel="stylesheet" href="../style/Template.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insurance</title>
	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" >Insurance and Co.</a>
	    </div>
	    <ul class="nav navbar-nav  navbar-right">
	      <li class="active"><a href="../GetStarted">Home</a></li>
	      <li><a href="../GetQoute">GetQuote</a></li>
	      <li><a href="../ViewQoutes">OldQuotes</a></li>
	      <li><a href="../ViewPolicies">MyPolicies</a></li>
	      <%if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("Admin")){ %>
	      <li><a href = "../SearchUsers">Search User</a></li>
	      <%} %>
	      <li><a href="../LogOut">Logout</a></li>
	    </ul>
	  </div>
	</nav>
	</head>
	<body>
		<div class = "col-md-6 left">
		<div class= "text-center">
			<img class="rounded mx-auto d-block"src="https://trilogyarch.com/media/weird-houses-3.jpg">
		</div>
		</div>
		<div class = "col-md-6 right">
		<h1>Buy policy</h1>
		<p>QouteID:${policy.getPolicy_ID()}</p>
		<p>note Policy start Date can not be more than 60 days from today</p>
		<form action ="../BuyQoute" method ="post">
			<p>Enter Policy Start Date:<p><input placeholder="dd/mm/yyyy" type ="date" name = "startdate">
			<br><a href ="./Terms.jsp" >PLease click here to read the terms and conditions</a>
			<br>I Agree<input type = "checkbox" name = "read">
			<br><input type = "submit" value="buy">
		</form>
		</div>
	</body>
</html>