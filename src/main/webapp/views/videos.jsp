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
</head>

<body>

	<!--####################### Header Starts Here ###################-->
	<%@include file="/common/menu.jsp" %>

	<!--  ************************* Page Title Starts Here ************************** -->
	<div class="page-nav no-margin row">
		<div class="container">
			<div class="row">
				<h2>Top Videos</h2>
				<ul>
					<li><a href="index"><i class="fas fa-home"></i> Home</a></li>
					<li><i class="fas fa-angle-double-right"></i> Videos</li>
				</ul>
			</div>
		</div>
	</div>


	<!--####################### Trending Starts Here ###################-->
	<div class="treanding-video container-fluid">
		<div class="container">
			<div class="row video-title no-margin">
				<h6>
					<i class="fas fa-book"></i>Videos Favorites
				</h6>
			</div>
			<div class="video-row row">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="video-card">
						<a href="single.jsp">
							<p>
								<iframe width="250" height="170"
									src="https://www.youtube.com/embed/f2zxY2ikY54"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
									allowfullscreen></iframe>
							</p>
							<div class="row details no-margin">
								<h6>Cười Muốn Xĩu khi Xem Hài Hoài Linh, Trường Giang, Phi
									Nhung Hay Nhất - Hài Kịch 2023</h6>
								<div class="col-md-6 col-6 no-padding left">
									<i class="fa-regular fa-heart"></i> <span>Like</span>
								</div>
								<div class="col-md-6 col-6 no-padding right">
									<i class="far fa-comments"></i> <span>Share</span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="video-card">
						<a href="single.jsp">
							<p>
								<iframe width="250" height="170"
									src="https://www.youtube.com/embed/f2zxY2ikY54"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
									allowfullscreen></iframe>
							</p>
							<div class="row details no-margin">
								<h6>Cười Muốn Xĩu khi Xem Hài Hoài Linh, Trường Giang, Phi
									Nhung Hay Nhất - Hài Kịch 2023</h6>
								<div class="col-md-6 col-6 no-padding left">
									<i class="fa-regular fa-heart"></i> <span>Like</span>
								</div>
								<div class="col-md-6 col-6 no-padding right">
									<i class="far fa-comments"></i> <span>Share</span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="video-card">
						<a href="single.jsp">
							<p>
								<iframe width="250" height="170"
									src="https://www.youtube.com/embed/f2zxY2ikY54"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
									allowfullscreen></iframe>
							</p>
							<div class="row details no-margin">
								<h6>Cười Muốn Xĩu khi Xem Hài Hoài Linh, Trường Giang, Phi
									Nhung Hay Nhất - Hài Kịch 2023</h6>
								<div class="col-md-6 col-6 no-padding left">
									<i class="fa-regular fa-heart"></i> <span>Like</span>
								</div>
								<div class="col-md-6 col-6 no-padding right">
									<i class="far fa-comments"></i> <span>Share</span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="video-card">
						<a href="single.jsp">
							<p>
								<iframe width="250" height="170"
									src="https://www.youtube.com/embed/f2zxY2ikY54"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
									allowfullscreen></iframe>
							</p>
							<div class="row details no-margin">
								<h6>Cười Muốn Xĩu khi Xem Hài Hoài Linh, Trường Giang, Phi
									Nhung Hay Nhất - Hài Kịch 2023</h6>
								<div class="col-md-6 col-6 no-padding left">
									<i class="fa-regular fa-heart"></i> <span>Like</span>
								</div>
								<div class="col-md-6 col-6 no-padding right">
									<i class="far fa-comments"></i> <span>Share</span>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>




	<!--####################### Quote Starts Here ###################-->

	<!--####################### Footer Starts Here ###################-->
		<%@include file="/common/footer.jsp" %>
</body>
<script src="<c:url value='templates/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='templates/js/popper.min.js'/>"></script>
<script src="<c:url value='templates/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='templates/plugins/scroll-fixed/jquery-scrolltofixed-min.js'/>"></script>
<script src="<c:url value='templates/js/script.js'/>"></script>


</html>