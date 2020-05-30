<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <form class="cmxform form-horizontal " id="signupForm" method="post"
		action="${pageContext.request.contextPath}/contract"
		novalidate="novalidate" enctype="multipart/form-data">
		<div class="form-group ">
			<label for="firstname" class="control-label col-lg-3"></label>
			<div class="col-lg-6">
				<input class=" form-control" id="firstname" name="idproduct"
					value="${product.idproduct}">
			</div>
		</div>
		<div class="form-group ">
			<label for="firstname" class="control-label col-lg-3">Name
				Product</label>
			<div class="col-lg-6">
				<input class=" form-control" id="firstname" name="nameproduct"
					value="${product.nameproduct}">
			</div>
		</div>
		<div class="form-group ">
			<label for="lastname" class="control-label col-lg-3">Species</label>
			<div class="col-lg-6">
				<input class=" form-control" id="lastname" name="species"
					value="${product.species}">
			</div>
		</div>
		<div class="form-group ">
			<label for="username" class="control-label col-lg-3">Quantity</label>
			<div class="col-lg-6">
				<input class="form-control " id="username" name="acmount"
					value="${product.quantity}">
			</div>
		</div>
		<div class="form-group ">
			<label for="agree" class="control-label col-lg-3 col-sm-3">Avatar</label>
			<div class="col-lg-6 col-sm-9">
				<img class="img-responsive" src="images/${product.avatar}"
					width="650px" hight="433px" alt="" name="uploadFile">
			</div>
		</div>
		<div class="form-group ">
			<label for="agree" class="control-label col-lg-3 col-sm-3">Phone</label>
			<div class="col-lg-6 col-sm-9">
				<input class="form-control " name="phone" type="text"
					required="required">
			</div>
		</div>
		<div class="form-group ">
			<label for="agree" class="control-label col-lg-3 col-sm-3">Address
				Consign</label>
			<div class="col-lg-6 col-sm-9">
				<input class="form-control " name="Address" type="text"
					required="required">
			</div>
		</div>
		<div class="form-group ">
			<label for="agree" class="control-label col-lg-3 col-sm-3">hire
				day</label>
			<div class="col-lg-6 col-sm-9">
				<input class="form-control " name="hireday" type="date"
					required="required">
			</div>
		</div>
		<div class="form-group ">
			<label for="agree" class="control-label col-lg-3 col-sm-3">Pay
				Day</label>
			<div class="col-lg-6 col-sm-9">
				<input class="form-control " name="payday" type="date"
					required="required">
			</div>
		</div>
		<div class="form-group ">
			<label for="email" class="control-label col-lg-3">Price</label>
			<div class="col-lg-6">
				<input class="form-control " id="email" name="price"
					value="${product.price}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-3 col-lg-6">
				<button class="btn btn-primary" type="submit">Submit</button>
				<button class="btn btn-default" type="button">Cancel</button>
			</div>
		</div>
	</form> --%>
	<form action="${pageContext.request.contextPath}/contract" method="POST">
		Id:<input type="text" name="idproduct" value="${product.idproduct}">
		Name:<input type="text" name="nameproduct" value="${product.nameproduct}" >
		Species<input type="text" name="species" value="${product.species}" >
		Quantity<input type="text" name="quantity" value="${product.quantity}" >
		Avatar<img class="img-responsive" src="images/${product.avatar}"
					width="650px" hight="433px" name="uploadFile">
		phone<input type="text" name="phone" >
		address<input type="text" name="address"  >
		Hire day<input type="date" name="hireday" >
		Pay day<input type="date" name="payday">
		Price<input type="text" name="price" value="${product.price}">
		
		<input type="submit" value="Thuê">
		
	</form>
	<script type = "text/javascript" > 
    var date1 = document.getElementById("hireday"); 
var date2 = document.getElementById("payday"); 
  
// To calculate the time difference of two dates 
var Difference_In_Time = date2.getTime() - date1.getTime(); 
  
// To calculate the no. of days between two dates 
var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24); 
  
//To display the final no. of days (result) 
document.write("Total number of days between dates  <br>"
               + date1 + "<br> and <br>" 
               + date2 + " is: <br> " 
               + Difference_In_Days); 
document.alert(Difference_In_Days);
</script> 
</body>
</html>