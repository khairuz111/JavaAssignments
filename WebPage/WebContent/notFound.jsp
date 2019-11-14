<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h2>Search result not found !!!</h2>
</body>
</html>