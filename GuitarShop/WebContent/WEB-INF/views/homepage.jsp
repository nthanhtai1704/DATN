<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="slide.jsp"></jsp:include>


	<table border="0px" width="70%" style="margin-top: 750px;">
		<tr>
			<td><c:forEach items="${productList}" var="product">
					<div class="col_1_of_3 span_1_of_3">
						<a href="addtoCart?productID=${product.productID}">
							<div class="inner_content clearfix">
								<div class="product_image">
									<img src="data:image/jpeg;base64,${product.productImg}" alt=""
										width="400px" height="300px" />
								</div>
								<div class="price">
									<div class="cart-left">
										<p class="title">${product.productName}</p>
										<p class="title">${product.productType}</p>
										<div class="price1">
											<span class="actual">${product.price} VND</span>
										</div>
									</div>
									<div class="cart-right"></div>
									<div class="clear"></div>
								</div>
							</div>
						</a>
					</div>

				</c:forEach></td>
		</tr>
		<tr>
			<jsp:include page="banner_right.jsp"></jsp:include>
		</tr>

	</table>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>