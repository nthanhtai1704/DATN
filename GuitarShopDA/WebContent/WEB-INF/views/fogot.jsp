<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/scripts/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
<title>GuitarShop</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner_right.jsp"></jsp:include>
<div class="container">
<form action="emailSending" method="post">
<h1>Quên mật khẩu?</h1></br>
<h6 style="color: red;">Vui lòng nhập tài khoản bạn muốn lấy lại mật khẩu.</h6></br>
<p style="color: red;"><%= request.getAttribute("thongbao") != null ? request.getAttribute("thongbao") : " " %></p>
        <table border="0" width="50%">
            <tr>
                <td>Nhập email: </td>
                <td><input type="text" name="recipient" size="50"/>
                <input type="submit" value="Gửi" style="background-color: #00bfff"></td>
            </tr>
        </table>
         
    </form>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>