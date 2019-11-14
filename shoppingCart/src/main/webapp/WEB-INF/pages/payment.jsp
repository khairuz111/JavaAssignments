<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
<table width="800" border="1">
	<tr>
		<td><a href="allProducts">HOME</a></td>
		<td><a href="profile">Profile</a></td>
		<td><a href="fetchOrder">Orders</a></td>
		<td><a href="cartDetails?userId=${userId}">Cart</a></td>
		<td><a href="index.jsp">Logout</a></td>
	</tr>
</table>
	${name} ${orderSuccess} at your address - ${address}<br>
	Amount to be paid is ${amount}
</body>
</html>