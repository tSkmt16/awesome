<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath() %>/css/style.css">
<link rel="icon" 
	href="<%=request.getContextPath()%>/images/favicon.png" />

<body>
	<h3>新規ユーザー登録</h3>
<<<<<<< HEAD
	<form action="/moderateDrinking/SignUpServlet" method="post">
=======
	<form action="/awesome/SignUpServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<label>ユーザー名</label>
			<input type="text" name="user_name"><br>
		<label>パスワード</label>
			<input type="password" name="password"><br>
		<%-- 生年月日:<input type="text" name="dob"><br> --%>
		<label>生年月日(西暦)</label>
			<input type="text" name="year" size="5">年
			<input type="text" name="month" size="2">月
			<input type="text" name="day" size="2">日<br>
		<label>性別</label>
			<input type="radio" name="gender" value="0">男性
			<input type="radio" name="gender" value="1">女性
			<input type="radio" name="gender" value="2">回答しない<br><br>
		<input type="submit" value="登録" class="submit-button">
		
		<input type="hidden" name="admin" value="0">
	</form>

</body>
</html>