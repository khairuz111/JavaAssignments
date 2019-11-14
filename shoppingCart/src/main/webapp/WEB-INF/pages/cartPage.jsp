<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
<table width="800" border="1">
	<tr>
		<td><a href="allProducts" method="POST">HOME</a></td>
		<td><a href="profile">Profile</a></td>
		<td><a href="fetchOrder">Orders</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table>
${deleteSuccess}
${deleteError}
	
	<h2> Your Cart</h2>
	<table width="800" border="1"> 
			<tr>
				<th>Sl NO.</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Category</th> 
				<th>Price</th>
			</tr>
				<c:forEach items="${cartList}" var ="cart">
				  <tr>
				  	<td><c:out value="${cart.id}"/></td>
				    <td><c:out value="${cart.product.pId}"/></td>
				    <td><c:out value="${cart.product.pName}"/></td>
				   <td><c:out value="${cart.product.pCategory}"/></td>
				    <td><c:out value="${cart.product.pPrice}"/></td>
				    <td><form action="deleteFromCart?cartId=${cart.id}" method="post"><input type="submit" value="DELETE"></form></td>
				  </tr>
					
				</c:forEach> 
		</table><br>
		Total : Rs. ${total}.00
		
		<form action="order"  method="POST"><input type="submit" value="order"></form>

</body>
</html>