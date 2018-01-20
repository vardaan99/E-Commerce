<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

/*Sign up form*/
  .mycolor{
            color : #72c02c;
        }        
        .myborder{
            padding: 20px;;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: 0px 0px 3px 0px #72c02c;
            -moz-box-shadow:    0px 0px 3px 0px #72c02c;
            box-shadow:         0px 0px 3px 0px #72c02c;
        }
        .mybutton{
            position: relative;
            left: 50%;
            top: 193px;

        }
        .margin-bottom-20 {
            margin-bottom: 20px;

        }
        .btn-u:hover {
            background: #5fb611;
        }
        .btn-u:hover, .btn-u:focus, .btn-u:active, .btn-u.active, .open .dropdown-toggle.btn-u {
            background: #5fb611;
        }
        .btn-u:hover {
            color: #fff;
            text-decoration: none;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }
        .btn-u {
            background: #72c02c;
        }
        .btn-u {
            white-space: nowrap;
            border: 0;
            color: #fff;
            font-size: 14px;
            cursor: pointer;
            font-weight: 400;
            padding: 6px 13px;
            position: relative;
            background: #72c02c;
            display: inline-block;
            text-decoration: none;
        }
        .input-group-addon {
            border-right: 0;
            /*color: #b3b3b3;*/
            font-size: 14px;
            background: #fff;
            padding: 6px 12px;
            font-size: 14px;
            font-weight: 400;
            line-height: 1;
            color: #555;
            text-align: center;
            background-color: #eee;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .input-group .form-control {
            float: left;
            width: 100%;
            margin-bottom: 0;
        }
        .form-control {
            box-shadow: none;
        }
        .form-control {
            display: block;
            width: 100%;
            height: 34px !important;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.428571429;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid  #72c02c !important;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        }
</style>

<header>
    <img src="http://res.cloudinary.com/dcggaci79/image/upload/v1511462181/um08ywluqywhvawbwcav.jpg" style="width:100%">
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
 <br />
 <form:form method="post" action="AddProfilesToDB" modelAttribute="Profiles" style="margin: auto; width: 80%; text-align: center;">
<div class="container">
    <div class="col-md-3"></div>
    <div class="col-md-6">
         <div class="row myborder">
             <h4 style="color: #7EB59E; margin: initial; margin-bottom: 10px;">Sign Up Now</h4><hr>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                <form:input size="60" maxlength="255" class="form-control" placeholder="Email ID" path="Email" id="UserRegistration_username" type="text"/>                                                        </div>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock mycolor"></i></span>
                <form:input size="60" maxlength="255" class="form-control" placeholder="Password" path="Password" id="UserRegistration_password" type="password"/>                                    </div>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                <form:input size="60" maxlength="255" class="form-control" placeholder="First Name" path="First_Name" id="UserRegistration_fname" type="text"/>                                    </div>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                <form:input size="60" maxlength="255" class="form-control" placeholder="Last Name" path="Last_Name" id="UserRegistration_lname" type="text"/>                                    </div>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope mycolor"></i></span>
                <form:input size="60" maxlength="255" class="form-control" placeholder="Address" path="Address" id="UserRegistration_address" type="text"/>                                    </div>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-phone mycolor"></i></span>
                <form:input size="60" maxlength="255" class="form-control" placeholder="Contact Number" path="Contact_Number" id="UserRegistration_contactnumber" type="text"/>                                    </div>
            <div class="row">
                <div class="col-md-12">
                    <button class="btn-u pull-left" type="submit">Sign Up</button>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
      </div>
      </form:form>
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