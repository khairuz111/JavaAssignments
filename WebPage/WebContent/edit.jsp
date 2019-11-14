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
		<a  href="welcome.jsp">Profile</a> 
		<a class="active" href="edit.jsp">Edit</a> 
		<a href="search.jsp">Search</a> 
		<a href="login.jsp">Logout</a>
	</div>
	<div>
		<h3> ${message}</h3>
		<h3>${updateMessage}</h3>
	</div>
	
	<form action="Login" method="post">
		ID : <input type="text" name="id" value="<% out.print(session.getAttribute("id"));%>" readonly="readonly"><br>
		Name : <input type="text" name="name" value="<% out.print((String)session.getAttribute("name"));%>"><br>
		UserName : <input type="text" name="username" value="<% out.print((String)session.getAttribute("username"));%>"><br>
		Address : <input type="text" name="address" value="<% out.print((String)session.getAttribute("address"));%>"><br>
		Phone number : <input type="text" name="phone_num" value="<% out.print((String)session.getAttribute("phone_num"));%>"><br>
		Password : <input type="text" name="password" value="<% out.print((String)session.getAttribute("password"));%>"><br>
		<input type="submit" name="submit" value="update">
		
		
	</form>
</body>
</html>