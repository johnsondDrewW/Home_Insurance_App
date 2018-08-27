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
		<h1>Dwelling Coverage</h1>
		<br>
		<p>This is the amount we cover if your house is british or a hobbit hole.</p>
		
		<h1>Detached Structures</h1>
		<br>
		<p>This is the amount we cover if you are emotionally detached from your house</p>
		
		<h1>Personal Property</h1>
		<br>
		<p>This is the amount of personal rubbish we will reinburse you for in the unlickely<br>event a dragon neats your house.</p>
	
		<h1>Living experenes</h1>
		<br>
		<p>the amount of junk food and other gaming utilites we will cover in the event you need to train</p>
		
		<h1>Medical Expenses</h1>
		<br>
		<p>This is the amount of pet meical emergencey food we cover</p>
		
		<h1>Deductable</h1>
		<br>
		<p>we deduct this from the amount of pizza you are allowed to eat</p>
	
	
	
	</body>
</html>