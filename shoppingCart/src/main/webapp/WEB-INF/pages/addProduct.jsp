<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addProduct" method="post">
	<table width="500" border="1">
		<tr>
			<th>NEW PRODUCT</th>
		</tr>
		<tr>
			<th>Name</th>
			<td><input type="text" name="productName"></td>
		</tr>
		<tr>
			<th>Category</th>
			<td><input type="text" name="productCategory"></td>
		</tr>
		<tr>
			<th>Price</th>
			<td><input type="text" name="productPrice"></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="ADD"></td>
		</tr>
	</table>
	</form>
</body>
</html>