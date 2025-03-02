<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報編集</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" href="<%=request.getContextPath()%>/images/favicon.png" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<br>
	<br> お気に入り飲料の編集
	<br>
	<br>

<<<<<<< HEAD
	<form action="/moderateDrinking/RegChangeServlet" method="post">
=======
	<form action="/awesome/RegChangeServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<div>
			<table class=regchange-table>
				<label class=regchange-label1>--------------- お気に入り飲料①
					---------------</label>
				<br>
				<label class=regchange-label2><c:out
						value="${favBev.getNo1_bev_name()}" /> (アルコール度数 <c:out
						value="${favBev.getNo1_abv() * 100}" />％)</label>
				<br>
				<tr>
					<th><label>新しい名前</label></th>
					<td><input type=text name=no1BevName></td>
				</tr>
				<tr>
					<th><label>アルコール度数</label></th>
					<td><input type=text name=no1Abv size=3>％</td>
				</tr>
			</table>
			<br>

			<table class=regchange-table>
				<label class=regchange-label1>--------------- お気に入り飲料②
					---------------</label>
				<br>
				<label class=regchange-label2><c:out
						value="${favBev.getNo2_bev_name()}" /> (アルコール度数 <c:out
						value="${favBev.getNo2_abv() * 100}" /> ％) </label>
				<tr>
					<th><label>新しい名前</label></th>
					<td><input type=text name=no2BevName></td>
				</tr>
				<tr>
					<th><label>アルコール度数</label></th>
					<td><input type=text name=no2Abv size=3>％</td>
				</tr>
			</table>
			<br>

			<table class=regchange-table>
				<label class=regchange-label1>--------------- お気に入り飲料③
					---------------</label>
				<br>
				<label class=regchange-label2><c:out
						value="${favBev.getNo3_bev_name()}" /> (アルコール度数 <c:out
						value="${favBev.getNo3_abv() * 100}" />％)</label>
				<tr>
					<th><label>新しい名前</label></th>
					<td><input type=text name=no3BevName></td>
				</tr>
				<tr>
					<th><label>アルコール度数</label></th>
					<td><input type=text name=no3Abv size=3>％</td>
				</tr>
			</table>
			<br>

			<table class=regchange-table>
				<label class=regchange-label1>--------------- お気に入り飲料④
					---------------</label>
				<br>
				<label class=regchange-label2><c:out
						value="${favBev.getNo4_bev_name()}" /> (アルコール度数 <c:out
						value="${favBev.getNo4_abv() * 100}" />％)</label>
				<tr>
					<th><label>新しい名前</label></th>
					<td><input type=text name=no4BevName></td>
				</tr>
				<tr>
					<th><label>アルコール度数</label></th>
					<td><input type=text name=no4Abv size=3>％</td>
				</tr>
			</table>
			<br>

			<table class=regchange-table>
				<label class=regchange-label1>--------------- お気に入り飲料⑤
					---------------</label>
				<br>
				<label class=regchange-label2><c:out
						value="${favBev.getNo5_bev_name()}" /> (アルコール度数 <c:out
						value="${favBev.getNo5_abv() * 100}" />％)</label>
				<tr>
					<th><label>新しい名前</label></th>
					<td><input type=text name=no5BevName></td>
				</tr>
				<tr>
					<th><label>アルコール度数</label></th>
					<td><input type=text name=no5Abv size=3>％</td>
				</tr>
			</table>
			<br> <br> <input type=submit name=update value=更新
				class=button-general> <br> <br>
		</div>
	</form>
	<hr>
	<br>
<<<<<<< HEAD
	<form action="/moderateDrinking/RegChangeServlet" method="post">
=======
	<form action="/awesome/RegChangeServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<div>
			<label class=regchange-label>アルコール度数計算</label><br>
			<br>
			<table class=regchange-calctable>
				<tr>
					<th></th>
					<td>アルコール度数</td>
					<td>量（比率）</td>
				</tr>
				<tr>
					<th>ベースのお酒</th>
					<td><input type=text name=base-abv class=regchange-calc-tbox>%</td>
					<td><input type=text name=base-amount
						class=regchange-calc-tbox></td>
				</tr>
				<tr>
					<th>割る飲み物</th>
					<td><input type=text name=with-abv class=regchange-calc-tbox>%</td>
					<td><input type=text name=with-amount
						class=regchange-calc-tbox></td>
				</tr>
			</table>
			<br>
			
			<input type=submit name=calc value=計算 class=button-general><br><br>
			<c:if test="${ not empty calcAbvResult }">
			アルコール度数は　<c:out value="${ calcAbvResult }" />　％です		</c:if>
			
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
	<br>
	<br>
</body>
</html>