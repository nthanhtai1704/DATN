
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Cho thue xe du lich</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Mattress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<jsp:include page="header.jsp"></jsp:include>
<div class="grow">
		<div class="container">
			<h2>Login</h2>
		</div>
	</div>
	<!-- grow -->
<!--content-->
<div class="container">
		<div class="account">
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<form action="${pageContext.request.contextPath}/login" method="post">			
			<div> 	
				<span>Username :</span>
				<input type="text" name="name"> 
			</div>
			<div> 
				<span >Password</span>
				<input type="password" name="pass">
			</div>				
				<input type="submit" value="Login"> 
			</form>
		</div>
		<div class="col-md-4 left-account ">
			<a href="single.html"><img class="img-responsive " src="images/1.jpg" alt=""></a>
			<div class="five">
			<h2>25% </h2><span>discount</span>
			</div>
			<a href="register.html" class="create">Create an account</a>
<div class="clearfix"> </div>
		</div>
	<div class="clearfix"> </div>
	</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
			