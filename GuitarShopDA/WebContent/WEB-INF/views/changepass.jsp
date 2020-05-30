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
<form action="changePass" method="post" style="margin-left: 300px;">
		<h1>Đặt lại mật khẩu</h1></br>
		<p style="color: red;"><%= request.getAttribute("thongbao") != null ? request.getAttribute("thongbao") : " " %></p>
        <table border="0" width="50%">
            <tr>
				<th scope="col">Nhập mật khẩu mới:</th>
				<td scope="col"> <input type="password" name="mkm"></td>
			</tr>
			<tr>
				<th scope="col">Nhập lại mật khẩu :</th>
				<td scope="col"> <input type="password" name="mkm1"></td>
			</tr>
			
			<tr>
				<td scope="col"><input type="submit" value="Gửi"></td>
			</tr>
			
        </table>
    </form>
    </div>
</body>
</html>