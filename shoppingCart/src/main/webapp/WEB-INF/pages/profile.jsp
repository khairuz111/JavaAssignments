<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="1">
	<tr>
		<td><a href="allProducts">HOME</a></td>
		<td><a href="#">Profile</a></td>
		<td><a href="fetchOrder">Orders</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table><br>
	
	<h2>Profile Details</h2>
	<table width="400" border="1"> 
			<tr>
				<th>Id</th>
				<td>${userId}</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>${name}</td>
			</tr>
			<tr>
				<th>Username</th>
				<td>${username}</td>
			</tr>
			<tr>
				<th>Age</th>
				<td>${age}</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td>${gender}</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>${address}</td>
			</tr>
		</table>
	
</body>
</html>