<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Movie</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body id="grad1">
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>

<h1 style="margin: auto; width: 80%; text-align: center;">View Movie</h1>

<br>

<table class="table table-striped" style="margin: auto; width: 80%; text-align: center;">

	<thead>
	
		<tr style="text-align: center;">
			<th>ID</th>
			<th>NAME</th>
			<th>PRICE</th>
			<th>DESCRIPTION</th>
			<th>IMAGE PATH</th>
			<th>QUANTITY</th>
			
		</tr>
	
	</thead>

	<tbody>
	
	
		
		<br>    
    	<tr>
		
			<td align="left">${Movie.getMid()}</td>
			<td align="left">${Movie.getName()}</td>
			<td align="left">${Movie.getPrice()}</td>
			<td align="left">${Movie.getDescription()}</td>
			<td><img src="${Movie.getImage()}" style="height:50px; width:50px;"></td>
		
			
		</tr>
		
		<form action="${pageContext.request.contextPath}/AddCartToDB" method="post">
	
		<input type="hidden" value="${Movie.getMid()}" name="Id">
		
		<br>
		<br>
		<input type="number" placeholder="Quantity" class="form-control" name="quantity" style="margin: auto;  width: 10%; text-align: center;">
		<br>    
    	<button type="submit" class="btn btn-success" style=" float:left; margin-left:50px; margin-top:23px">AddToCart</button>	
	
		</form>
	
				
	</form>	
			
	</tbody>

</table>

</body>
</html>