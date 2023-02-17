<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<header class="header">
	<div class="header-inner">
		<!-- <div class="logo">
			<img src="images/iconBeer.png" />
		</div> -->
		<div class=header-label>
			<c:out value="${ user_name }" />
			さん
		</div>
		<nav class="header-nav">
			<div class="header-nav-item">
				<a href="/moderateDrinking/MenuServlet"><img
					src="images/iconHome.png" class="header-avatar" />
					<!-- <div class=header-label>Home</div> --> </a>
			</div>
			<div class="header-nav-item">
				<a href="/moderateDrinking/LogoutServlet"><img
					src="images/iconLogout.png" class="header-avatar" />
					<!-- <div class=header-label>Logout</div> --> </a>
			</div>
		</nav>
	</div>
</header>
</html>