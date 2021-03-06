<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.HashMap"%>
<%@ page import="main.java.com.Drew.HomeInsurance.Model.User"%>
<%@ page import="main.java.com.Drew.HomeInsurance.Model.Policy"%>
<%@ page import="main.java.com.Drew.HomeInsurance.Model.Property"%>
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
	<div class="row">
	<%if(request.getParameter("buying").equals("yes")){%>
		<table align = "center">
			<tr>
				<td>Qoute ID</td>
				<td>Residence Type</td>
				<td>address</td>
				<td>City</td>
				<td>State</td>
				<td>Zip</td>
				<td>Residence Use</td>
				<td>Status</td>
				<td>Rest of Info</td>
			</tr>
			<% HashMap<Integer,Policy> policies = (HashMap<Integer,Policy>)session.getAttribute("Policies");
			HashMap<Integer,Property> properties = (HashMap<Integer,Property>)session.getAttribute("Properties");
		  	if(policies !=null&&properties !=null){
			   for (HashMap.Entry<Integer,Policy> p: policies.entrySet()) { 
				   %>
			<!-- create an html table row -->
			<tr>
			
				<!-- create cells of row -->
				<td><%= p.getValue().getPolicy_ID()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getLocation_Type()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getAddress1()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getCity()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getLocation_State()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getZip()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getLocation_Use()%></td>
				<td><%=p.getValue().getStatus()%></td>
				<td><a href="../Summary?qoute=<%=p.getValue().getPolicy_ID()%>&buying=yes%>">Qoute Info</a></td>
				<!-- close row -->
			</tr>
			<!-- close the loop -->
			<% } %>
			<% } %>
			
		</table>
		<%}else{ %>
		<table align = "center">
			<tr>
				<td>Policy ID</td>
				<td>Qoute ID</td>
				<td>Policy Start</td>
				<td>Policy End</td>
				<td>Policy Term</td>
				<td>State</td>
				<td>Zip</td>
				<td>Residence Use</td>
				<td>Status</td>
				<td>Rest of Info</td>
			</tr>
			<% HashMap<Integer,Policy> policies = (HashMap<Integer,Policy>)session.getAttribute("Policies");
			HashMap<Integer,Property> properties = (HashMap<Integer,Property>)session.getAttribute("Properties");
		  	if(policies !=null&&properties !=null){
			   for (HashMap.Entry<Integer,Policy> p: policies.entrySet()) { 
				   %>
			<!-- create an html table row -->
			<tr>
			
				<!-- create cells of row -->
				<td>PL<%= p.getValue().getPolicy_ID()%>(0^0)</td>
				<td><%= p.getValue().getPolicy_ID()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getLocation_Type()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getAddress1()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getCity()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getLocation_State()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getZip()%></td>
				<td><%=properties.get(p.getValue().getPL_ID()).getLocation_Use()%></td>
				<td><%=p.getValue().getStatus()%></td>
				<td><a href="../Summary?qoute=<%=p.getValue().getPolicy_ID()%>&buying=no%>">Info</a></td>
				<!-- close row -->
			</tr>
			<!-- close the loop -->
			<% } %>
			<% } %>
			
		</table>
		<%} %>
	</div>
</body>
</html>