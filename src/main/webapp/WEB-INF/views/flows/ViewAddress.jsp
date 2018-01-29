<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Address</title>

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
    
    $scope.Shipping_Address='';
    $scope.Billing_Address='';

    $scope.done = false;
    
    $http(	{
    			method: 'POST',
	      		url: 'http://localhost:9001/movies/getAddress',
	      		 headers : {'Content-Type':'application/x-www-form-urlencoded'}
    			}).then(function(response){
			    	console.log(response.data);
			    
			    	$scope.data = response.data;
			   
			    	$scope.BAdd=response.data.Shipping_Address;
			        $scope.SAdd=response.data.Billing_Address;
			        
			        console.log( $scope.Shipping_Address );
			        console.log( $scope.Billing_Address );
    			});
    
 $scope.Update=function(){
    	
	 	var json = {"ship":$scope.Shipping_Address,"bill":$scope.Billing_Address};
	 
	 	console.log(json);
	 	
    	$http(	{
			method: 'POST',
      		url: 'http://localhost:9001/movies/UpdateCartAddToDB',
      		data:JSON.stringify(json),
      		 headers : {'Content-Type':'application/json'}
			}).then(function(response){
		    	console.log(response.data);
		    
		    	if(response.data.msg=="Updated")
		    	{
		    		$scope.done = true;	    	
		    	}
			});
    }
});
</script>

<body ng-app="myApp" ng-controller="myCtrl">
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<h1 class="alert alert-success"><center>Confirm Billing Address</center></h1> 
<br><br><br>
<table class="table table-striped " style="margin: auto; width: 50%;">
	<thead>
		<tr>
      		<th>${currUser} Shipping Address</th>
			<th>${currUser} Billing Address</th>			
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><textarea rows="5" name="Shipping_Address"  class="form-control" ng-model="Shipping_Address" placeholder="Enter Shipping Address"></textarea></td>
			<td><textarea rows="5" name="Billing_Address" class="form-control" ng-model="Billing_Address" placeholder="Enter Billing Address"></textarea></td>
		</tr>
	</tbody>
	
	<tbody>
		<tr>
			<td><button ng-click="Update()" class="btn btn-success">Edit</button></td>
			<td><button ng-click="Update()" class="btn btn-success">Edit</button></td>
		</tr>
	</tbody>
</table>
<br>
<br>
<h1 class="text text-success" ng-show='done' style="margin: auto; width: 80%; text-align: center;">Updated Successfully</h1> 
<br>
<br>

<a href="${flowExecutionUrl}&_eventId=goToPage1">Back to Items</a>
<a href="${flowExecutionUrl}&_eventId=goToPage3">Place Order and Get Invoice</a>

</body>
</html>