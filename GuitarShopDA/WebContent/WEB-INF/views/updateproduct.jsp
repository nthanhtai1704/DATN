<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật sản phẩm</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/updateProduct" method="POST" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td><input type="hidden" value="${sp.idSP}" name="idSP" required> </td>
			</tr>
			<tr>
				<td width="100px;">Tên SP</td>
				<td><input type="text" value="${sp.tenSP}" name="tenSP" required> </td>
			</tr>
			<tr>
			<tr>
				<td>Hãng SX</td>
				<td>
					<select name="idHSX">
						<option value="1">Thuận Phát</option>
						<option value="2">Thành Danh</option>
					</select>
				</td>
			</tr><tr>
				<td>Loại</td>
				<td>
					<select name="idLoai">
						<option value="1">Clasic</option>
						<option value="2">Acoustic</option>
					</select>
				</td>
			</tr>
				<td>Số lượng</td>
				<td><input type="number" value="${sp.soLuong}" name="soLuong" required> </td>
			</tr>
			<tr>
				<td>Số lượng còn</td>
				<td><input type="number" value="${sp.soLuongCon}" name="soLuongCon" required> </td>
			</tr>
			<tr>
				<td>Năm sản xuất</td>
				<td><input type="number" value="${sp.namSX}" name="namSX" required> </td>
			</tr>
			<tr>
				<td>Màu sắc</td>
				<td><input type="text" value="${sp.mauSac}" name="mauSac" required> </td>
			</tr>
			<tr>
				<td>Ảnh</td>
				<td><img src="images/${sp.anh}" width="40px;" height="40px;"><input type="file" value="${sp.anh}" name="anh" required> </td>
			</tr>
			<tr>
				<td>Giá</td>
				<td><input type="number" value="${sp.gia}" name="gia" required> </td>
			</tr>
			<tr>
				<td>Mô tả</td>
				<td><input type="text" value="${sp.moTa}" name="moTa" required> </td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"> </td>
				<td><a href ="${pageContext.request.contextPath}/productList">Cancel </a></td>
			</tr>
		</table>
</body>
</html>