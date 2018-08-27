<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	i
	ntegrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="../style/Template.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insurance</title>
<nav class="navbar navbar-default navbar-fixed-top">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand">Insurance and Co.</a>
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
	<div class="col-md-6 left">
		<div class="text-center">
			<img class="rounded mx-auto d-block" height = 320px width=640px
			
				src="https://i.ytimg.com/vi/XBorGWlgIkQ/maxresdefault.jpg">
		</div>
	</div>
	<div class="col-md-6 right">
		<form action="../CreateHomeOwner" method=post>
			<table>
				<tr>
					<td><label>Owner Email</label></td>
					<td><input name="email"></td>
				</tr>
				<tr>
					<td><label>First Name</label></td>
					<td><input name="fName"></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					
					<td><input name="lName" /></td>
				</tr>
				<tr>
					<td>
				
				<label>Date-Of-Birth</label>
				</td>
				<td><input type="date" name="DOB"></td>
				</tr>
				<tr>
					<td>
					<label>Social Security Number</label>
					</td>
					<td> <input name="ss#">
					 </td>
					 </tr>
			<tr>
				<td>
					<label>are you Retired</label>
				</td>
				<td>
					<input type="radio" name="Retired" value="Yes">Yes <input
						type="radio" name="Retired" value="No">No
				</td>
			</tr>
			<tr> <span class = "error">${error}<%session.removeAttribute("error"); %></span>
				<td></td><td><input type="submit" value="Enter Property Details"></td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>