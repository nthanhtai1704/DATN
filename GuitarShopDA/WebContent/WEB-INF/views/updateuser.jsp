<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thành viên</title>
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
<form action="${pageContext.request.contextPath}/updateUser" method="POST" enctype=”multipart/form-data”>
		<table border="0" align="center">
			<tr>
				<td><input type="hidden" value="${tv.idTV}" name="id" required> </td>
			</tr>
			<tr>
				<td width="100px;">Họ  tên</td>
				<td><input type="text" value="${tv.hoTen}" name="hoTen" required> </td>
			</tr>
			<tr>
				<td>Số điện thoại</td>
				<td><input type="number" value="${tv.sdt}" name="sdt" required> </td>
			</tr>
			<tr>
				<td>CMND</td>
				<td><input type="number" value="${tv.cmnd}" name="cmnd" required> </td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" value="${tv.email}" name="email" required> </td>
			</tr>
			<tr>
				<td>Ngày sinh</td>
				<td><input type="text" value="${tv.ngaySinh}" name="ngaySinh" required> </td>
			</tr>
			<tr>
				<td>Địa chỉ</td>
				<td><input type="text" value="${tv.diaChi}" name="diaChi" required> </td>
			</tr>
			<tr>
				<td>Tên đăng nhập</td>
				<td><input type="text" value="${tv.tenDN}" name="tenDN" required> </td>
			</tr>
			<tr>
				<td>Mật khẩu</td>
				<td><input type="password" value="${tv.matKhau}" name="matKhau" required> </td>
			</tr>
			<tr>
				<td>Quyền truy cập</td>
				<td>
					<select name="quyen">
						<option value="user">user</option>
						<option value="admin">admin</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"> </td>
				<td><a href ="${pageContext.request.contextPath}/userList">Cancel </a></td>
			</tr>
		</table>
	</form>
</body>
</html>