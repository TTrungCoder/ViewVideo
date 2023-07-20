<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<%@include file="/common/taglib.jsp"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BiCodeVideo</title>

<%@include file="/common/head.jsp"%>
</head>

<body>

	<!--####################### Header Starts Here ###################-->
	<%@include file="/common/menu.jsp"%>

	<!--  ************************* Page Title Starts Here ************************** -->
	<div class="page-nav no-margin row">
		<div class="container">
			<div class="row">
				<h2>Forgot Password</h2>
				<ul>
					<li><a href="index"><i class="fas fa-home"></i> Home</a></li>
					<li><i class="fas fa-angle-double-right"></i> Forgot PassWord</li>
				</ul>
			</div>
		</div>
	</div>


	<!--####################### Video Blog Starts Here ###################-->
	<div class="row" style="margin-bottom: 270px">
		<div class="col-sm-6 offset-sm-3">
				<h3></h3>
				<div class="form-group">
					<label>Email:</label> <input type="email" id="email" class="form-control"
						name="email">
				</div>
				<button type="submit" id="sendEmailBtn" class="btn btn-primary">Send</button>
				<h5 style="color: red" id="messageReturn"></h5>
		</div>
	</div>

	<!--####################### Footer Starts Here ###################-->
	<%@include file="/common/footer.jsp"%>
</body>

<script src="<c:url value='templates/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='templates/js/popper.min.js'/>"></script>
<script src="<c:url value='templates/js/bootstrap.min.js'/>"></script>
<script
	src="<c:url value='template/plugins/scroll-fixed/jquery-scrolltofixed-min.js'/>"></script>
<script src="<c:url value='template/js/script.js'/>"></script>
<script>
$('#sendEmailBtn').click(function (){
	$('#messageReturn').text('');
	var email = $('#email').val();
	var formData = {'email' : email};
	$.ajax({
		url: 'forgotpassword',
		type: 'POST',
		data: formData
	}).then(function(data){
		$('#messageReturn').text('Have a new password, please check your email!');
		setTimeout(function(){
			window.location.href = 'http://localhost:8080/AsmFinal/login';
		}, 5*1000);
	}).fail(function(error){
		$('#messageReturn').text('Email is wrong, please your email again!');
	})
});
</script>
</html>