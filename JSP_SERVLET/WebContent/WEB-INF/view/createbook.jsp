<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Create Book</title>
</head>
<body>
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
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/bookList">Book List <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/userList">User List</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/createBook">Create
						book</a></li>
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
	<h1 style="color: red; text-align: center">Insert Book</h1>
	<form action="${pageContext.request.contextPath}/createBook" method="POST">
		<table border="0" align="center" style="font-size: 20px;">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>Publisher</td>
				<td><input type="text" name="publisher"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="Insert">
					<a href="${pageContext.request.contextPath}/home">Cancel</a>
				</td>
			</tr>
		</table>
	</form>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>