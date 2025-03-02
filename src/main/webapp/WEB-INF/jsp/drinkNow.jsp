
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Record" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>これから飲む</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" 
	href="<%=request.getContextPath()%>/images/favicon.png" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<br>
	<label class=label-center>現在の飲酒量</label><br>
	<label class=label-small-font>(<c:out value="${ldToday}" />　6:00　～　<c:out value="${ldNextDay}" />　6:00)</label>
	<br><br>
	<table class=drinknow-table>
		<tr>
			<th><label>飲酒総量　　</label></th>
			<td><c:out value="${liquid_intake}" /></td>
		</tr>
		<tr>
			<th><label>純アルコール量　　</label></th>
			<td><c:out value="${alcohol_intake}" /></td>
		</tr>
	</table>
	<br><br>

<<<<<<< HEAD
	<form action="/moderateDrinking/DrinkNowServlet" method="post">
=======
	<form action="/awesome/DrinkNowServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e

		<select name="beverages" class=ddlist>
			<option value="" selected hidden>選択してください</option>
			<c:forEach var="mapFavBev" items="${ mapFavBev }">
				<%-- <c:out value="${mapFavBev.key}" /> --%>
				<option value="${mapFavBev.key}"
					<c:if test="${mapFavBev.key.equals(selectBeverage)}">selected</c:if>>${mapFavBev.key}</option>
			</c:forEach>

			<%-- <option value="beer" <c:if test="${ selectBeverage.equals('beer') }">selected</c:if>>ビール</option>
			<option value="highball" <c:if test="${ selectBeverage.equals('highball') }">selected</c:if>>ハイボール</option>
			<option value="wine" <c:if test="${ selectBeverage.equals('wine') }">selected</c:if>>ワイン</option> --%>
		</select> <select name="amount" class=ddlist>
			<option value="" selected hidden>選択してください</option>
			<option value="500"
				<c:if test="${ selectAmount == 500 }">selected</c:if>>500mL(大ジョッキ)</option>
			<option value="350"
				<c:if test="${ selectAmount == 350 }">selected</c:if>>350mL(中ジョッキ)</option>
			<option value="125"
				<c:if test="${ selectAmount == 125 }">selected</c:if>>125mL(ワイングラス)</option>
		</select> <br> <br>

		<%-- alcohol_intake  <c:out value="${alcohol_intake}" /><br>
		badValue <c:out value="${badValue}" /><br>
		verybadValue<c:out value="${verybadValue}" /><br>
		doubleBadValue <c:out value="${doubleBadValue}" /><br>
		doubleVerybadValue<c:out value="${doubleVerybadValue}" /><br> --%>

		<meter min="0" max=<c:out value="${doubleVerybadValue}" /> *1.5
			low=<c:out value="${doubleBadValue}" />
			high=<c:out value="${doubleVerybadValue}" /> optimum="0.01"
			value=<c:out value="${doubleAlcohol_intake}" />> </meter>

		<div>
			<c:choose>
				<c:when test="${ doubleAlcohol_intake >= doubleVerybadValue }">
					<c:if test="${ doubleVerybadValue > 0}">
						<div class=bgRed>
							アルコール摂取量が<br> 体調「とてもわるい」になる平均値<br> 【
							<c:out value="${ verybadValue }" />
							】を超過しています。
						</div>
					</c:if>
				</c:when>
				<c:when test="${ doubleAlcohol_intake >= doubleBadValue }">
					<c:if test="${ doubleBadValue > 0}">
						<div class=bgYellow>
							アルコール摂取量が<br> 体調「わるい」になる平均値<br> 【
							<c:out value="${ badValue }" />
							】を超過しています。
						</div>
					</c:if>
				</c:when>
				<c:when test="${ doubleAlcohol_intake > doubleBadValue * 0.9 }">
					<c:if test="${ doubleBadValue > 0}">
						<div>
							アルコール摂取量が<br> 体調「わるい」になる平均値<br> 【
							<c:out value="${ badValue }" />
							】に近づいています。
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
					<!-- <br>
					<br>
					<br> -->
				</c:otherwise>
			</c:choose>
		</div>
		<br>

		<div class=count-button-container>
			<button name=countButton value="up"  class="button-plus"><span>PLUS</span></button>
			<button name=countButton value="down" class="button-minus"><span>MINUS</span></button>
		</div>
	</form>
	
<<<<<<< HEAD
	<form action="/moderateDrinking/MenuServlet" method="get">
=======
	<form action="/awesome/MenuServlet" method="get">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<input type=submit value="メニューへ戻る" class=button-general>
	</form>
</body>
</html>