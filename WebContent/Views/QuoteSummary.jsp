<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="java.util.HashMap"%>
    <%@ page import="main.java.com.Drew.HomeInsurance.Model.User" %>
    <%@ page import="main.java.com.Drew.HomeInsurance.Model.Policy" %>
    <%@ page import="main.java.com.Drew.HomeInsurance.Model.Property" %>
    <%@ page import="main.java.com.Drew.HomeInsurance.Model.HomeOwner" %>
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
		<%
			Policy policy = (Policy)session.getAttribute("policy");
			Property property = (Property)session.getAttribute("Property");
			HomeOwner owner =  (HomeOwner)session.getAttribute("HomeOwner");
		%>
		<%if(request.getParameter("buying").equals("yes")){ %>
			<center><button onclick= "window.location.href='./BuyQoute.jsp'">Buy</button></center>
		<%} %>
		<div class = "row">
	<div class="col-md-2 col-md-offset-4 left">
		<table>	
				<caption><h1>Location</h1></caption>	
				<tr>
				<td><label>Address</label></td>
				<td><p><%=property.getAddress1()%>, </p>
					<p><%if(property.getAddress2()!=null){%><%=property.getAddress2()%><%} %></p></td>
				</tr>
				<tr>	
					<td><label>City</label></td>
					<td><p><%=property.getCity()%></p></td>
				</tr>
				<tr>
					<td><label>State</label></td>
					<td><p><%=property.getLocation_State()%></p></td>
				</tr>
				<tr>
					<td><label>Zip</label>	
					<td><p><%=property.getZip()%></p></td>
				</tr>
		</table>
	</div>
	
	<div class="col-md-2 col-md-offset-1 right">
		<table>	
		<catption><h1>Property Details</h1></catption>
			<tr>
				<td><label>Property Type</label></td>	
				<td><p><%=property.getLocation_Type()%></p></td>
			</tr>
			<tr>
			<td><label>Property Use</label></td>
			<td><p><%=property.getLocation_Use()%></p></td>
			</tr>
			<tr>
			<td><label>Number of Floors</label></td>
			<td><p><%=property.getNumber_Floors()%></p></td>
			</tr>
			<tr>	
				<td><label>Market Value</label></td>
				<td><p>$<%=property.getMarket_Value()%></p></td>
			</tr>
			<tr>
				<td><label>Swimming Pool?</label></td>
				<td><p><%=property.getPool()%></p></td>
			</tr>
			<tr>
				<td><label>Roof Material</label></td>
				<td><p><%=property.getRoof_Material()%></p></td>
			</tr>
			<tr>
				<td><label>Square Footage</label></td>
				<td><p><%=property.getSquare_Footage()%>sq.ft.</p></td>
			</tr>
			<tr>
				<td><label>Number of Full Baths</label></td>
				<td><p><%=property.getFull_Baths()%></p></td>
			</tr>
			<tr>
				<td><label>number of Half baths</label></td>
				<td><p><%=property.getHalf_Baths()%></p></td>
			</tr>
			<tr>
				<td><label>Year Built</label></td>
				<td><p><%=property.getYear()%></p></td>
			</tr>
		</table>
	</div>
</div>
	<div class = "row">
	<div class="col-md-2 col-md-offset-4 left">
		<table>		
				<caption><h1>Home Owner</h1></caption>	
				<tr>
				<td><label>First Name</label></td>
				<td><p><%=owner.getFirstName()%></p></td>
				</tr>
				<tr>	
					<td><label>Last Name</label></td>
					<td><p><%=owner.getLastName()%></p></td>
				</tr>
				<tr>
					<td><label>Owner Email</label></td>
					<td><p><%=owner.getOwnerEmail()%></p></td>
				</tr>
				<tr>
					<td><label>Retrired?</label>	
					<td><p><%=owner.getRetired()%></p></td>
				</tr>
				<tr>
					<td><label>Social Security Number</label>	
					<td><p><%=owner.getSSN()%></p></td>
				</tr>
				<tr>
					<td><label>Date of Birth</label>	
					<td><p><%=owner.getDOB()%></p></td>
				</tr>
		</table>
	</div>
	
	<div class="col-md-2 col-md-offset-1 right">
			
		<table>
		<caption>
			<h1 align="center">Coverage Details</h1>
		</caption>
			<tr>
				<td><label>Policy Id</label></td>	
				<td><p><%=policy.getPolicy_ID()%></p></td>
			</tr>
			<tr>
			<td><label>Premium</label></td>
			<td><p>$${Premium}</p></td>
			</tr>
			<tr>
			<td><label>Coverage</label></td>
			<td><p>$${coverage}</p></td>
			</tr>
			<tr>	
				<td><label>Detached</label></td>
				<td><p>$${detached}</p></td>
			</tr>
			<tr>
				<td><label>Personal Property</label></td>
				<td><p>$${personalProperty}</p></td>
			</tr>
			<tr>
				<td><label>living Expenses</label></td>
				<td><p>$${living}</p></td>
			</tr>
			<tr>
				<td><label>Medical</label></td>
				<td><p>$5000</p></td>
			</tr>
			<tr>
				<td><label>Deductable</label></td>
				<td><p>${deductable}</p></td>
			</tr>
		</table>
	</div>
</div>
		<%if(request.getParameter("buying").equals("yes")){ %>
			<center><button  onclick= "window.location.href='./BuyQoute.jsp'">Buy</button></center>
		<%} %>
	</body>
</html>