<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profiles</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<br>

<h1 style="margin: auto; width: 80%; text-align: center;">View Profiles</h1>

<br>

<table class="table table-striped" style="margin: auto; width: 80%; text-align: center;">

	<thead>
	
		<tr style="text-align: center;">
			<th>ID</th>
			<th>FIRST NAME</th>
			<th>LAST NAME</th>
			<th></th>
			<th>PASSWORD</th>
			<th>DOB</th>
			<th>GENDER</th>
		</tr>
	
	</thead>

	<tbody>
			
		<c:forEach items="${AllProfiles}" var="x">
		
		<tr>
			<td align="left">${x.getId()}</td>
			<td align="left">${x.getFirst_Name()}</td>
			<td align="left">${x.getLast_Name()}</td>
			<td align="left">${x.getEmail()}</td>
			<td align="left">${x.getPassword()}</td>
			<td align="left">${x.getDate()}</td>
			<td align="left">${x.getGender()}</td>
			<td align="left"><a href="UpdateProfiles/${x.getId()}" class="btn btn-danger">Update</a></td>
			<td align="left"><a href="DeleteProfilesFromDB/${x.getId()}" class="btn btn-danger">Delete</a></td>
		</tr>
		
		</c:forEach>		
			
		
			
	</tbody>

</table>

</body>
</html>