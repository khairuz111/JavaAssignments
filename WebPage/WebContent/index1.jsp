<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<form action="Login" method="post">
		<table align="center" bgcolor="#99FFCC" border="1" width="70%">
			<tr>
				<td colspan="2" align="center">Login</td>
			</tr>
			<tr>
				<td><h3>${message}</h3></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" maxlength="25"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" maxlength="40"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="submit"
					value="login"></td>
			</tr>
		</table>
		<a href="registration.jsp">register</a>
	</form>
</body>
</html>