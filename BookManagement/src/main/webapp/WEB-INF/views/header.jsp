<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div style="background-color: #d0d0d0; heigh:100px;"> 
		<h1>Book Management</h1>
		
		<a href="${pageContext.request.contextPath}/home">Home</a>
		
		<a href="${pageContext.request.contextPath}/book/getall">Book List</a>
		
		<a href="${pageContext.request.contextPath}/book/create">Create Book</a>
		
		<a href="${pageContext.request.contextPath}/logout">Logout</a>
		<form action="${pageContext.request.contextPath}/book/searchBook" method="GET">
		<table>
			<tr>
				<td><input type="text" name="name"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
</html>