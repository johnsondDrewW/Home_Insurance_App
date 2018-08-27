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
			<img class="rounded mx-auto d-block"
				src="https://i.pinimg.com/564x/f3/00/6f/f3006f388e9f9efc4da413f41d451893.jpg">
		</div>
	</div>
	<div class="col-md-6 right">
		<form action="../CreateProperty" method=post>
			<table>
				<tr>
					<td><label>Residence type</label></td>
					<td><select name="Type">
							<option value="">------</option>
							<option value="Single-Family Home">Single-Family Home</option>
							<option value="Condo">Condo</option>
							<option value="TownHouse">TownHouse</option>
							<option value="RowHouse">RowHouse</option>
							<option value="Duplex">Duplex</option>
							<option value="Apartment">Apartment</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Address1</label></td>
					<td><input name="address1"></td>
				</tr>
				<tr>
					<td><label>Address2</label></td>
					<td><input name="address2"></td>
				</tr>
				<tr>
					<td><label>city</label></td>
					<td><input name="City"></td>
				</tr>
				<tr>
					<td><label>State</label></td>
					<td><input name="State"></td>
				</tr>
				<tr>
					<td><label>zip</label></td>
					<td><input name="Zip"></td>
				</tr>
				<tr>
					<td><label>location use</label></td>
					<td><select name="Use">
							<option value="">------</option>
							<option value="Primary">Primary</option>
							<option value="Secondary">Secondary</option>
							<option value="Rental Property">Rental Property</option>

					</select></td>
				</tr>
			</table>
			<span class = "error">${error}<%session.removeAttribute("error"); %></span>
			<input type="Submit" value="Enter HomeOwner info">
		</form>
	</div>
</body>
</html>