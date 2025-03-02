<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
String chartPath = (String) request.getAttribute("chartPath");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイ統計データ</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" href="<%=request.getContextPath()%>/images/favicon.png" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<br>
	<br>

	<table class=mystats-table>
		1日の平均飲酒量（記録のない日は除く）
		<br>
		<br>
		<tr>
			<th><label>総量</label></th>
			<td><c:out value="${ avgLiquid }" /></td>
		</tr>
		<tr>
			<th><label>アルコール量 </label></th>
			<td><c:out value="${ avgAlcohol }" /></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<table class=mystats-table>
		アルコール摂取量と翌日の体調
		<br>
		<br>
		<tr>
			<th><label>体調<span class=bold>「わるい」</span>になる平均値
			</label></th>
			<td><c:out value="${ badValue }" /></td>
		</tr>
		<tr>
			<th><label>体調<span class=bold>「とてもわるい」</span>になる平均値
			</label></th>
			<td><c:out value="${ verybadValue }" /></td>
		</tr>
	</table>
	<br>
	<br>
	<br>

<<<<<<< HEAD
	<!-- <form action="/moderateDrinking/CreateChartServlet" method="get"> -->
	<form action="/moderateDrinking/MyStatsServlet" method="post">
=======
	<!-- <form action="/awesome/CreateChartServlet" method="get"> -->
	<form action="/awesome/MyStatsServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<input type="date" name="startDate" value="${targetDate}"
			class=dateForm required /> <input type="date" name="endDate"
			value="${targetDate}" class=dateForm required /> 
		<input type="submit" value="実行">
	</form>
	<br>
	

	<img src="${ chartPath }">
	<%-- <c:out value="${ chartPath }" /> --%>
	
	<%-- <img src="<c:out value="${ chartPath }" />"> --%>
	<%-- <img src="<%= chartPath %>"> --%>
	<!-- <img src="chart/2_20230111_134700.png"> -->
	<br>
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