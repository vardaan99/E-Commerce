<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Mania</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
	body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 1000px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 1000px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }

}
	
</style>
</head>

<body>
<div class="topnav" id="myTopnav">
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <nav class="navbar navbar-default navbar-inverse">
    	<div class="container">
			<div class="row">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <a class="navbar-brand" href="#">MOVIE MANIA</a>
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Categories</a></li>
						<li><a href="#">Movies</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="login.jsp">Login</a></li>
						<li><a href="signup.jsp">Sign Up</a></li>
					</ul>
					<a href="javascript:void(0);" style="font-size:20px;" class="icon" onclick="myFunction()">&#9776;</a>
				</div>
			</div>
		</div>
	</nav>
</nav>
</div>
	
<script>
    
	function myFunction()
	{
    	var x = document.getElementById("myTopnav");
    		if (x.className === "topnav") 
    		{
        		x.className += " responsive";
   			} 
    		else 
    		{
        		x.className = "topnav";
    		}
    }
</script>

</body>

</html>