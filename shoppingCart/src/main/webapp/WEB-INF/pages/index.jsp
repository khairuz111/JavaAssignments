<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html> 
<html>
<title></title>
<body>
<a href="adminLoginPage.jsp"><h4>Go to Admin Login Page</h4></a>
	<form action="login" method="post">
	User Name :  <input type="text" name="username"><br>
	PassWord  :  <input type="password" name="password"><br>
				 <input type="submit" value ="Login">
	</form>
				 New user? <a href="registration.jsp">Register Now</a>
	${errorMessage}
</body>
 
</html>