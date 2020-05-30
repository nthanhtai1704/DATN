<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Error</title>
</head>
<body style="background-image: url('https://www.google.com/search?q=%E1%BA%A3nh+s%C3%A1ch+%C4%91%E1%BA%B9p&tbm=isch&source=iu&ictx=1&fir=pNlGsmGGnNEePM%253A%252CUJAeULRHaQySiM%252C_&vet=1&usg=AI4_-kQcmFZ_4Gzoc_S82wpV2ndpF8FUgg&sa=X&ved=2ahUKEwiPnb3lsNnjAhXPeisKHWs2ADwQ9QEwAHoECAcQAw#imgrc=pNlGsmGGnNEePM:&vet=1');">
	<!--menu-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home"
			style="color: red">Books Management</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link"
					href="${pageContext.request.contextPath}/bookList">Book List <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/userList">User List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/createBook">Create
						book</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/logout">Logout</a>
				</li>
			</ul>

			<form class="form-inline my-2 my-lg-0"
				action="${pageContext.request.contextPath}/searchBook" method="get">
				<table>
					<tr>
						<td><input class="form-control mr-sm-2" type="text"
							name="search"></td>
						<td><input class="btn btn-outline-success my-2 my-sm-0"
							type="submit" value="Search"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	</nav>
	<!--end menu-->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>