<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>まとめて入力</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" href="<%=request.getContextPath()%>/images/favicon.png" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<br>
	<br>
	<br>

	<div>
		<c:out value="${TargetDate}" />
		のデータを更新しました <br> <br>
		<table class=completeinputamount-table>
			<tr>
				<th>飲酒総量</th>
				<td><c:out value="${totalLiquid}" />L</td>
			</tr>
			<tr>
				<th>純アルコール量</th>
				<td><c:out value="${totalAlcohol}" />mL</td>
			</tr>
			<tr>
				<th>翌日の体調</th>
				<td><c:out value="${strCondition}" /></td>
			</tr>
		</table>
	</div>
	<br>
	<br>

<<<<<<< HEAD
	<form action="/moderateDrinking/InputAmountServlet" method="get">
=======
	<form action="/awesome/InputAmountServlet" method="get">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<input type=submit name=continue value="つづけて入力する" class=button-general>
		</button>
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
