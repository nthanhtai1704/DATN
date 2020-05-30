<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<h3 style="text-align: center; color: blue;">THÊM SẢN PHẨM</h3>
	<form action="${pageContext.request.contextPath}/createproduct" method="post" enctype="multipart/form-data">
	
		<table border="0" cellpadding="8" cellspacing="1" width="50%">
			<tr>
				<th scope="col">Tên sản phẩm</th>
				<td scope="col"> <input type="text" name="tenSp"></td>
			</tr>
			<tr>
				<th scope="col">Loại sản phẩm</th>
				<td scope="col">  <select name="idLoai">
					<option value="1">Classic</option>
					<option value="2">Acoustic</option>
				</select></td>
			</tr>
			<tr>
				<th scope="col">Hãng sx</th>
				<td scope="col"><select name="idHSX">
					<option value="1">Thuận Phát</option>
					<option value="2">Thành Danh</option>
				</select></td>
			</tr>
			<tr>
				<th scope="col">Số lượng</th>
				<td scope="col">  <input type="number" name="soLuong"></td>
			</tr>
			<tr>
				<th scope="col">Số lượng còn</th>
				<td scope="col"><input type="number" name="soLuongCon"></td>
			</tr>
			<tr>
				<th scope="col">Năm sản xuất</th>
				<td scope="col"><input type="number" name="namSX"></td>
			</tr>
			<tr>
				<th scope="col">Màu sắc</th>
				<td scope="col"><input type="text" name="mauSac"></td>
			</tr>
			<tr>
				<th scope="col">Ảnh</th>
				<td scope="col"><input type="file" name="anh"></td>
			</tr>
			<tr>
				<th scope="col">Giá</th>
				<td scope="col"><input type="number" name="gia"></td>
			</tr>
			<tr>
				<th scope="col">Mô tả</th>
				<td scope="col"><input type="text" name="moTa"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Thêm"></td>
			</tr>
			
		</table>

	</form>
</body>
</html>