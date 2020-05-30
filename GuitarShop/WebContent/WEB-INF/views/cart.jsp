<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
</head>
 <jsp:include page="header.jsp"/> 
<body>
	<table border="0px" width="50%" style=" margin-left: 200px;">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
			<th>Buy Now</th>
		</tr>
		<c:forEach items="${order.items}" var ="item">
		<tr style="text-align: center">
			<td><img src="images/3.jpg" width="300px" height="200px"></td>
			<td>${item.product.productName}</td>
			<td>${item.product.price}</td>
			<td>${item.quantity}</td>
			<td>${item.quantity * item.product.price}</td>
			<%-- <td><a href="removeProduct?productID=${item.product.productID}">Delete</a></td> --%>
			<td><a href="history?productID=${item.product.productID}">Buy Now</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>