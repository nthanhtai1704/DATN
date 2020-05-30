<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Cập nhật thành viên</title>
</head>
<body>
<jsp:include page="headeruser.jsp"></jsp:include>
<jsp:include page="banner_right.jsp"></jsp:include>
<form action="${pageContext.request.contextPath}/updateProfile" method="POST" enctype=”multipart/form-data”>
		<table border="0" align="center" style="margin-left: 30%;margin-top: 50px;">
			<tr>
				<td><input type="hidden" value="${profile.idTV}" name="id" required> </td>
			</tr>
			
			<tr>
				<td width="100px;" >Họ  tên</td>
				<td ><input type="text" value="${profile.hoTen}" name="hoTen" required> </td>
			</tr>
			<tr>
				<td >Số điện thoại</td>
				<td><input type="number" value="${profile.sdt}" name="sdt" required> </td>
			</tr>
			<tr>
				<td  width="200px;">Chứng minh nhân dân</td>
				<td scope="col"><input type="number" value="${profile.cmnd}" name="cmnd" required> </td>
			</tr>
			<tr>
				<td >Email</td>
				<td ><input type="email" value="${profile.email}" name="email" required> </td>
			</tr>
			<tr>
				<td >Ngày sinh</td>
				<td ><input type="text" value="${profile.ngaySinh}" name="ngaySinh" required> </td>
			</tr>
			<tr>
				<td>Địa chỉ</td>
				<td ><input type="text" value="${profile.diaChi}" name="diaChi" required> </td>
			</tr>
			<tr>
				<td>Tên đăng nhập</td>
				<td > <input type="text" value="${profile.tenDN}" name="tenDN" required> </td>
			</tr>
			<tr>
				<td >Mật khẩu</td>
				<td ><input type="password" value="${profile.matKhau}" name="matKhau" required> </td>
			</tr>
			<tr>
				<td><input type="submit" value="Cập nhật"> </td>
				<td><a href ="${pageContext.request.contextPath}/homeuser">Cancel </a></td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>