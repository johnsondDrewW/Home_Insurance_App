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
			<img class="rounded mx-auto d-block" 
			
				src="https://www.arch2o.com/wp-content/uploads/2017/08/Arch2O-Coolhousesdesigns-undergroundhome5-700x467.jpg">
		</div>
	</div>
	<div class="col-md-6 right">
		<form action ="../UpdateProperty" method ="post">
		<table>
		<tr>
			<td><label>Market Value: </label></td>
			<td>$<input name ="market value"></td>
		</tr>
		<tr>
		
			<td><label>Year Built: </label></td>
			<td><input name ="year built"></td>
		</tr>
		<tr>
			<td><label>Square Footage: </label></td>
			<td><input name ="sq.ft.">sq.ft.</td>
		</tr>
		<tr>	
			<td><label>Dwelling Style</label></td>
			<td><select name = "floors">
				<option value ="">----------</option>
				<option value ="1.5 Story">1.5 Story</option>
				<option value ="2 Story">2 Story</option>
				<option value ="2.5 Story">2.5 Story</option>
				<option value ="3 Story">3 Story</option>
			</select></td>
		</tr>
		<tr>	
			<td><label>Roof Material</label></td>
			<td><select name = "roof">
				<option value ="">----------</option>
				<option value ="Concrete">Concrete</option>
				<option value ="Clay">Clay</option>
				<option value ="Rubber">Rubber</option>
				<option value ="Steel">Steel</option>
				<option value ="Tin">Tin</option>
				<option value ="Wood">Wood</option>
			</select></td>
		</tr>
		<tr>	
			<td><label>Garage type</label></td>
			<td><select name = "garage">
				<option value ="">----------</option>
				<option value ="Detached">Detached</option>
				<option value ="Attached">Attached</option>
				<option value ="None">None</option>
			</select></td>
		</tr>
		<tr>	
			<td><label>Number of Full Baths </label></td>
			<td><select name = "full baths">
				<option value ="">----------</option>
				<option value ="1">1</option>
				<option value ="2">2</option>
				<option value ="3 or more">3 or more</option>
			</select></td>
		</tr>
		<tr>	
			<td><label>Number of half Baths </label></td>
			<td><select name = "half baths">
				<option value ="">----------</option>
				<option value ="1">1</option>
				<option value ="2">2</option>
				<option value ="3 or more">3 or more</option>
			</select></td>
		</tr>
		<tr>	
			<td><label>Swimming pool?</label></td>
			<td><input type = "radio" name = "pool" value = "Yes">Yes
			<input type = "radio" name = "pool" value = "No">No</td>
		</table>
		<span class = "error">${error}<%session.removeAttribute("error"); %></span>
			<input type = "submit" value = "continue">
		</form>
		</div>
	</body>
</html>