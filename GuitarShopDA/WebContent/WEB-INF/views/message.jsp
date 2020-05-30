<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuitarShop</title>
</head>
<jsp:include page="headeruser.jsp"></jsp:include>
<jsp:include page="banner_right.jsp"></jsp:include>
<body>

<div class="container">
<p style="color: #1aa3ff;"><%= request.getAttribute("thongbao") != null ? request.getAttribute("thongbao") : " " %></p>
</div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>