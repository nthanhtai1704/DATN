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
	
	<table border="0px" width="60%" style=" margin-left: 200px; " id="sidebarA">
		<tr style="color: red;" >
			<th>History ID</th>
			<th>User ID</th>
			<th>Full name</th>
			<th>Product ID</th>
			<th>Product name</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${listHistory}" var ="history">
		<tr style="text-align: center">
			<td>${history.historyID}</td>
			<td>${history.userID}</td>
			<td>${history.fullName}</td>
			<td>${history.productID}</td>
			<td>${history.productName}</td>
			<td>${history.quantity}</td>
			<td>${history.price}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>