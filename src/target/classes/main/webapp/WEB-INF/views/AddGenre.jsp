<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<br>

<h1 style="margin: auto; width: 80%; text-align: center;">Add Genre</h1>

<br>

<form:form method="post" action="AddGenreToDB" modelAttribute="Genre" style="margin: auto; width: 80%; text-align: center;">

	<form:input path="name" type="text" class="form-control" placeholder="Genre Name" />
	
	<br>
	
	<form:textarea path="Desciption" class="form-control" placeholder="Genre Description"/> 

	<br>

	<input type="submit" class="btn btn-primary" value="Submit"/>

</form:form>


</body>
</html>