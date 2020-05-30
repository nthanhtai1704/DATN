<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<form action="" method="POST" enctype=”multipart/form-data”>
		<table border="0" align="center">
			<tr>
				<td><input type="hidden" value="${users.userID}" name="id" required> </td>
			</tr>
			<tr>
				<td width="100px;">User name</td>
				<td><input type="text" value="${users.userName}" name="username" required> </td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" value="${users.password}" name="password" required> </td>
			</tr>
			<tr>
				<td>Full name</td>
				<td><input type="text" value="${users.fullName}" name="fullname" required> </td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><input type="number" value="${users.tel}" name="tel" required> </td>
			</tr>
			<tr>
				<td>Id Card</td>
				<td><input type="number" value="${users.idCard}" name="idcard" required> </td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" value="${users.email}" name="email" required> </td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" value="${users.address}" name="address" required> </td>
			</tr>
			<tr>
				<td>Role</td>
				<td>
					<select name="role">
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