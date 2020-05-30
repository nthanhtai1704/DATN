<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<h2 style="text-align: center; color: blue;">SỬA HÃNG SẢN XUẤT</h2>
	<form action="updateHSX" method="post">
		<table border="0" cellpadding="8" cellspacing="1" width="50%">
			<tr>
				<td scope="col"><input type="hidden" name="idHSX" value="${hsx.idHSX}"></td>
			</tr>
			<tr>
				<th scope="col">Tên hãng sản xuất</th>
				<td scope="col"><input type="text" name="tenHSX" value="${hsx.tenHSX}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Sửa"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>