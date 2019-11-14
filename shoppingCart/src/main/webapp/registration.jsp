<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>Registration</title>
</head>
<body>
<h1>Registration</h1>
	<form action="register" method="post">
		Full Name : <input type="text" name="fullname"><br>
		User Name : <input type="text" name="username"><br>
		Gender	  : <input type="text" name="gender"><br>
		Age		  : <input type="text" name="age"><br>
		Address	  : <input type="text" name="address"><br>
		Password  : <input type="text" name="password"><br>
					<input type="submit" value="Register">
	</form>
					<a>Already a user? Go to Login page</a>	 
</body>
</html>