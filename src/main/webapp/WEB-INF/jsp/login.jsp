<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康管理</title>
</head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" 
	href="<%=request.getContextPath()%>/images/favicon.png" />
<body>
	<h3>
		健康管理（アルコール摂取量と体調の記録）
		</h1>
		<c:if test="${ not empty loginErrorMsg }">
			<div class="errormsg">${ loginErrorMsg }</div>
		</c:if>
<<<<<<< HEAD
		<form name="form1" action="/moderateDrinking/LoginServlet" method="post">
=======
		<form name="form1" action="/awesome/LoginServlet" method="post">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
			<label>ユーザー名</label> <input type="text" name="user_name"><br>
			<label>パスワード</label> <input type="password" name="password"><br>
			<br>
			<!-- <input type="submit" value="ログイン" class="submit-button"><br><br> -->
			<input type="button" value="ログイン" onclick="post_open();"/>			
		</form>
		<div>
			アカウントをお持ちでない場合<br> 
<<<<<<< HEAD
			新規登録は<a href="/moderateDrinking/SignUpServlet">こちら</a>
=======
			新規登録は<a href="/awesome/SignUpServlet">こちら</a>
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		</div>
		
		<script>
			function post_open() {
				var num = window.innerWidth;
				if (num > 510){
					window.close();
				}			
				window.open('', 'new_window','width=500,height=800,scrollbars=yes');
<<<<<<< HEAD
				document.form1.action = '/moderateDrinking/LoginServlet';
=======
				document.form1.action = '/awesome/LoginServlet';
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
				document.form1.method = 'POST'; 
				document.form1.target = 'new_window';
				document.form1.submit();
			}
		</script>
</body>
</html>
