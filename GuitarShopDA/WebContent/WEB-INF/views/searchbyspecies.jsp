<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>
</head>
<body>
<%-- <table border="1" cellpadding="11" cellspacing="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Tên SP</th>
			<th>Số lượng</th>
			<th>Số lượng còn</th>
			<th>Tên loại</th>
			<th>Tên HSX</th>
			<th>Năm SX</th>
			<th>Màu</th>
			<th>Giá</th>
		</tr>
		<c:forEach items="${spSpecies}" var="sp" varStatus="loop">
			<tr>
				<td>${sp.idSP}</td>
				<td>${sp.tenSP}</td>
				<td>${sp.soLuong}</td>
				<td>${sp.soLuongCon}</td>
				<td>${sp.tenLoai}</td>
				<td>${sp.tenHang}</td>
				<td>${sp.namSX}</td>
				<td>${sp.mauSac}</td>
				<td>${sp.gia}</td>
				<td><img src="images/${sp.anh}" width="200px;" height="200px;"> </td>
			</tr>
		</c:forEach>
		</table> --%>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="banner_right.jsp"></jsp:include>
		<table border="0px" width="70%" style="margin-left: 150px;">
		<tr>
			<td><c:forEach items="${spSpecies}" var="product">
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