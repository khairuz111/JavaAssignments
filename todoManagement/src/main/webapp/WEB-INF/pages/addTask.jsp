<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task Page</title> 
</head> 
<body>
	<h3>New Todo Task</h3>
	<form action="addTask"  method="POST">
		Title : <input type="text" name="title"><br>
		Description : <input type="text" name="description"><br>
		category : <input type="text" name="category"><br>
					<input type="submit"  name="Add">
	</form> 

	<a href="todoList">BACK</a>
	
	${taskAdded}
	${cannotAdd} 
</body>
</html>