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
		<td><a href="profile">Profile</a></td>
		<td><a href="#">Orders</a></td>
		<td><a href="cartDetails?userId=${userId}">Cart</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table>
<h3>Order History</h3>
		<table width="800" border="1"> 
			<tr>
				<th width="20">Id</th>
				<th>Name</th>
				<th>Price</th>
				<th width="140">Category</th> 
				<th>Order Date</th>
			</tr>
				<c:forEach items="${orderList}" var ="orders">
				
				  <tr>
				    <td><c:out value="${orders.orderId}"/></td>
				    <td><c:out value="${orders.product.pName}"/></td> 
				    <td><c:out value="${orders.product.pPrice}"/></td>
				    <td><c:out value="${orders.product.pCategory}"/></td>
				    <td><c:out value="${orders.date}"/></td>
				  </tr>
					
				</c:forEach> 
		</table>
		${errorOrder}
</body>
</html>