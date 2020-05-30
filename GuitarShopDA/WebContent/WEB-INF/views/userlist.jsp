<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thành viên</title>
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
	<h2 style="text-align: center; color: blue;">Thành viên</h2>

	<table border="1" cellpadding="8" cellspacing="1" width="100%" class="table table-striped">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Tên</th>
			<th scope="col">Sdt</th>
			<th scope="col">CMND</th>
			<th scope="col">Email</th>
			<th scope="col">Ngày sinh</th>
			<th scope="col">Địa chỉ</th>
			<th scope="col">Tên ĐN</th>
			<th scope="col">Mật khẩu</th>
			<th scope="col">Quyền</th>
			<th scope="col" colspan="2">Cập nhật</th>
		</tr>
		<c:forEach items="${listUser}" var="listUser" varStatus="loop">
			<tr>
				<td scope="col">${listUser.idTV}</td>
				<td scope="col">${listUser.hoTen}</td>
				<td scope="col">${listUser.sdt}</td>
				<td scope="col">${listUser.cmnd}</td>
				<td scope="col">${listUser.email}</td>
				<td scope="col">${listUser.ngaySinh}</td>
				<td scope="col">${listUser.diaChi}</td>
				<td scope="col">${listUser.tenDN}</td>
				<td scope="col">${listUser.matKhau}</td>
				<td scope="col">${listUser.quyen}</td>
				<td scope="col"><a href="updateUser?userID=${listUser.idTV}"><img src="images/edit.jpg" width="20px;" height="20px;"></a></td>
				<td scope="col"><a href="deleteUser?userID=${listUser.idTV}"><img src="images/delete.png" width="20px;" height="20px;"></a></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>