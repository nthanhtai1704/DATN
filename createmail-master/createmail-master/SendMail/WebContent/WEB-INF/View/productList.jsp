<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>	
	
	<table border="0px" width="90%" >
		<tr style="text-align: center">
			<th></th>
			<th>Name</th>
			<th>Type</th>
			<th>Amount</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>
			<th>Add to Cart</th>
		</tr>
		<c:forEach items="${sanpham}" var ="sapham">
		<tr style="text-align: center">
			<td><img src="data:image/jpeg;base64,${sapham.avatar}" width="400px" height="300px"></td>
			<td>${sapham.name}</td>
			<td>${sapham.species}</td>
			<td>${sapham.quantity}</td>			
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>