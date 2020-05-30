<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 style="text-align: center; color: blue;">BOOK LIST</h2>

	<table border="1" cellpadding="8" cellspacing="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Price</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${bookList}" var="book" varStatus="loop">
			<tr>
				<td>${loop.index}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.publisher}</td>
				<td>${book.price}</td>
				<td><a href="updateBook?id=${book.id}">Update</a></td>
				<td><a href="deleteBook?id=${book.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>