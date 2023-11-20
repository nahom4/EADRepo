<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel= "stylesheet" href="css/bootstrap.css">
	</head>
	<body class= "container-fluid" >
		<h2 class = "bg-primary text-white text-center">Edit Employee</h2>
		<form action="editurl?id=${id}" method = "post">
			<table class= "table table-hover">
			
				<c:forEach var="index" begin = "0" end = "${columnNames.size() - 1}" step =  "1">
					<tr>
						<td>${columnNames[index]}</td>
						<td><input type="text" name="${columnNames[index]}" value = "${details[index]}"></td>
					</tr>
				</c:forEach>
				
				<tr>
					<td><input type="submit" value="edit"></td>
					<td><input type="reset" value="cancel"></td>
				</tr>
			</table>
		</form>
	</body>
</html>