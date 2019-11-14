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
		<td><a href="#">HOME</a></td>
		<td><a href="#">Profile</a></td>
		<td><a href="#">Users</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table> 
<h3>User List</h3>
		<table width="600" border="1"> 
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Address</th> 
			</tr>
				<c:forEach items="${userList}" var ="user">
				
				  <tr>
				    <td><c:out value="${user.userId}"/></td>
				    <td><c:out value="${user.name}"/></td> 
				    <td><c:out value="${user.age}"/></td>
				    <td><c:out value="${user.gender}"/></td>
				    <td><c:out value="${user.address}"/></td> 
				  </tr>
					
				</c:forEach> 
		</table>
</body>
</html>