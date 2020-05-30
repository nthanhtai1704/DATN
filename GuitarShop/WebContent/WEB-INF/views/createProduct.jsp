<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<h1>Create Product</h1>
	<form action="" method="POST" enctype="multipart/form-data" style="margin-left: 300px;">
		<table border="0">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" size="40"></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="file" name="image" size="40"></td>
			</tr>
			<tr>
				<td>Type</td>
				<td>
					<select name="type" style="width: 173px;" >
						<option value="Classic">Classic</option>					
						<option value="Acoustic">Acoustic</option>					
					</select>
				</td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="number" name="amount" size="40"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="price" size="40"></td>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="Insert">
					<a href="${pageContext.request.contextPath}/home">Cancel</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>