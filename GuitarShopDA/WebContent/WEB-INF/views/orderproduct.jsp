<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function myFunction() {
var x = document.getElementById("sl").value;
 var gia = document.getElementById("gia").value;
  var kq = 0;
  var tt = 0;
  var vnd = "vnđ";
  kq = parseInt(x) * parseInt(gia);
  tt = parseInt(kq) + 17000;
document.getElementById("kq").innerHTML = kq;
document.getElementById("tt").value = tt;
}
</script>
<meta charset="UTF-8">
<title>Guitar Shop</title>
</head>
<body>
	<jsp:include page="headeruser.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/orderProduct" method="post">
		<table border="0px" width="70%" style="margin-left: 50px;">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Tên sản phẩm</th>
			<th scope="col">Ảnh</th>
			<th scope="col">Giá</th>
			<th scope="col">Số lượng</th>
			
			</tr>
		
		<tr>
				<td scope="col"><input type ="text" name="idSP" value="${sp.idSP}" style="border: solid white; background-color: white;"></td>
				<td scope="col">${sp.tenSP}</td>
				<td scope="col"><img src="images/${sp.anh}" width="200px;" height="200px;"> </td>
				<td scope="col"><input type ="number" value="${sp.gia}" id ="gia" disabled style="border: solid white; background-color: white;"></td>
				<td scope="col">
					 <select  name="soLuong" id="sl" onchange="myFunction()">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
				</select>
			</tr>
		<div class="rsingle span_1_of_single" style="float: right; margin-right: 40px;">
					
					<h5 class="m_1" style="text-align: center;">THÔNG TIN KHÁCH HÀNG</h5>
					<div class="area_promotion zero">
						<p style="text-align: center;">
							<strong> </strong>
						</p>
							<p>Họ tên:<strong style="color: blue;"> ${tv.hoTen}</strong></p>
							</br>
							<p>Số điện thoại: <strong style="color: blue;"> ${tv.sdt}</strong></p>
							</br>
							<p>Email: <strong style="color: blue;"> ${tv.email}</strong></p>
							</br>
							<p>Địa chỉ: <strong style="color: blue;">${tv.diaChi}</strong></p>
							</br>
							<h1>THÔNG TIN ĐƠN HÀNG</h1>
							</br>
							Tạm tính<p style="display:inline-block; float: right;">vnđ</p><p id="kq" style="display:inline-block; float: right;">${sp.gia}</p></br>
							Phí giao hàng<p style="display:inline-block; float: right;">17000vnd</p></br>
							Tổng tiền<input type ="text" value="${sp.gia + 17000}" name="tongTien" id ="tt" style="border: solid white; color:red; background-color: white;text-align: right; float: right;">
						</br><input style="width: 280px;" class="btn btn-success" type="submit" value="Đặt hàng"">
					</div>
					<script src="js/jquery.easydropdown.js"></script>

				</div>
	</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>