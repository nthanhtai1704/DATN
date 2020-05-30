<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="social">
				<ul>
					<li><a href="#"><i class="facebok"> </i></a></li>
					<li><a href="#"><i class="twiter"> </i></a></li>
					<li><a href="#"><i class="inst"> </i></a></li>
					<li><a href="#"><i class="goog"> </i></a></li>
						<div class="clearfix"></div>	
				</ul>
			</div>
			<div class="header-left">
			
				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form action="${pageContext.request.contextPath}/searchProduct" method="GET">
							<input class="sb-search-input" name="search" placeholder="vui lòng điền thông tin..." type="search"  id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
			
<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->

				<div class="ca-r">
					<div class="cart box_1">
						
						

					</div>
				</div>
					<div class="clearfix"> </div>
			</div>
				
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="logo">
					<h1><a href="${pageContext.request.contextPath}/home">Cho Thuê Xe</a></h1>
				</div>
		<form action="${pageContext.request.contextPath}/searchBySpecies" method="get">
		  <div class="h_menu4">
				<ul class="memenu skyblue">
				
					  <li><a class="color8" href="index.html">XE BUS</a></li>	
				      <li><a class="color1" href="#">XE Ô TÔ</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="searchBySpecies?species=Mercedes">Mercedes</a></li>
										<li><a href="products.html">Mercedes 4 seats</a></li>				
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="searchBySpecies?species=audi">Audi 6 seats</a></li>
										<li><a href="products.html">Audi 4 seats </a></li>							
									</ul>	
								</div>							
							</div>
									<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="products.html">Honda 16 seats</a></li>
										<li><a href="products.html">Honda 4 seats</a></li>								
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="products.html">ford 16 seats</a></li>
										<li><a href="products.html">ford 4 seats</a></li>						
									</ul>	
								</div>							
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid"><a class="color2" href="#">XE MOTO</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="searchBySpecies?species=MOTO">BMW</a></li>		
									</ul>	
								</div>								
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
								<li><a href="products.html">Yamaha</a></li>	
										
									</ul>		
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">								
									<ul>														
										<li><a href="products.html">vinfast</a></li>	
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<li><a class="color4" href="${pageContext.request.contextPath}/login">ĐĂNG NHẬP</a></li>				
				<li><a class="color6" href="${pageContext.request.contextPath}/contact">ĐĂNG KÝ</a></li>
			  </ul> 
			</div>
			</form>
				
				<div class="clearfix"> </div>
		</div>
		</div>		
	</div>
	
	
</body>
</html>