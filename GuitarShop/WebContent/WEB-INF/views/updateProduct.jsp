<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<form action="" method="POST" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td><input type="hidden" value="${product.productID}" name="id" > </td>
			</tr>
			<tr>
				<td width="100px;">Image</td>
				<td><input type="file" value="${product.productImg}" name="image" required> </td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" value="${product.productName}" name="name" required> </td>
			</tr>
			<tr>
				<td>Type</td>
				<td>
					<select name="type" style="width: 173px;" required >
						<option value="Classic">Classic</option>					
						<option value="Acoustic">Acoustic</option>					
					</select>
				</td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="number" value="${product.amount}" name="amount" required> </td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" value="${product.price}" name="price" required> </td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"> </td>
				<td><a href ="${pageContext.request.contextPath}/productList">Cancel </a></td>
			</tr>
		</table>
	</form>
</body>
</html>