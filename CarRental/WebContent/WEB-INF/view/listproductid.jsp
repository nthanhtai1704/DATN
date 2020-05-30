<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="headeruser.jsp"></jsp:include>
	<div class="product">
		<div class="container">

			<div class="product-price1">
				<div class="top-sing">
					<div class="col-md-7 single-top">
						<div class="flexslider">
							<ul class="slides">
								<li data-thumb="images/si.jpg">
									<div class="thumb-image">
										<img src="images/${product.avatar}" data-imagezoom="true"
											class="img-responsive">
									</div>
								</li>
							</ul>
						</div>

						<div class="clearfix"></div>
						<!-- slide -->


						<!-- FlexSlider -->
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
					</div>
					<div class="col-md-5 single-top-in simpleCart_shelfItem">
						<div class="single-para ">
							<h4>${product.nameproduct}</h4>
							<div class="star-on">

								<div class="review">
									<a href="#"> ${product.quantity} review </a>

								</div>
								<div class="clearfix"></div>
							</div>

							<h5 class="item_price">${product.price}$</h5>
							<p>${product.species}</p>
							<p>${product.status}</p>
							<a href="contract?id_product=${product.idproduct}"
								class="add-cart item_add">Thuê</a>


						</div>
					</div>

					<div class="clearfix"></div>
					<div>
						<form action="${pageContext.request.contextPath}/comment"
							method="POST">
							<p style="color: blue;">Bình luận:</p>
							<input type="text" name="textcomment" size="70" required="required" >
							 <input type="submit" value="Gửi">
						</form>
					</div>
					<div>
							<c:forEach items="${listComment}" var="comment">
								<p>
									<i style="color: red;">${comment.fullName}:</i>
									${comment.comment}
								</p>
							</c:forEach>

						</div>
				</div>
				<!---->


			</div>

			<div class="clearfix"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>