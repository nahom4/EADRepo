<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="container-fluid">
	<h1 class="text-white text-center bg-primary">Calculator</h1>
    <form action="OpperationsServlet" class="bg-primary text-white p-3">
        <div class="form-group">
            <label for="input1">Input 1:</label>
            <input type="text" class="form-control" id="input1" value="0" name="input1">
        </div>
        <div class="form-group">
            <label for="input2">Input 2:</label>
            <input type="text" class="form-control" id="input2" value="0" name="input2">
        </div>
        <div class="form-group">
            <label for="symbolDropdown">Select a Symbol:</label>
            <select id="symbolDropdown" class="form-control" name="opperation">
                <option value="+">+</option>
                <option value="*">*</option>
            </select>
        </div>
        <button type="submit" class="btn btn-light">Calculate</button>
         <div class="container d-flex justify-content-center align-items-center text-white">
         	<div class = "bg-dark p-3">
         		${result}
         	</div>
        	
    	</div>
    </form>
   
</body>
</html>