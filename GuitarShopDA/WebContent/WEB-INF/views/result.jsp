<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuitarShop</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner_right.jsp"></jsp:include>
<div class="container">
<form action="ControllerConfirm"   method="post">
<p style="color: red;"><%= request.getAttribute("thongbao") != null ? request.getAttribute("thongbao") : " " %></p>
<p>Vui lòng kiểm tra mã trong email của bạn. Mã này gồm 6 số.</p>
Nhập mã:<input type="text" name="number" />
<input type="hidden" type="password" name="number" />

<input type="submit" value="Xác nhận"/>
</form>
</div>
</body>
</html>