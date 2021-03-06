<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>

<h1 style="margin: auto; width: 80%; text-align: center;">View Genre</h1>

<br>

<table class="table table-striped" style="margin: auto; width: 80%; text-align: center;">

	<thead>
	
		<tr style="text-align: center;">
			<th>ID</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
	
	</thead>

	<tbody>
			
		<c:forEach items="${AllGenre}" var="x">
		
		<tr>
			<td align="left">${x.getId()}</td>
			<td align="left">${x.getName()}</td>
			<td align="left">${x.getDescription()}</td>
			<td align="left"><a href="UpdateGenre/${x.getId()}" class="btn btn-danger">Update</a></td>
			<td align="left"><a href="DeleteGenreFromDB/${x.getId()}" class="btn btn-danger">Delete</a></td>
		</tr>
		
		</c:forEach>		
			
		
			
	</tbody>

</table>

</body>
</html>