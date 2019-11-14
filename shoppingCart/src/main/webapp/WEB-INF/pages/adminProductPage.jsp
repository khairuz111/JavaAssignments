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
<h1>Welcome ${name} as ADMIN</h1><br>
<table width="800" border="1">
	<tr>
		<td><a href="#">HOME</a></td>
		<td><a href="#">Profile</a></td>
		<td><a href="fetchAllUsers">Users</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table> 
<h3>Product List</h3>
		<table width="600" border="1"> 
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Category</th> 
			</tr>
				<c:forEach items="${productList}" var ="product">
				
				  <tr>
				    <td><c:out value="${product.pId}"/></td>
				    <td><c:out value="${product.pName}"/></td> 
				    <td><c:out value="${product.pPrice}"/></td>
				    <td><c:out value="${product.pCategory}"/></td>
				    <td><form action="editProduct?pId=${product.pId}" method="post"><input type="submit" value="Edit"></form></td>
				    <td><form action="deleteProduct?pId=${product.pId}" method ="post"><input type="submit" value="DELETE"></form></td> 
				  </tr>
					
				</c:forEach> 
		</table><br>
		<form action="addProduct.jsp"><input type="submit" value="ADD NEW PRODUCT"></form>
		${addingSuccess}
		${successMessage}
		${deleteSuccess}
		${deleteError}
</body>
</html>