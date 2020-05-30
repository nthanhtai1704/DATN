<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:include page="headeruser.jsp"></jsp:include>
<!--content-->
<div class="banner">
		<div class="container">
			  <script src="js/responsiveslides.min.js"></script>
  <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
			<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
			    <li>
					
						<div class="banner-text">
							<h3>Thuê xe , Thám Hiểm Mơ Mộng Khám Phá </h3>
						<p>Hai mươi năm về sau bạn sẽ hỗi hận nhiều hơn về Những gì bạn không làm .
							Vậy nên hãy tháo dây , nhổ neo ra khỏi bến đổ an toàn.
							Hãy Để Cánh buồm của bạn đón trọn lấy gió.
						</p>
						
						</div>
				
				</li>
				<li>
					
						<div class="banner-text">
							<h3>Vì sao thuê xe bên chúng tôi ? </h3>
						<p>Chúng tôi luôn mạng lại những trãi nghiệm tiệc vời giữa bạn với những
							Chiếc xe đẹp và đầy quyến rủ.Không chỉ dừng lại ở việc xe đẹp mà xe còn
							chất lượng và bao rẻ cho những chuyển du lịch của bạn .
						</p>
												

						</div>
					
				</li>
				<li>
						<div class="banner-text">
							<h3>Lý do phải trãi nghiệm</h3>
						<p>Vì cuộc đời nãy chỉ có một lần
							Ngại gì mà bạn không trãi nghiệm.
						</p>
								

						</div>
					
				</li>
			</ul>
		</div>

	</div>
	</div>
	<div class="container">
			<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
			    <li>				
						<div class="banner-text">												
						</div>			
				</li>
				<li>				
						<div class="banner-text">															
						</div>					
				</li>
				<li>
						<div class="banner-text">						
						</div>				
				</li>
			</ul>
		</div>
	</div>
<div class="container" style="margin-bottom: 100%">
	<div class="cont">
		<div class="content">
			<div class="content-top-bottom">
				<h2>Mới</h2>
				<div class="col-md-6 men">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/xe2.jpg" alt="">
						<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in   b-delay03 ">
												<span>Audi</span>	
											</h3>
										</div>
					</a>
					
					
				</div>
				<div class="col-md-6">
					<div class="col-md1 ">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/xe3.jpg" alt="">
							<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in1   b-delay03 ">
												<span>Ford</span>	
											</h3>
										</div>
						</a>
						
					</div>
					<div class="col-md2">
						<div class="col-md-6 men1">
							<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/xe4.jpg" alt="">
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>Audi</span>	
											</h3>
										</div>
							</a>
							
						</div>
						<div class="col-md-6 men2">
							<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/xe5.jpg" alt="">
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>Audi</span>	
											</h3>
										</div>
							</a>
							
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>	
			<div class="content-top">
				<h1>XE</h1>
				<div class="grid-in">
				<c:forEach items="${listpt}" var="product">
					<div class="col-md-4 grid-top simpleCart_shelfItem">
						<a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/${product.avatar}" alt="">
							<div class="b-wrapper">
								<h3 class="b-animate b-from-left    b-delay03 ">
									<span>${product.nameproduct}</span>
									
								</h3>
							</div>
						</a>
				

					<p><a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}">${product.nameproduct}</a></p>
					<a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}" class="item_add"><p class="number item_price"><i> </i>${product.price}</p></a>
					</div>
					<div class="col-md-4 grid-top simpleCart_shelfItem">
						<a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/${product.avatar}" alt="">
							<div class="b-wrapper">
											<h3 class="b-animate b-from-left    b-delay03 ">
												<span>${product.nameproduct}</span>	
											</h3>
										</div>
						</a>
					<p><a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}">${product.nameproduct}</a></p>
					<a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}" class="item_add"><p class="number item_price"><i> </i>${product.price}</p></a>
					</div>
					<div class="col-md-4 grid-top">
						<a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/${product.avatar}" alt="">
							<div class="b-wrapper">
											<h3 class="b-animate b-from-left    b-delay03 ">
												<span>${product.nameproduct}</span>	
											</h3>
										</div>
						</a>
					<p><a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}">${product.nameproduct}</a></p>
					<a href="${pageContext.request.contextPath}/listProductid?id_product=${product.idproduct}" class="item_add"><p class="number item_price"><i> </i>${product.price}</p></a>
					</div>
					</c:forEach>
							<div class="clearfix"> </div>
				</div>
			</div>
			
		</div>
	<!----->
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
			