<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<table border="0px" width="8x0%" >
		<tr style="text-align: center">
			<th></th>
			<th>Name</th>
			<th>Type</th>
			<th>Amount</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${productList}" var ="product">
		<tr style="text-align: center">
			<td><img src="data:image/jpeg;base64,${product.productImg}" width="400px" height="300px"></td>
			<td>${product.productName}</td>
			<td>${product.productType}</td>
			<td>${product.amount}</td>
			<td>${product.price}</td>
			
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>