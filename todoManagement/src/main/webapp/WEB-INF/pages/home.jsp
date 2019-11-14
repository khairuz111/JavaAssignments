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
<h1>Welcome ${name}</h1><br>
<h3><a href="profile" method="GET">My Profile   </a></h3> <h3><a href="index.jsp">Logout</a></h3><br>

<h4>TASK LIST</h4>
		<table width="352" border="1"> 
			<tr>
				<th>Id</th>
				<th>title</th>
				<th>description</th>
				<th>Category</th> 
			</tr>
				<c:forEach items="${todosList}" var ="todos">
				
				  <tr>
				    <td><c:out value="${todos.todoId}"/></td>
				    <td><c:out value="${todos.todoTitle}"/></td> 
				    <td><c:out value="${todos.todoDescription}"/></td>
				    <td><c:out value="${todos.todoCategory}"/></td>
				   <td><form action="fetchTodo?todoId=${todos.todoId}" method ="POST"><input type="submit" value="Edit"></form></td>
				   <td> <form action="delete?todoId=${todos.todoId}" method ="POST"><input type="submit" value="Delete"></form></td>   
				  </tr>
					
				</c:forEach> 
		</table>
		<form action="addTask.jsp"><input type="submit" value="ADD NEW TASK"></form>
		
		${emptyList}
		${deleteSuccess}
		${deleteError}
</body>
</html>