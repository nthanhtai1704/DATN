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
<style type="text/css">
		.banner{
	   width: 100%;
	   height: 450px;
	   overflow: hidden; 
	   padding-left: 15px;
	   box-sizing: border-box;
	}
	
	// Bootstrap 4 variables
	$body-color: #333;
	$gray-300: #dee2e6;
	$font-size-base: 1rem;
	$font-size-sm: ($font-size-base * 0.875);
	$border-radius: 0.25rem;
	$spacer: 1rem; // 16px
	/*
	4px:  $spacer * 0.25
	8px:  $spacer * 0.5
	16px: $spacer
	20px: $spacer * 1.25
	24px: $spacer * 1.5
	*/
	
	// custom variables
	$sidebar-breakpoint: 768px;
	$sidebar-base-width: 280px;
	$header-md-height: 4.5rem;
	$sidebar-spacer-y: $spacer * 0.5;
	$font-size-xs: ($font-size-base * 0.75);
	$font-weight-semibold: 500;
	$default-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12),
		0 1px 2px rgba(0, 0, 0, 0.24);
	
	html,
	body {
		font-family: "Roboto", "Helvetica Neue", Helvetica, Arial, sans-serif;
		color: $body-color;
		background-color: #eeeded;
		height: 100%; // required for sticky sidebar
	}
	
	.sidebar-toggler {
		padding: 0.25rem 0.75rem;
		font-size: 1.25rem;
		line-height: 1;
		background-color: transparent;
		border: 1px solid transparent;
		border-radius: 0.25rem;
		color: rgba(0, 0, 0, 0.5);
		border-color: rgba(0, 0, 0, 0.1);
		.sidebar-toggler-icon {
			display: inline-block;
			width: 1.5em;
			height: 1.5em;
			vertical-align: middle;
			content: "";
			background: no-repeat center center;
			background-size: 100% 100%;
			background-image: url("data:image/svg+xml;charset=utf8,<svg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'><path stroke='rgba(0, 0, 0, 0.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/></svg>");
			cursor: pointer;
		}
	}
	
	.sidebar {
		position: relative;
		width: 100%;
		z-index: 99;
		.sidebar-user .category-content {
			padding: $spacer;
			text-align: center;
			color: #fff;
			background: url(https://picsum.photos/260/80?image=652&blur) center center
				no-repeat;
			background-repeat: no-repeat;
			background-position: center center;
			background-size: cover;
			&:first-child {
				border-bottom-right-radius: $border-radius;
				border-bottom-left-radius: $border-radius;
			}
			&:last-child {
				border-top-right-radius: $border-radius;
				border-top-left-radius: $border-radius;
			}
		}
		.sidebar-content {
			position: relative;
			border-radius: $border-radius;
			margin-bottom: $spacer * 1.25;
		}
		.category-title {
			position: relative;
			margin: 0;
			padding: 12px 20px;
			padding-right: 46px;
			border-bottom: 1px solid rgba(255, 255, 255, 0.1);
		}
		&.sidebar-default {
			.category-title {
				border-bottom-color: $gray-300;
				> span {
					display: block;
					text-transform: uppercase;
					font-weight: $font-weight-semibold;
					font-size: $font-size-xs;
				}
			}
			.category-content .nav li > a {
				color: $body-color;
				&.active,
				&[aria-expanded="true"],
				&:hover,
				&:focus {
					background-color: #f4f4f4;
				}
			}
		}
		.category-content {
			position: relative;
			.nav {
				position: relative;
				margin: 0;
				padding: $sidebar-spacer-y 0;
				li {
					position: relative;
					list-style: none;
					> a {
						font-size: $font-size-sm;
						border-bottom: 1px solid rgba(255, 255, 255, 0.5);
						transition: background 0.15s linear, color 0.15s linear;
						&[data-toggle="collapse"] {
							padding-right: $spacer * 2;
							&:after {
								position: absolute;
								top: $sidebar-spacer-y;
								right: $spacer;
								height: $font-size-base * 1.5;
								line-height: $font-size-base * 1.5;
								display: block;
								content: "\f105";
								font-family: FontAwesome;
								font-size: $font-size-base * 1.5;
								font-weight: normal;
								transform: rotate(0deg);
								transition: -webkit-transform 0.2s ease-in-out;
							}
							&[aria-expanded="true"]:after {
								transform: rotate(90deg);
							}
						}
						> i {
							float: left;
							top: 0;
							margin-top: 2px;
							margin-right: 15px;
							transition: opacity 0.2s ease-in-out;
						}
					}
					ul {
						padding: 0;
						> li a {
							padding-left: $spacer * 2.75;
						}
					}
				}
				> li > a {
					font-weight: $font-weight-semibold;
				}
			}
		}
	}
	@media (min-width: $sidebar-breakpoint) {
		.sidebar {
			&.sidebar-fixed {
				position: sticky;
				top: $header-md-height + $spacer;
			}
			padding-top: $spacer * 2 !important;
			display: table-cell;
			vertical-align: top;
			width: $sidebar-base-width;
			padding: 0 $spacer * 1.25;
	
			&.sidebar-default .sidebar-category {
				background-color: #fff;
			}
	
			&.sidebar-separate {
				.sidebar-content {
					box-shadow: none;
				}
				.sidebar-category {
					margin-bottom: $spacer * 1.25;
					border-radius: $border-radius;
					box-shadow: $default-box-shadow;
				}
			}
		}
		.content-wrapper {
			display: table-cell;
		}
	}
</style>
<title>Book List</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/bookList">Book List <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
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
<!-- <!-- slide bar -->
	<!-- end slide bar -->
	<h1 style="color: red ; text-align: center;">Book List</h1>
	<table border="1" align="center" width="60%">
		<tr>
			<th>ID</th>		
			<th>Name</th>		
			<th>Author</th>		
			<th>Publisher</th>		
			<th>Price</th>		
			<th>Update</th>		
			<th>Delete</th>		
		</tr>
          
		<c:forEach items="${bookList}" var ="book">
		<tr>
			<td>${book.id}</td>
			<td>${book.name}</td>
			<td>${book.author}</td>
			<td>${book.publisher}</td>
			<td>${book.price}</td>
			<td><a href="updateBook?id=${book.id}">Update</a></td>
			<td><a href="delete?id=${book.id}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>