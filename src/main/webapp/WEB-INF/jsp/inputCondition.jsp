<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体調入力（飲んだ翌日）</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" 
	href="<%=request.getContextPath()%>/images/favicon.png" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<br>
	<br>

	<label class=inputcondition-label>本日の体調はいかがですか？</label>
	<br>
	<br>

<<<<<<< HEAD
	<form action="/moderateDrinking/InputConditionServlet" method="post">
=======
	<form action="/awesome/InputConditionServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<div class=conditionRadioBlock>
			<div class=conditionRadio>
			<input type="radio" name="condition" value="1">　とてもいい<br>
			<input type="radio" name="condition" value="2">　いい<br>
			<input type="radio" name="condition" value="3">　ふつう<br>
			<input type="radio" name="condition" value="4">　わるい<br>
			<input type="radio" name="condition" value="5">　とてもわるい<br>
			</div>
		<br><br><br>
		<input type="submit" name="送信"  class=button-general>
		</div>
	</form>
	
	<br>
<<<<<<< HEAD
	<form action="/moderateDrinking/MenuServlet" method="get">
=======
	<form action="/awesome/MenuServlet" method="get">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<input type=submit value="メニューへ戻る" class=button-general>
	</form>


</body>
</html>