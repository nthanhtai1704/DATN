<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Product</h1>
	<form action="" method="POST" enctype="multipart/form-data" style="margin-left: 300px;">
		<table border="0">		
			<tr>
				<td>Image</td>
				<td><input type="file" name="image" size="40"></td>
			</tr>
				<tr>
				<td>Name</td>
				<td><input type="text" name="name" size="40"></td>
			</tr>	
			<tr>
				<td>species</td>
				<td><input type="text" name="species" size="40"></td>
			</tr>
			<tr>
				<td>quantity</td>
				<td><input type="number" name="quantity" size="40"></td>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="Insert">
					<a href="${pageContext.request.contextPath}/ControllerForward">Cancel</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>