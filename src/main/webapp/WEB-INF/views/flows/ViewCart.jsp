<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>
<script type="text/javascript">

var app = angular.module("myApp" , []).controller("myCtrl" , function($scope,$http){
	
	$scope.data = [];
	
	$http( {
				method: 'POST',
				url:'http://localhost:9001/movies/getAllCartItems',
				headers : {'Content-Type':'application/x-www-form-urlencoded'}
		}).then(function(response){
	    	console.log(response.data);
		    
	    	$scope.data = response.data;
	    	
		});
	
$scope.Delete=function(arg){
    	
    	alert(arg);
    	
    	var json={"id":arg};
    	
    	console.log( JSON.stringify(json) );
    	
    	$http(	{
			method: 'POST',
      		url: 'deletefromcart',
      		data:JSON.stringify(json),
      		 headers : {'Content-Type':'application/json'}
			}).then(function(response){
		    	console.log(response.data);
		    
		    	//Fetch Again
		    	$http(	{
	    			method: 'POST',
		      		url: 'getAllCartItems',
		      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
	    			}).then(function(response){
				    	console.log(response.data);
				    
				    	$scope.data = response.data;
				    	
	    			});
			});
    }	
});

</script>

<body id="gradl" ng-app="myApp" ng-controller="myCtrl">
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<h1>View Cart</h1>

<table class="table table-striped" style="margin: auto; width: 80%; text-align: center;">
	<thead>
			<tr style="text-align: center;">
				<th>NAME</th>
				<th>PRICE</th>
				<th>QUANTITY</th>
				<th>Image</th>
				<th>DELETE</th>
			</tr>
	</thead>
	<tbody>		
		<tr ng-repeat="x in data">
			<td>{{x.pname}}</td>
			<td>{{x.pprice}}</td>
			<td>{{x.qty}}</td>
			<td><img src="{{x.pimg}}" style="height: 50px; width: 50px;"></td>
			<td><a href="DeleteMovieFromDB/{{x.id}}" class="btn btn-danger">Delete</a></td>
		</tr>
	</tbody>
</table>

<a href="${pageContext.request.contextPath}/ViewMovie">View All Movies</a>
<a href="${flowExecutionUrl}&_eventId=goToPage2">Select Address</a>

<div ng-repeat="x in data">{{x.name}}</div>

</body>
</html>