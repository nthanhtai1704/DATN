<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListUser</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<h2 style="text-align: center; Color : black;">Users List</h2>
	<table class="table table-dark">
		<thead>
		<tr><th	scope="col">Id</th>
			<th scope="col">Họ tên</th>
			<th scope="col">CMND</th>
			<th scope="col">Ngày sinh</th>
			<th scope="col">Địa chỉ</th>
			<th	scope="col">Số điện thoại</th>
			<th	scope="col">Tên đăng nhập</th>
			<th	scope="col">Mật khẩu</th>
			<th	scope="col">Chức vụ</th>
			<th	scope="col">Action</th> 
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listusers}" var="users">
		<tr>
			<td scope="row">${users.idUser}</td>
			<td>${users.nameuser}</td>
			<td>${users.idCard}</td>
			<td>${users.datebirth}</td>
			<td>${users.address}</td>
			<td>${users.phonenumber}</td>
			<td>${users.username}</td>
			<td>${users.passwords}</td>
			<td>${users.roles}</td>
			<td><a href="deleteUsers?idUser=${users.idUser}">Delete</a><br>
			<a href="updateUsers?idUser=${users.idUser}">update</a><br>
				</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/homeadmin">Cancel</a>
</body>
</html>