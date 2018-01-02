<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<br>

<h1 style="margin: auto; width: 80%; text-align: center;">Movie</h1>

<br>

<form:form method="post" action="AddMovieToDB" modelAttribute="Movie" style="margin: auto; width: 80%; text-align: center;" enctype="multipart/form-data">

	<form:input path="name" type="text" class="form-control" placeholder="Movie Name" />
	
	<br>
	
	<form:input path="Rating" type="" class="form-control" placeholder="Rating" />
	
	<br>
	
	<form:textarea path="Description" class="form-control" placeholder="Movie Description"/> 

	<br>
	
	<form:input path="f" type="file" class="form-control" placeholder="Add Image" />

	<br>

	<input type="submit" class="btn btn-primary" value="Submit"/>

</form:form>


</body>
</html>