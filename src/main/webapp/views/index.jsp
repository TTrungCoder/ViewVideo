<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<%@include file="/common/taglib.jsp" %>
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
	<%@include file="/common/menu.jsp"%>
	<!--####################### Slider Starts Here ###################-->
	<div class="banner-card container-fluid">
		<div class="container">
			<div class="row no-margin">
				<div class="col-md banner-slid">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<a href="/common/single.jsp">
									<p>
										<iframe class="d-block w-100" width="560" height="435"
											src="https://www.youtube.com/embed/4I3Nza0V3P8"
											title="YouTube video player" frameborder="0"
											allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
											allowfullscreen></iframe>
									</p>
								</a>
							</div>
							<div class="carousel-item">
								<a href="/common/single.jsp">
									<p>
										<iframe class="d-block w-100" width="560" height="435"
											src="https://www.youtube.com/embed/XszJkmsrccI"
											title="YouTube video player" frameborder="0"
											allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
											allowfullscreen></iframe>
									</p>
								</a>
							</div>
							<div class="carousel-item">
								<a href="/common/single.jsp">
									<p>
										<iframe class="d-block w-100" width="560" height="435"
											src="https://www.youtube.com/embed/LZN4I3K8SC0"
											title="YouTube video player" frameborder="0"
											allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
											allowfullscreen></iframe>
									</p>
								</a>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next"
							href="#carouselExampleIndicators" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--####################### Trending Starts Here ###################-->
	<div class="treanding-video container-fluid">
		<div class="container">
			<div class="row video-title no-margin">
				<h6>
					<i class="fas fa-book"></i> Nhạc để chill
				</h6>
			</div>
			<div class="video-row row">
			<c:forEach items="${videos}" var="video">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="video-card">
							<p>
							<img src="<c:url value='${video.poster}'/>">
							</p>
							<div class="row details no-margin">
								<a href="<c:url value='/video?action=watch&id=${video.href}'/>"><h6>${video.title}</h6></a>
								<div class="col-md-6 col-6 no-padding left">
								<span>${video.views} Views</span>
								</div>
								<div class="col-md-6 col-6 no-padding right">
								<span>${video.shares} Share</span>
								</div>
							</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	</div>
	<!--####################### Latest Videos Starts Here ###################-->
	<%@include file="/common/footer.jsp"%>
</body>
<script src="<c:url value='templates/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='templates/js/popper.min.js'/>"></script>
<script src="<c:url value='templates/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='templates/plugins/scroll-fixed/jquery-scrolltofixed-min.js'/>"></script>
<script src="<c:url value='templates/js/script.js'/>"></script>

</html>