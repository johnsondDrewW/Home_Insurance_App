<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import="main.java.com.Drew.HomeInsurance.Model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

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
	      <li><a href = "../Views/SearchUsers.jsp">Search User</a></li>
	      <%} %>
	      <li><a href="../LogOut">Logout</a></li>
	    </ul>
	  </div>
	</nav>
</head>
<body>
<%if(session.getAttribute("role")==null||!session.getAttribute("role").equals("Admin")){
	response.sendRedirect("AccessRestricted.jsp");
}
ArrayList<User> users =(ArrayList<User>)session.getAttribute("users");
 	if(users == null||users.get(0) ==null){%>
 		<form align = "center" action = "../SearchUsers" method="post">
 		<input name ="username">
	 		
	 	<input type = submit value = "search">	
 		</form>
 		<%}else{%>
		 <table align = "center">
		 <tr>
		 	<td>UserName</td>
		 	<td>Role</td>
		 	<td>Get Policy</td>
		 </tr>
 	<%for(User user:users){%>
 		<tr>
 		<td><%=user.getUserName() %></td>
 		<td><%=user.getRole() %></td>
 		<td><a href ="../SeeDetails?type=policy&&search=<%=user.getUserName() %>">get Policies</a></td>
 		</tr>		
 		<%} %>
 	<%} session.removeAttribute("users");%>
 </table>
</body>
</html>