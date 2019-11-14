<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<title></title>
<body>
	<a href="index.jsp"><h4>Go to User Login Page</h4></a>
<form action="adminLogin" method="post">
	<table width="600" border="1">
		<tr>
		<th>ADMIN LOGIN</th>
		<tr>
			<th>User Name</th>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="Login"></td>
		</tr>
		
	</table>
	
	
	</form>
				
	${errorMessage}
</body>

</html> 