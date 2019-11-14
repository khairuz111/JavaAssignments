<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<title></title>
<body>
	
	<form action="login" method="post">
	User Name :  <input type="text" name="username"><br>
	PassWord  :  <input type="password" name="password"><br>
				 <input type="submit" value ="Login">
	</form>
				New user? <a href="registration.jsp">Register Now</a>
	${errorMessage}
</body> 

</html>