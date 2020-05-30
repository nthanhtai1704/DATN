<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="headeruser.jsp"></jsp:include>
	
	<table border="0px" width="60%" style=" margin-left: 200px; " id="sidebarA">
		<tr style="color: red;" >
			<th>#</th>
			<th>Id thành viên</th>
			<th>Họ tên</th>
			<th>Xe</th>
			<th>Giá</th>
			<th>Ngày thuê</th>
			<th>Ngày trả</th>
			<th>Số ngày</th>
			<th>Thành tiền</th>
			<th>Trạng thái</th>
		</tr>
		<c:forEach items="${listHistory}" var ="history">
		<tr>
			<td>${history.idContract}</td>
			<td>${history.idUser}</td>
			<td>${history.fullName}</td>
			<td>${history.productName}</td>
			<td>${history.price}</td>
			<td>${history.hireDay}</td>
			<td>${history.payDay}</td>
			<td>${history.numberDay}</td>
			<td>${history.total}</td>
			<td>${history.status}</td>
			
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>