<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${video.title}</title>
<%@include file="/common/head.jsp"%>
</head>
<body>
	<!--####################### Header Starts Here ###################-->
	<%@include file="/common/menu.jsp"%>

	<!--  ************************* Page Title Starts Here ************************** -->
	<div class="page-nav no-margin row">
		<div class="container">
			<div class="row">
				<ul>
					<li><a href="index"><i class="fas fa-home"></i> Home</a></li>
					<li><i class="fas fa-angle-double-right"></i> Videos</li>
				</ul>
			</div>
		</div>
	</div>
	<!--####################### Video Blog Starts Here ###################-->
	<div class="container-fluid video-blog">
		<div class="container">
			<div class="row">
				<div class="col-md">
					<div class="row video-cover">
						<p>
							<iframe height="550"
								src="https://www.youtube.com/embed/${video.href}"
								title="YouTube video player" frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
								allowfullscreen></iframe>
						</p>
					</div>
				</div>
			</div>
			<div class="row details no-margin">
				<div class="col-md-6 col-6 no-padding left">
					<h3>${video.title}</h3>
				</div>
				<c:if test="${not empty sessionScope.currentUser}">
					<div class="col-md-6 col-6 no-padding right">
						<button id="likeOrUnlikeBtn" class="btn btn-primary"> 
							<c:choose>
								<c:when test="${flagLikeBtn == true}">UnLike</c:when>
							<c:otherwise>Like</c:otherwise> 
							</c:choose>
							</button>
							<button class="btn btn-primary">Share</button>
							<input id="videoIdHdn" type="hidden" value="${video.href}">
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
<script src="<c:url value='templates/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='templates/js/popper.min.js'/>"></script>
<script src="<c:url value='templates/js/bootstrap.min.js'/>"></script>
<script
	src="<c:url value='template/plugins/scroll-fixed/jquery-scrolltofixed-min.js'/>"></script>
<script src="<c:url value='template/js/script.js'/>"></script>
<script>
		$('#likeOrUnlikeBtn').click(function() {
			var videoId = $('#videoIdHdn').val();
			console.log(videoId);
			$.ajax({
				url : 'video?action=like&id=' + videoId
			}).then(function(data) {
				var text = $('#likeOrUnlikeBtn').text();
				if (text.indexOf('Like') != -1) {
					$('#likeOrUnlikeBtn').text('Unlike');
				} else {
					$('#likeOrUnlikeBtn').text('Like');
				}
			}).fail(function(error) {
				alert('Oops!!! Please try again');
			});
		});
	</script>
</html>