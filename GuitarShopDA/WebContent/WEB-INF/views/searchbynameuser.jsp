<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guitar Shop</title>
</head>
<body>
	<jsp:include page="headeruser.jsp"></jsp:include>
	<jsp:include page="banner_right.jsp"></jsp:include>
		<table border="0px" width="70%" style="margin-left: 50px;">
		<tr>
			<td><c:forEach items="${spName}" var="product">
					<div class="col_1_of_2 span_1_of_3">
						<a href="productInfo?idSP=${product.idSP}">
							<div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/${product.anh}" alt=""
										width="400px" height="300px" />
								</div>
								<div class="price">
									<div class="cart-left">
										<p class="title">${product.tenSP}</p>
										<p class="title">${product.tenLoai}</p>
										<div class="price1">
											<span class="actual">${product.gia} VND</span>
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
		
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>