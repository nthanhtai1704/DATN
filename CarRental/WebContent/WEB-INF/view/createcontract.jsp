<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<LINK REL="SHORTCUT ICON" HREF="images/1.jpg">
<title>Đăng Kí</title>
<link rel="stylesheet" href="css/regist.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/datepicker-vi.js"></script>
<script>
	$(function() {
		var dateFormat = "dd/mm/yy", from = $("#from").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 2
		}).on("change", function() {
			to.datepicker("option", "minDate", getDate(this));
			calTT();
		}), to = $("#to").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 2
		}).on("change", function() {
			from.datepicker("option", "maxDate", getDate(this));
			calTT();
		});
		function getDate(element) {
			var date;
			try {
				date = $.datepicker.parseDate(dateFormat, element.value);
			} catch (error) {
				date = null;
			}
			return date;
		}
		function calTT() {
			if ($('#from').val() && $('#to').val()) {
				var a = $("#from").datepicker('getDate').getTime(), b = $("#to")
						.datepicker('getDate').getTime(), c = 24 * 60 * 60 * 1000, diffDays = Math
						.round(Math.abs((a - b) / (c)));
				//console.log(diffDays);
				$('#days').val(diffDays);
			}
			;
			if ($('#from').val() && $('#to').val() && $('#price').val()
					&& $('#days').val()) {
				totalC = $('#days').val() * $('#price').val();
				$('#total').val(totalC);
			}
		}
	});
</script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
table {
	font-size: 1em;
}
.ui-draggable, .ui-droppable {
	background-position: top;
}
table tr td input {
	margin-left: 40px;
}
</style>

</head>
<body>
	<h2 style="align-content: center;">Hợp Đồng</h2>
	<div class="container">
		<div class="login">
			<div class="col">
				<form action="${pageContext.request.contextPath}/contract"
					method="post">
					<input type="hidden" name="idproduct" value="${product.idproduct}">
					<input type="hidden" name="nameproduct"
						value="${product.nameproduct}"> <input type="hidden"
						name="species" value="${product.species}"> <input
						type="hidden" name="acmount" value="${product.quantity}">
					<img src="images/${product.avatar}" width="650px" hight="433px"
						alt="" name="uploadFile">
					<div class="form-group">
						<label for="exampleInputEmail1">Địa Chỉ Giao Hàng </label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter " name="address">
					</div>
					<div class="form-group">
						<label for="price">Giá Tiền</label> <input
							type="number" class="form-control"
							aria-describedby="emailHelp" id="price" name="price"
							value="${product.price}">
					</div>
					<div class="form-group">
						<label for="from">Từ</label> <input type="text"
							class="form-control" id="from" name="from"
							aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="to">Đến</label> <input type="text"
							class="form-control" id="to" name="to"
							aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="days">Tổng Số Ngày</label> <input
							type="number" class="form-control" id="days" name="days">
					</div>
					<div class="form-group">
						<label for="total">Tổng số tiền</label>
					<input type="number" id="total" name="total">
					</div>
					<input type="hidden" name="status" value="Đang Chờ">
					<div class="w3" style="padding-top: 30px;">
						<input type="submit" class="btn btn-primary" value="Đăng Ký">
						<a href="${pageContext.request.contextPath}/homeuser"><input type="button"class="btn btn-primary" value="Hủy"></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>