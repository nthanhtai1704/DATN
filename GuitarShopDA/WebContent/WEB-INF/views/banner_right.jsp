<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="#sidebarB">
	<div class="rsidebar span_1_of_left">
		<div class="top-border"></div>
		<div class="border">
			<link href="css/default.css" rel="stylesheet" type="text/css"
				media="all" />
			<link href="css/nivo-slider.css" rel="stylesheet" type="text/css"
				media="all" />
			<script src="js/jquery.nivo.slider.js"></script>
			<script type="text/javascript">
				$(window).load(function() {
					$('#slider').nivoSlider();
				});
			</script>
			<div class="slider-wrapper theme-default">
				<div id="slider" class="nivoSlider">
					<img src="images/l1.jpg" alt="" /> <img
						src="images/l2.jpg" alt="" /> <img src="images/l3.jpg"
						alt="" />
				</div>
			</div>
			
		</div>
		<div class="top-border"></div>
		<div class="sidebar-bottom">
			<h2 class="m_1">
				Tìm kiếm theo giá
			</h2>
			<a href="${pageContext.request.contextPath}/searchByPrice?price=700000;999999"><img alt="" src="images/tien.png" width="20px;" height="20px;">700.000-1.000.000</a></br></br>
			<a href="${pageContext.request.contextPath}/searchByPrice?price=1000000;1500000"><img alt="" src="images/tien.png" width="20px;" height="20px;">1.000.000-1.500.000</a>
		</div>
	</div>
</div>