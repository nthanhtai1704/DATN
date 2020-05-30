<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<h2 style="text-align: center; color: blue;">DANH SÁCH SẢN PHẨM</h2>
	<form action="${pageContext.request.contextPath}/searchByStatus" method="get">
		<select name="status">
			<option value="Đang xử lý">Đang xử lý</option>
			<option value="Đang giao hàng">Đang giao hàng</option>
			<option value="Đã giao hàng">Đã giao hàng</option>
		</select>
		<input type="submit" class="btn btn-primary" value="Tìm kiếm">
	</form>
	<table  border="1" cellpadding="8" cellspacing="1" width="100%">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Tên sản phẩm</th>
			<th scope="col">Ảnh</th>
			<th scope="col">Giá</th>
			<th scope="col">Tên khách hàng</th>
			<th scope="col">Số lượng</th>
			<th scope="col">Ngày mua</th>
			<th scope="col">Tổng tiền</th>
			<th scope="col">Địa chỉ</th>
			<th scope="col">Tình trạng</th>
			<th  scope="col" colspan="2">Cập nhật</th>
		</tr>
		<c:forEach items="${orderList}" var="orderList" varStatus="loop">
			<tr>
				<td scope="col">${orderList.idDH}</td>
				<td scope="col">${orderList.tenSP}</td>
				<td scope="col"><img src="images/${orderList.anh}" width="200px;" height="200px;"> </td>
				<td scope="col">${orderList.gia}</td>
				<td scope="col">${orderList.hoTen}</td>
				<td scope="col">${orderList.soLuong}</td>
				<td scope="col">${orderList.ngayMua}</td>
				<td scope="col">${orderList.tongTien}</td>
				<td scope="col">${orderList.diaCHi}</td>
				<td scope="col">${orderList.tinhTrang}</td>
				<td scope="col"><a href="updateOrder?orderID=${orderList.idDH}"><img src="images/edit.jpg" width="20px;" height="20px;"></a></td>
				<td scope="col"><a href="deleteOrder?orderID=${orderList.idDH}"><img src="images/delete.png" width="20px;" height="20px;"></a></td>
				
			</tr>
		</c:forEach>
		</table>
</body>
</html>