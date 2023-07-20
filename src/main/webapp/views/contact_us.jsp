<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BiCodeVideo</title>

<%@include file="/common/head.jsp" %>

<body>

	<!--####################### Header Starts Here ###################-->
	<%@include file="/common/menu.jsp"%>

	<!--  ************************* Page Title Starts Here ************************** -->
	<div class="page-nav no-margin row">
		<div class="container">
			<div class="row">
				<h2>Share Video	</h2>
				<ul>
					<li><a href="index"><i class="fas fa-home"></i> Home</a></li>
					<li><i class="fas fa-angle-double-right"></i> Share Video</li>
				</ul>
			</div>
		</div>
	</div>


	<!--####################### Video Blog Starts Here ###################-->
	<div class="row contact-rooo no-margin">
		<div class="container">
			<div class="row">
				<div style="padding: 20px" class="col-sm-7">
					<h2>Contact Form</h2>
					<br>
					<div class="row cont-row">
						<div class="col-sm-3">
							<label>Enter Name </label><span>:</span>
						</div>
						<div class="col-sm-8">
							<input type="text" placeholder="Nhập tên" name="name"
								class="form-control input-sm">
						</div>
					</div>
					<div class="row cont-row">
						<div class="col-sm-3">
							<label>Email Address </label><span>:</span>
						</div>
						<div class="col-sm-8">
							<input type="text" name="name" placeholder="Nhập email"
								class="form-control input-sm">
						</div>
					</div>
					<div class="row cont-row">
						<div class="col-sm-3">
							<label>Mobile Number</label><span>:</span>
						</div>
						<div class="col-sm-8">
							<input type="text" name="name" placeholder="Nhập số điện thoại"
								class="form-control input-sm">
						</div>
					</div>
					<div class="row cont-row">
						<div class="col-sm-3">
							<label>Enter Message</label><span>:</span>
						</div>
						<div class="col-sm-8">
							<textarea rows="5" placeholder=""
								class="form-control input-sm"></textarea>
						</div>
					</div>
					<div style="margin-top: 10px;" class="row">
						<div style="padding-top: 10px;" class="col-sm-3">
							<label></label>
						</div>
						<div class="col-sm-8">
							<button class="btn btn-danger btn-sm">Send Message</button>
						</div>
					</div>
				</div>
				<div class="col-sm-5">
					<div style="margin: 50px" class="serv">
						<h2 style="margin-top: 10px;">Address</h2>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/common/footer.jsp"%>
</body>
<script src="<c:url value='templates/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='templates/js/popper.min.js'/>"></script>
<script src="<c:url value='templates/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='templates/plugins/scroll-fixed/jquery-scrolltofixed-min.js'/>"></script>
<script src="<c:url value='templates/js/script.js'/>"></script>


</html>