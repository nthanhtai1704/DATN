<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
form {
  width: 300px;
  margin: 0 auto;
  text-align: center;
  padding-top: 50px;
}

.value-button {
  display: inline-block;
  border: 1px solid #ddd;
  margin: 0px;
  width: 40px;
  height: 20px;
  text-align: center;
  vertical-align: middle;
  padding: 11px 0;
  background: #eee;
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.value-button:hover {
  cursor: pointer;
}

form #decrease {
  margin-right: -4px;
  border-radius: 8px 0 0 8px;
  width: 60px;
  height: 40px;
  text-align: center;
}

form #increase {
  margin-left: -4px;
  border-radius: 0 8px 8px 0;
  height: 40px;
  width: 60px;
  text-align: center;
}

form #input-wrap {
  margin: 0px;
  padding: 0px;
  height: 40px;
}

input#number {
  text-align: center;
  border: none;
  border-top: 0.5px solid #ddd;
  border-bottom: 0.5px solid #ddd;
  margin: 0px;
  width: 40px;
  height: 40px;
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>

<script src="http://cdnjs.cloudflara.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
function increaseValue() {
	  var value = parseInt(document.getElementById('number').value, 5);
	  value = isNaN(value) ? 0 : value;
	  value++;
	  if(value >=5){ alert('Số lượng đặt không lớn hơn 5')};
	  document.getElementById('number').value = value;
	}

	function decreaseValue() {
	  var value = parseInt(document.getElementById('number').value, 1);
	  value = isNaN(value) ? 1 : value;
	  value < 1 ? value = 1 : '';
	  value--;
	  if(value <1){ alert('Số lượng k bé hơn 0')};
	  document.getElementById('number').value = value;
	}
</script>
<title>GuitarShop</title>
</head>
<body>
	<jsp:include page="headeruser.jsp"></jsp:include>
	<div class="mens">
		<div class="main">
			<!---728x90--->
			<div class="wrap">
				<div class="cont span_2_of_3">
					<div class="grid images_3_of_2">
						<!-- FlexSlider -->
						<script src="js/imagezoom.js"></script>
						<script defer src="js/jquery.flexslider.js"></script>
						<link rel="stylesheet" href="css/flexslider.css" type="text/css"
							media="screen" />
						<script>
							// Can also be used with $(document).ready()
							$(window).load(function() {
								$('.flexslider').flexslider({
									animation : "slide",
									controlNav : "thumbnails"
								});
							});
						</script>
						<!-- //FlexSlider-->
						<div class="flexslider">
							<ul class="slides">
								<%-- <li data-thumb="images/s1.jpg">
									<div class="thumb-image">
										<img src="images/${sp.anh}" data-imagezoom="true"
											class="img-responsive">
									</div>
								</li>
								<li data-thumb="images/s2.jpg">
									<div class="thumb-image">
										<img src="images/${sp.anh}" data-imagezoom="true"
											class="img-responsive">
									</div>
								</li>
								<li data-thumb="images/s4.jpg">
									<div class="thumb-image">
										<img src="images/${sp.anh}" data-imagezoom="true"
											class="img-responsive">
									</div>
								</li> --%>
								<li data-thumb="images/s3.jpg">
									<div class="thumb-image">
										<img src="images/${sp.anh}" data-imagezoom="true"
											class="img-responsive">
									</div>
								</li>
							</ul>
							<div class="clearfix"></div>
							
						</div>
					</div>
					
					<div class="desc1 span_3_of_2">
						<h3 class="m_3">${sp.tenSP}</h3>
						<span class="m_3"> ${sp.tenLoai}</span>
						<p class="m_5">
							${sp.gia} VND <span class="reducedfrom"> 1000000 VND</span>
						</p>
						
						
						
						
						<p class="m_text2">${sp.moTa}</p>
						<div>
						<form action="${pageContext.request.contextPath}/addToCart" method="post">
						<div>
						Số lượng:
<div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
  <input type="number" id="number" value="1" name="soLuong" />
  <div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div>
							<!--  <select name="soLuong">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select> -->
						</div>
						<div class="btn_form">
						<a href="${pageContext.request.contextPath}/orderProduct" class="btn btn-primary">Mua ngay</a>
						<input class="btn btn-warning" type="submit" value="Thêm vào giỏ">
						</div>
		</form>
				</div>		
					</div>
				</div>
				<div class="rsingle span_1_of_single">
					<h5 class="m_1" style="text-align: center;">KHUYỄN MÃI ÁP
						DỤNG KHI MUA GUITAR</h5>
					<div class="area_promotion zero">
						<p style="text-align: center;">
							<strong> </strong>
						</p>
						<p style="text-align: center;">
							<img class="alignnone wp-image-1065"
								src="https://shopguitardanang.com/wp-content/uploads/2019/07/khoa-hoc-mien-phi-3-533x400.jpg"
								alt="" width="106" height="79">
						</p>
						<p style="text-align: center;">
							<span style="font-size: 90%;">Tặng kèm: khóa học đàn
								guitar, ukulele miễn phí</span>
						</p>
						<p style="text-align: center;">
							<img class="alignnone wp-image-818"
								src="https://shopguitardanang.com/wp-content/uploads/2019/07/qua-tang-2.png"
								alt="" width="96" height="102">
						</p>
						<p style="text-align: center;">
							<span style="font-size: 90%;">Tặng kèm : Bao da,capo,pick
								1 bộ dây, giáo trình cơ bản</span>
						</p>
					</div>
					<script src="js/jquery.easydropdown.js"></script>

				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		
		<div style="margin-left: 60px;">
						<form action="${pageContext.request.contextPath}/comment"
							method="POST">
							<p>Bình luận:</p>
							<input type="text" name="loiBL" size="45">
							 <input type="submit" value="Gủi">
						</form>
					</div>
					<div style="margin-left: 60px;">
							<c:forEach items="${blList}" var="comment">
								<table>
								<tr>
									<th><i style="color: red;">${comment.hoTen}:</i></th>
									<td>${comment.loiBL}</td>
								</tr>
								</table>
							</c:forEach>

						</div>
	
		<div class="clear"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<div class="clear"></div>

</body>
</html>