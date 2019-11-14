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
<table width="800" border="1">
	<tr>
		<td><a href="#">HOME</a></td>
		<td><a href="profile">Profile</a></td>
		<td><a href="fetchOrder">Orders</a></td>
		<td><a href="cartDetails?userId=${userId}">Cart</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table>
<h3>Product List</h3>
		<table width="800" border="1"> 
			<tr>
				<th width="40">Id</th>
				<th>Name</th>
				<th>Price</th>
				<th width="140">Category</th> 
			</tr>
				<c:forEach items="${productList}" var ="product">
				
				  <tr>
				    <td><c:out value="${product.pId}"/></td>
				    <td><c:out value="${product.pName}"/></td> 
				    <td><c:out value="${product.pPrice}"/></td>
				    <td><c:out value="${product.pCategory}"/></td>
				    <td><form action="addToCart?pId=${product.pId}" method="post"><input type="submit" value="ADD TO CART"></form></td>
				    <td><form action="buyProduct?pId=${product.pId}" method="post"><input type="submit" value="BUY NOW"></form></td>  
				  </tr>
					
				</c:forEach> 
		</table>
		${addingSuccess}
		${errorAdding}
		${successMessage}
</body>
</html>