<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>
<script>

var app = angular.module("myApp", []).controller("myCtrl", function($scope,$http) {
    
$scope.data = [];
    
    $scope.total = 0;
    
    $http(	{
    			method: 'POST',
	      		url: 'http://localhost:9001/movies/getAllCartItems',
	      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
    			}).then(function(response){
			    	console.log(response.data);
			    
			    	$scope.data = response.data;
			    	
			    	for( var x = 0; x < $scope.data.length ; x++ )
			    	{
			    		$scope.total += $scope.data[x].pprice *  $scope.data[x].qty;
			    	}
			    	
    			});
    
    $scope.Delete=function(arg){
    	
    	alert(arg);
    	
    	var json={"id":arg};
    	
    	console.log( JSON.stringify(json) );
    	
    	$http(	{
			method: 'POST',
      		url: 'http://localhost:9001/movies/DeleteCartItems',
      		data:JSON.stringify(json),
      		 headers : {'Content-Type':'application/json'}
			}).then(function(response){
		    	console.log(response.data);
		    
		    	//Fetch Again
		    	$http(	{
	    			method: 'POST',
		      		url: 'http://localhost:9001/movies/getAllCartItems',
		      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
	    			}).then(function(response){
				    	console.log(response.data);
				    
				    	$scope.data = response.data;
				    	
	    			});
			});   	
    }    
});
</script>

<body ng-app="myApp" ng-controller="myCtrl">
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<h1 class="alert alert-success"><center>Invoice</center></h1>
<br><br><br>
<table class="table table-striped " style="margin: auto; width: 80%;">
	<thead>
		<tr>
			<th></th>
			<th></th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>		
		</tr>
	</thead>
	
	<tbody>
		<tr ng-repeat="x in data">
			<td><img src="{{x.pimg}}" style="width:100px; height:100px; border: 1px solid black; box-shadow: 8px 8px 6px grey;" class="img-responsive indexcatimage"></td>
			<td>{{x.pname}}</td>			
			<td>&#8377; {{x.pprice}}</td>
			<td>{{x.qty}}</td>
			<td>&#8377;{{x.pprice*x.qty}}</td>
			
		</tr>
			<td></td>
			<td></td>
			<td></td>
			<td><span style="font-weight:bold;">Grand Total:-</span></td>
			<td><span style="font-weight:bold;">&#8377; {{total}}</span></td>
		<tr>	
		</tr>
	</tbody>
</table>
<br>
<br>
<br>


<a href="${flowExecutionUrl}&_eventId=goToPage2">Select Address</a>
<a href="${flowExecutionUrl}&_eventId=goToPage4">Order Complete</a>

</body>
</html>