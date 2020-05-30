<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tìm kiếm</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2 align="center">Danh Sách Sản Phẩm</h2>
	<table width="70%" style="margin-left: 50px; margin-top: 50px;" >
		<thead>
			<tr>
				<th>ID</th>
				<th>TÊN SẢN PHẨM</th>
				<th>ẢNH</th>
				<th>GIÁ</th>
			</tr>
		</thead>
		<c:forEach items="${searchList}" var="product">
			<tbody>
				<tr>
					<td>${product.idproduct}</td>
					<td>${product.nameproduct}</td>
					<td><img src="images/${product.avatar}" width="300px"
						height="220px" /></td>
					<td>${product.price}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>