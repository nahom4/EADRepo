<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.css">
	<meta charset="ISO-8859-1">
	<title>Registration Page</title>
</head>
<body class = "container-fluid">

	<h1 class="text-white text-center bg-primary">Registration Page</h1>
	<form action = "RegistrationServlet" method = "post">
		Name: <input name = "name" type = "text"> <br>
		Email : <input name = "email" type = "text"> <br>
		Password : <input name = "password" type ="password"> <br>
		<input type = "submit" value = "register">
	</form>
</body>
</html>