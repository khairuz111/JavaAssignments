<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Edit Todo</h2>
	<form action="update?todoId=${todoId}" method="POST">  
  <table width="352" border="1">  
     <tr>  
      <th>ID</th>  
      <td>${todoId}</td>  
    </tr>  
    <tr>  
      <th> Title </th>  
      <td><input name="todoTitle" type="text" value="${todoTitle}"></td>  
    </tr>  
    <tr>  
      <th>Description </th>  
      <td><input name="todoDescription" type="text" value ="${todoDescription}"></td>  
    </tr>
    <tr>  
      <th>Category </th>  
      <td><input name="todoCategory" type="text" value ="${todoCategory}"></td>  
    </tr>   
    <tr>  
      <th colspan="2"><input type="submit"value="Submit" >  
      </th>  
    </tr>  
  </table>
  </form> 
   <a href="todoList">BACK</a>
  ${updateSuccess}
  ${updateError}
  ${userError}
</body>
</html>