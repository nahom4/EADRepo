<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel= "stylesheet" href="css/bootstrap.css">
<script src="https://kit.fontawesome.com/0492c06513.js" crossorigin="anonymous"></script>
</head>

<body class= "container-fluid">
	<h2 class = "bg-primary text-white text-center">Employee List</h2>
	<table class="table ">
		<thead>
			<tr>
				<c:forEach var = "columName"  items= "${columnNames}">
					<th>${columName}</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var= "row" items = "${rows}">
			<tr>
				<c:forEach var = "col" items = "${row}">
					<td>${col}</td>
				</c:forEach>
				<td><a href = "edit?id=${row[0]}"><i class="fa-regular fa-pen-to-square"></i></a></td>
				<td><a href = "delete?id=${row[0]}"><i class="fa-solid fa-trash-can"></i></a></td>
			</tr>
	
			</c:forEach>
		</tbody>
		
	</table>
	<div class="d-flex align-items-center justify-content-center">
		<a href="AddEmployee.html">
			<i class="fa-solid fa-plus fa-2x"></i>
		</a>
    	
	</div>

	
</body>

</html>