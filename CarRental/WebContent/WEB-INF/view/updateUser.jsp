<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="headeruser.jsp"></jsp:include>
		
	<div class="grow">
		<div class="container">
			<h2>CẬP NHẬT THÔNG TIN CÁ NHÂN</h2>
		</div>
	</div>
	<!-- grow -->
<!--content-->
<div class="container">
		<div class="account">
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<form action="${pageContext.request.contextPath}/updateUser" method="post">			
			<div> 	
				<span>Họ tên :</span>
				<input type="text" name="name" value="${users.nameuser}"> 
			</div>
			<div> 
				<span >CMND</span>
				<input type="text" name="idcard" value="${users.idCard}">
			</div>	
			<div> 
				<span >Ngày sinh</span>
				<input type="date" name="datebirth" value="${users.datebirth}">
			</div>
			<div> 
				<span >Địa chỉ</span>
				<input type="text" name="address" value="${users.address}">
			</div>
			<div> 
				<span >Số điện thoại</span>
				<input type="text" name="phone" value="${users.phonenumber}">
			</div>
			<div> 
				<span >Username</span>
				<input type="text" name="username" value="${users.username}">
			</div>
			<div> 
				<span >Password</span>
				<input type="password" name="pass" value="${users.passwords}">
			</div>
			<div> 
				<input type="hidden" name="roles" value="user">
			</div>			
				<input type="submit" value="Cập nhật"> 
				<a href="${pageContext.request.contextPath}/homeuser" ><input type="button" value="Hủy"></a>
			</form>
		</div>
	<div class="clearfix"> </div>

</div>
<div class="footer w3layouts">
				<div class="container">
			<div class="footer-top-at w3">
			
				<div class="col-md-3 amet-sed w3l">
				<h4>MORE INFO</h4>
				<ul class="nav-bottom">
						<li><a href="#">How to order</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="contact.html">Location</a></li>			
					</ul>	
				</div>
				<div class="col-md-3 amet-sed w3ls">
					<h4>CATEGORIES</h4>
					<ul class="nav-bottom">
						<li><a href="#">Audi</a></li>
						<li><a href="#">Mec</a></li>
						<li><a href="#">Ford</a></li>
					</ul>
					
				</div>
				<div class="col-md-3 amet-sed agileits">
					<h4>NEWSLETTER</h4>
					<div class="stay agileinfo">
						<div class="stay-left wthree">
							<form action="#" method="post">
								<input type="text" placeholder="Enter your email " required="">
							</form>
						</div>
						<div class="btn-1 w3-agileits">
							<form action="#" method="post">
								<input type="submit" value="Subscribe">
							</form>
						</div>
							<div class="clearfix"> </div>
			</div>
					
				</div>
				<div class="col-md-3 amet-sed agileits-w3layouts">
				<h4>CONTACT US</h4>
					<p>Nguyen Duc Duy</p>
					<p>Nguyen Thanh Tai</p>
					<p>office :  0764103425</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="footer-class w3-agile">
		<p>Â© Da Nang Viet Nam</a> </p>
		</div>
		</div>
</body>
</html>
			