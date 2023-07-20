<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<header class="continer-fluid ">
	<div class="header-bottom">
		<div class="container">
			<div class="row nav-row">
				<div class="col-md-3 logo">
					<a href="index"><img style="width: 120px" 
						src="<c:url value='/templates/images/logo2.png'/>"></a>
				</div>
				<div class="col-md-9 nav-col">
					<nav class="navbar navbar-expand-lg navbar-light">

						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarNav"
							aria-controls="navbarNav" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav">
								<c:choose>
									<c:when test="${not empty sessionScope.currentUser}">
										<li class="nav-item "><a class="nav-link" href="#">Hi, ${sessionScope.currentUser.username}</a>
										</li>
										<li class="nav-item"><a class="nav-link" href="favorites">My
												Favorites</a></li>
										<li class="nav-item"><a class="nav-link" href="history">History</a>
										</li>
										<c:if test="${sessionScope.currentUser.isAdmin}">
												<li class="nav-item"><a class="nav-link"
													href="admin">AccountManager</a>
											</c:if>
										<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
									</c:when>
									<c:otherwise>
										<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
										<li class="nav-item"><a class="nav-link" href="register">Resgister</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
</header>