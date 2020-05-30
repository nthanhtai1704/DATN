<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
</head>
<body>
	<h1>User List</h1>
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Full name</th>
			<th>Telephone</th>
			<th>Id Card</th>
			<th>Email</th>
			<th>Address</th>
			<th>Role</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${userList}" var ="users">
		<tr>
			<td>${users.userID}</td>
			<td>${users.userName}</td>
			<td>${users.password}</td>
			<td>${users.fullName}</td>
			<td>${users.tel}</td>
			<td>${users.idCard}</td>
			<td>${users.email}</td>
			<td>${users.address}</td>
			<td>${users.role}</td>
			<td><a href="updateUser?userID=${users.userID}">Update</a></td>
			<td><a href="deleteUser?userID=${users.userID}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>