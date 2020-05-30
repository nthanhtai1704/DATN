<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	href="style/Style.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Book Management</title>
</head>
<body>
	<!--menu-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
					href="${pageContext.request.contextPath}/booklistUser">Book List</a></li>
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
							type="submit" value="Seach"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	</nav>
	<!--end menu-->
	
	<!--slide-->
	<div class=”row banner”>
		<div id="carouselExampleControls" class="carousel slide mt-2"
			data-ride="carousel" style="width: 100%;">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" style="width: 80%; height: 900px;"
						src="images/1.jpg" alt="Fist slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width: 90%; height: 1000px;"
						src="images/2.jpg" alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width: 90%; height: 1000px;"
						src="images/3.jpg" alt="Third slide">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
		<!-- end slide -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>