<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuitarShop</title>
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
<form action="${pageContext.request.contextPath}/updateOrder" method="POST" enctype=”multipart/form-data”>
		<table border="0" align="center">
			<tr>
				<td><input type="hidden" value="${dh.idDH}" name="idDH" required> </td>
			</tr>
			<tr>
				<td width="150px;">Tình trạng</td>
				<td style="color: red;">${dh.tinhTrang} </td>
			</tr>
			<tr>
				<td>Cập nhật tình trạng</td>
				<td>
					<select name="tinhTrang">
						<option value="Đang giao hàng">Đang giao hàng </option>
						<option value="Đã giao hàng">Đã giao hàng</option>
					</select>
				</td>
				<!-- <td><input type="radio" value="Đang giao hàng">Đang giao hàng</td>
				<td><input type="radio" value="Đã giao hàng">Đã giao hàng</td> -->
			</tr>
			<tr>
				<td><input type="submit" value="Cập nhật"> </td>
				<td><a href ="${pageContext.request.contextPath}/orderList">Hủy</a></td>
			</tr>
		</table>
	</form>
</body>
</html>