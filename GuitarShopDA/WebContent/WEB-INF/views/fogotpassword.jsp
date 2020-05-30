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
<form action="emailSending" method="post" style="margin-left: 300px;">
		<h1>Quên mật khẩu?</h1></br>
		<h6 style="color: red;">Vui lòng nhập tài khoản bạn muốn lấy lại mật khẩu.</h6>
        <table border="0" width="50%">
            <tr>
				<th scope="col">Nhập email:</th>
				<td scope="col"> <input type="text" name="recipient"><input type="submit" value="Gửi"></td>
			</tr>
			
        </table>
    </form>
</body>
</html>