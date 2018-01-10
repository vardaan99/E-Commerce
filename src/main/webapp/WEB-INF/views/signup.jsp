<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>


<body>

<style>
/*scroll effect*/
.navbar-trans {
  background-color: transparent;
  border: none;
  transition: top 1s ease;
}
 
/*double row*/
.navbar-doublerow > .navbar{
	display: block;	
	padding: 0px auto;
	margin: 0px auto;
	min-height: 25px;
}
.navbar-doublerow .nav{
	padding: 0px auto;
}
.navbar-doublerow .dividline{
  margin: 5px 100px;
  padding-top: 1px;
  background-color: inherit;
}
/*top nav*/
.navbar-doublerow .navbar-top ul>li>a {
	padding: 10px auto;
	font-size: 12px;
} 
/*down nav*/
.navbar-doublerow .navbar-down .navbar-brand {
	padding: 0px auto;
	float: left;
	color: #01579B;
	font-size: 32px;
}
.navbar-doublerow .navbar-down ul>li>a{
	font-size: 16px;
	color: #01579B;
	transition: border-bottom .2s ease-in , transform .2s ease-in-out;
}
.navbar-doublerow .navbar-down ul>li>a:hover{
	border-bottom: 1px solid #fff;
	color: #01579B;
}
.navbar-doublerow .navbar-down .dropdown{
    padding: 5px;
    color: #01579B;
}
.navbar-doublerow .navbar-down .dropdown ul>li>a,
.navbar-doublerow .navbar-down .dropdown ul>li>a:hover{
  color: #01579B;
  border-bottom: none;
}
.navbar-doublerow.navbar-trans.afterscroll {
}	
.navbar-doublerow.navbar-trans.afterscroll {
   top:-50px;
}	

.flex-container {
    display: flex;
    justify-content: space-between;
}
.flex-item {
}
/*text*/
.text-white,.text-white-hover:hover{color:#01579B!important}
/*fontcolor*/
.light-grey {color:#01579B!important;background-color:#E6E9ED!important}


.form-control { 

margin-bottom: 10px;

 }
 
.content_bottom  { 
border-top: 5pt solid #f4f4f4;
padding: 10pt;
border-collapse: separate;
text-align: left;

}

</style>

<header>
    <img src="http://res.cloudinary.com/dcggaci79/image/upload/v1510855596/popcorn-1433327_1920_e2etqp.jpg" style="width:100%">
</header>

<nav class="navbar navbar-default navbar-doublerow navbar-trans navbar-fixed-top">
  <!-- top nav -->
  <nav class="navbar navbar-top hidden-xs">
    <div class="container">
      <!-- left nav top -->
      <ul class="nav navbar-nav pull-left">
        <li><a href="#"><span class="glyphicon glyphicon-thumbs-up text-white"></span></a></li>
        <li><a href="#"><span class="glyphicon glyphicon-globe text-white"></span></a></li>
        <li><a href="#"><span class="glyphicon glyphicon-pushpin text-white"></span></a></li>
        <li><a href="#"><span class="text-white">QUESTIONS? CALL: <b>+963000000000</b></span></a></li>
      </ul>
      <!-- right nav top -->
      <ul class="nav navbar-nav pull-right">
       <li><a href="#" class="text-white">About Us</a></li>
        <li><a href="#" class="text-white">Contact Us</a></li> 
       </ul>
    </div>
    <div class="dividline light-grey"></div>
  </nav>
  <!-- down nav -->
  <nav class="navbar navbar-down">
    <div class="container">
      <div class="flex-container">  
        <div class="navbar-header flex-item">
          <div class="navbar-brand" href="#">Mad Over Movies</div>
        </div>
        <ul class="nav navbar-nav flex-item hidden-xs">
          <li><a href="#">Categories</a></li>
          <li><a href="#">Rating</a></li> 
          <li><a href="#">TheTeam</a></li> 
        </ul>
        <ul class="nav navbar-nav flex-item hidden-xs pull-right">
          <li><a href="login" class="text-white">Already a user? Login</a></li>
        </ul>
        <!-- dropdown only moblie -->
          <div class="dropdown visible-xs pull-right">
            <button class="btn btn-default dropdown-toggle " type="button" id="dropdownmenu" data-toggle="dropdown">
              <span class="glyphicon glyphicon-align-justify"></span> 
            </button>
            <ul class="dropdown-menu">
              <li><a href="#">Categories</a></li>
              <li><a href="#">Rating</a></li> 
              <li><a href="#">TheTeam</a></li> 
              <li role="separator" class="divider"></li>
              <li><a href="#">Contact us</a></li>
            </ul>
          </div>
        </div>  
      </div>
 <div class="container">
    <div class="row">
    <div class ="col-md-4">
    </div>
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm" >
            <legend><a href="http://www.jquery2dotnet.com"><i class="glyphicon glyphicon-globe"></i></a> Sign up!</legend>
            <form action="#" method="post" class="form" role="form">
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <input class="form-control" name="firstname" placeholder="First Name" type="text"
                        required autofocus />
                </div>
                <div class="col-xs-6 col-md-6">
                    <input class="form-control" name="lastname" placeholder="Last Name" type="text" required />
                </div>
            </div>
            <input class="form-control" name="youremail" placeholder="Your Email" type="email" />
            <input class="form-control" name="reenteremail" placeholder="Re-enter Email" type="email" />
            <input class="form-control" name="password" placeholder="New Password" type="password" />
            <label for="">
                Birth Date</label>
            <div class="row">
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Month">Month</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Day">Day</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Year">Year</option>
                    </select>
                </div>
            </div>
            <label class="radio-inline">
                <input type="radio" name="sex" id="inlineCheckbox1" value="male" />
                Male
            </label>
            <label class="radio-inline">
                <input type="radio" name="sex" id="inlineCheckbox2" value="female" />
                Female
            </label>
            <br />
            <br />
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Sign up</button>
            </form>
        </div>
    </div>
</div>
    </nav>
  </nav> 
<!--bg img  -->


<script>// toggle class scroll 
$(window).scroll(function() {
    if($(this).scrollTop() > 50)
    {
        $('.navbar-trans').addClass('afterscroll');
    } else
    {
        $('.navbar-trans').removeClass('afterscroll');
    }  

});
  </script>

</body>
</html>