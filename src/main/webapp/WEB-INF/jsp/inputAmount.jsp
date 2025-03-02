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

<<<<<<< HEAD
	<form action="/moderateDrinking/InputAmountServlet" method="post">
=======
	<form action="/awesome/InputAmountServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<input type="date" name="selectedDate" value="${targetDate}"
			class=dateForm required onchange="submit(this.form)" />
		<!-- <input type="submit" name="reload" value="更新"> -->
		<br> <br>
	</form>

	<div>
		<table class=inputamount-table>
			<tr>
				<th>飲酒総量</td>
				<td><c:out value="${targetLiquidIntake}" /></td>
			</tr>
			<tr>
				<th>純アルコール量</td>
				<td><c:out value="${targetAlcoholIntake}" /></td>
			</tr>
			<tr>
				<th>翌日の体調</td>
				<td><c:out value="${targetCondition}" /></td>
			</tr>
		</table>
	</div>
	<br>
	<br>
	<br>

<<<<<<< HEAD
	<form action="/moderateDrinking/InputAmountServlet" method="post">
=======
	<form action="/awesome/InputAmountServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<label class=inputamount-label>上書きする場合は ↓ に入力してください</label>
		<br>
		<br>
		<select name="beverages1" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<c:forEach var="mapFavBev" items="${ mapFavBev }">
				<option value="${ mapFavBev.key }">${ mapFavBev.key }</option>
			</c:forEach>
		</select> 
		<select name="amount1" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<option value="500">500mL(大ジョッキ)</option>
			<option value="350">350mL(中ジョッキ)</option>
			<option value="125">125mL(ワイングラス)</option>
		</select> 
		<select name="cups1" class=ddlist-short>
			<c:forEach var="cups" items="${ cups }">
				<option value="${ cups }">${ cups }</option>
			</c:forEach>
		</select> <br>
		<br>
		<select name="beverages2" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<c:forEach var="mapFavBev" items="${ mapFavBev }">
				<option value="${ mapFavBev.key }">${ mapFavBev.key }</option>
			</c:forEach>
		</select> 
		<select name="amount2" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<option value="500">500mL(大ジョッキ)</option>
			<option value="350">350mL(中ジョッキ)</option>
			<option value="125">125mL(ワイングラス)</option>
		</select> 
		<select name="cups2" class=ddlist-short>
			<c:forEach var="cups" items="${ cups }">
				<option value="${ cups }">${ cups }</option>
			</c:forEach>
		</select>
		<br>
		<br> 
		<select name="beverages3" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<c:forEach var="mapFavBev" items="${ mapFavBev }">
				<option value="${ mapFavBev.key }">${ mapFavBev.key }</option>
			</c:forEach>
		</select> 
		<select name="amount3" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<option value="500">500mL(大ジョッキ)</option>
			<option value="350">350mL(中ジョッキ)</option>
			<option value="125">125mL(ワイングラス)</option>
		</select> 
		<select name="cups3" class=ddlist-short>
			<c:forEach var="cups" items="${ cups }">
				<option value="${ cups }">${ cups }</option>
			</c:forEach>
		</select> 
		<br>
		<br> 
		翌日の体調 
		<select name="condition" class=ddlist-long>
			<option value="" selected hidden>選択してください</option>
			<option value="5">とてもいい</option>
			<option value="4">いい</option>
			<option value="3">ふつう</option>
			<option value="2">わるい</option>
			<option value="1">とてもわるい</option>
		</select> <br>
		<br> <input type="submit" name="update" value="登録"
			class=button-general>
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