<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
form {
  width: 300px;
  margin: 0 auto;
  text-align: center;
  padding-top: 50px;
}

.value-button {
  display: inline-block;
  border: 1px solid #ddd;
  margin: 0px;
  width: 40px;
  height: 20px;
  text-align: center;
  vertical-align: middle;
  padding: 11px 0;
  background: #eee;
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.value-button:hover {
  cursor: pointer;
}

form #decrease {
  margin-right: -4px;
  border-radius: 8px 0 0 8px;
  width: 60px;
  height: 40px;
  text-align: center;
}

form #increase {
  margin-left: -4px;
  border-radius: 0 8px 8px 0;
  height: 40px;
  width: 60px;
  text-align: center;
}

form #input-wrap {
  margin: 0px;
  padding: 0px;
  height: 40px;
}

input#number {
  text-align: center;
  border: none;
  border-top: 0.5px solid #ddd;
  border-bottom: 0.5px solid #ddd;
  margin: 0px;
  width: 40px;
  height: 40px;
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
<script type="text/javascript">
function myFunction() {
var x = document.getElementById("sl").value;
var gia = document.getElementById("gia").value;
var kq = 0;
var tt = 0;
var checkbox = document.getElementById("checkbox");
if(checkbox.checked == true){
  kq = parseInt(x) * parseInt(gia);
document.getElementById("demo").innerHTML = kq;
document.getElementById("tt").innerHTML = kq + 17000;
}else{
	document.getElementById("demo").innerHTML = 0;
	document.getElementById("tt").innerHTML = 0;
}
}
</script>
 
<!-- <script type="text/javascript">
function increaseValue() {
	  var value = parseInt(document.getElementById('number').value, 5);
	  value = isNaN(value) ? 0 : value;
	  value++;
	  if(value >=5){ alert('Số lượng đặt không lớn hơn 5')};
	  document.getElementById('number').value = value;
	}

	function decreaseValue() {
	  var value = parseInt(document.getElementById('number').value, 1);
	  value = isNaN(value) ? 1 : value;
	  value < 1 ? value = 1 : '';
	  value--;
	  if(value <1){ alert('Số lượng k bé hơn 0')};
	  document.getElementById('number').value = value;
	}
</script> -->
<title>Guitar Shop</title>
</head>
<body>
	<jsp:include page="headeruser.jsp"></jsp:include>
	<form action=""></form>
		<table border="0px" width="70%" style="margin-left: 50px;">
		<tr>
			<th scope="col"> </th>
			<th scope="col">Tên sản phẩm</th>
			<th scope="col">Ảnh</th>
			<th scope="col">Giá</th>
			<th scope="col">Số lượng</th>
			
			<th  scope="col"></th>
		</tr>
		<c:forEach items="${listGH}" var="listGH">
		<tr onchange="myFunction()">
				<td scope="col"><input type="radio" name="click" id="checkbox"></td>
				<td scope="col">${listGH.tenSP}</td>
				<td scope="col"><img src="images/${listGH.anh}" width="200px;" height="200px;"> </td>
				<%-- <td scope="col" id ="gia">${listGH.gia}</td> --%>
				<td scope="col"><input type ="number" value="${listGH.gia}" id ="gia" disabled style="border: solid white; background-color: white;"></td>
				<td scope="col">${listGH.soLuong}
				 <select name="soLuong" id="sl" >
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
<%-- <div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
  <input type="number" id="number" value="${listGH.soLuong}" name="soLuong" />
  <div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div> --%>
						</td>
						
				<%-- <td width="15%;"><p id="demo">${listGH.gia * listGH.soLuong}</p></td> --%>
				<td scope="col"><a href="deleteCart?idGH=${listGH.idGH}"><img src="images/delete.png" width="20px;" height="20px;"></a></td>
				<td scope="col"><a href="${pageContext.request.contextPath}/orderProduct?idSP=${listGH.idSP}"><img src="images/buy.png" width="20px;" height="20px;"></a></td>
			</tr>
		</c:forEach>
		<div class="rsingle span_1_of_single" style="float: right; margin-right: 40px; background-color: #f0f5f5; height: 280px; width: 280px;" >
					<h7 class="m_1"> <img src="images/diachi.png" width="20px;" height="20px;" > Địa điểm:<small> ${tv.diaChi}</small></h7>
					</hr>
					<div class="area_promotion zero">
						<p style="text-align: center;">
							<strong> </strong>
						</p>
						</br>
						<h4 style="text-align: center; color: blue;">
							THÔNG TIN ĐƠN HÀNG
						</h4>
						Tạm tính<p style="display:inline-block; float: right; color: red;">vnđ</p><p id="demo" style="display:inline-block; float: right;">0</p></br>
						</br>
						Phí giao hàng<p style="display:inline-block; float: right; color: red;">vnđ</p><p style="display:inline-block; float: right;">17000</p></br>
						</br>
						Tổng tiền<p style="display:inline-block; float: right; color: red;">vnđ</p><p id="tt" style="display:inline-block; float: right;">0</p></br>
						<%-- </br></br></br></br><input style="width: 280px;" class="btn btn-success" type="submit" value="XÁC NHẬN GIỎ HÀNG ">
						<a href="deleteCart?idGH=${listGH.idSP}">delete</a> --%>
					</div>
					
					<script src="js/jquery.easydropdown.js"></script>

				</div>
	</table>
	
	</br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>