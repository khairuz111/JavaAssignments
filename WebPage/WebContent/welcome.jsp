<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/welcome.css">
</head>
<body>
	<div class="header">${message}</div>
	<div class="topnav">
		<a class="active" href="welcome.jsp">Profile</a> 
		<a href="edit.jsp">Edit</a> 
		<a href="search.jsp">Search</a> 
		<a href="index.jsp">Logout</a>
		<div class="search-container">
	    <form action="Login" method="post">
	      <input type="text" placeholder="Search.." name="search">
	      <button type="submit" name="submit" value="search">search</button>
	    </form>
  </div>
	</div>
	<div>
		<h3> ${message}</h3>
		<h3>${updateMessage}</h3>
		<a>Profile details</a><br>
		Customer Id : <% out.print(session.getAttribute("id"));%><br>
		Name : <% out.print((String)session.getAttribute("name"));%><br>
		User name : <% out.print((String)session.getAttribute("username"));%><br>
		Address : <% out.print((String)session.getAttribute("address"));%><br>
		Phone number : <% out.print((String)session.getAttribute("phone_num"));%><br>
		Password :<% out.print((String)session.getAttribute("password"));%><br>
	</div>
</body>
</html>