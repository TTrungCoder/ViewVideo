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
				<h2>Login</h2>
				<ul>
					<li><a href="index"><i class="fas fa-home"></i> Home</a></li>
					<li><i class="fas fa-angle-double-right"></i> Login</li>
				</ul>
			</div>
		</div>
	</div>


	<!--####################### Video Blog Starts Here ###################-->
	<div class="row" style="margin-bottom: 110px">
		<div class="col-sm-6 offset-sm-3">
			<form id="login-form" action="login" method="post">
				<h3>User Login</h3>
				<div class="form-group">
					<label>Username:</label> <input type="text" class="form-control"
						name="username">
				</div>
				<div class="form-group">
					<label>Password:</label> <input type="password"
						class="form-control" name="password">
				</div>
				<div class="form-group">
					<label><a href="forgotpassword">Forgot PassWord</a></label> 
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
				${message}
			</form>
		</div>
	</div>

	<!--####################### Footer Starts Here ###################-->
	<%@include file="/common/footer.jsp"%>
</body>
<script src="<c:url value='template/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='template/js/popper.min.js'/>"></script>
<script src="<c:url value='template/js/bootstrap.min.js'/>"></script>
<script
	src="<c:url value='template/plugins/scroll-fixed/jquery-scrolltofixed-min.js'/>"></script>
<script src="<c:url value='template/js/script.js'/>"></script>


</html>