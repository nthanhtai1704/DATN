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
	<h2 style="text-align: center; color: blue;">Loại sản phẩm</h2>

	<table border="1" cellpadding="8" cellspacing="1" width="100%" class="table table-striped">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Tên</th>
			<th scope="col" colspan="2">Cập nhật</th>
		</tr>
		<c:forEach items="${listspecies}" var="listspecies" varStatus="loop">
			<tr>
				<td scope="col">${listspecies.idLoai}</td>
				<td scope="col">${listspecies.tenLoai}</td>
				<td scope="col"><a href="updateUser?userID=${listUser.idLoai}">Update</a></td>
				<td scope="col"><a href="deleteUser?userID=${listUser.idLoai}">Delete</a></td>
				
			</tr>
		</c:forEach>
		</table>
</body>
</html>