<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath() %>/css/style.css">
<link rel="icon" 
	href="<%=request.getContextPath()%>/images/favicon.png" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include><br><br><br><br>
	
<<<<<<< HEAD
	<form action="/moderateDrinking/MenuServlet" method="post">
=======
	<form action="/awesome/MenuServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<button name=menuButton value="DrinkNow" class=menuButton>これから飲む</button><br><br>
		<button name=menuButton value="InputCondition" class=menuButton>体調入力</button><br><br>
		<button name=menuButton value="InputAmount" class=menuButton>まとめて入力</button><br><br>
		<button name=menuButton value="RegChange" class=menuButton>登録情報編集</button><br><br>
		<button name=menuButton value="MyStats" class=menuButton>マイ統計データ</button><br><br>
		<button name=menuButton value="AdminMenu" class=menuButton>管理者メニュー</button><br><br><br>
	</form>
<<<<<<< HEAD
<!-- 	<a href="/moderateDrinking/LogoutServlet">ログアウト</a> -->
=======
<!-- 	<a href="/awesome/LogoutServlet">ログアウト</a> -->
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
</body>
</html>