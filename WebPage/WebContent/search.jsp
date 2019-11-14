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
	
	<div class="topnav">
		<a  href="welcome.jsp">Profile</a> 
		<a href="edit.jsp">Edit</a> 
		<a class="active" href="search.jsp">Search</a> 
		<a href="index.jsp">Logout</a>
		<div class="search-container">
	    <form action="Login" method="post">
	      <input type="text" placeholder="Search.." name="search">
	      <button type="submit" name="submit" value="search" > search</button>
	    </form>
  </div>
	</div>
	<div>
		<h3> ${searchMessage}</h3>
		<a>Profile details</a><br>
		Customer Id : <a>${id}</a><br>
		Name :<a>${name}</a><br>
		User name : <a>${username}</a><br>
		Address : <a>${address}</a><br>

	</div>
</body>
</html>