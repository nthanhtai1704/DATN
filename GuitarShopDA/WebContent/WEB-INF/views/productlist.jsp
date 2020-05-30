<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<h2 style="text-align: center; color: blue;">DANH SÁCH SẢN PHẨM</h2>
	
	<table  border="1" cellpadding="8" cellspacing="1" width="100%">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Tên sản phẩm</th>
			<th scope="col">Tên loại</th>
			<th scope="col">Tên HSX</th>
			<th scope="col">Số lượng</th>
			<th scope="col">Số lượng còn</th>
			<th scope="col">Năm SX</th>
			<th scope="col">Màu sắc</th>
			<th scope="col">Ảnh</th>
			<th  scope="col" colspan="2">Cập nhật</th>
		</tr>
		<c:forEach items="${productList}" var="productList" varStatus="loop">
			<tr>
				<td scope="col">${productList.idSP}</td>
				<td scope="col">${productList.tenSP}</td>
				<td scope="col">${productList.tenLoai}</td>
				<td scope="col">${productList.tenHang}</td>
				<td scope="col">${productList.soLuong}</td>
				<td scope="col">${productList.soLuongCon}</td>
				<td scope="col">${productList.namSX}</td>
				<td scope="col">${productList.mauSac}</td>
				<td scope="col"><img src="images/${productList.anh}" width="200px;" height="200px;"> </td>
				<td scope="col"><a href="updateProduct?productID=${productList.idSP}"><img src="images/edit.jpg" width="20px;" height="20px;"></a></td>
				<td scope="col"><a href="deleteProduct?productID=${productList.idSP}"><img src="images/delete.png" width="20px;" height="20px;"></a></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>