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
		<form name="form1" action="/moderateDrinking/LoginServlet" method="post">
			<label>ユーザー名</label> <input type="text" name="user_name"><br>
			<label>パスワード</label> <input type="password" name="password"><br>
			<br>
			<!-- <input type="submit" value="ログイン" class="submit-button"><br><br> -->
			<input type="button" value="ログイン" onclick="post_open();"/>			
		</form>
		<div>
			アカウントをお持ちでない場合<br> 
			新規登録は<a href="/moderateDrinking/SignUpServlet">こちら</a>
		</div>
		
		<script>
			function post_open() {
				var num = window.innerWidth;
				if (num > 510){
					window.close();
				}			
				window.open('', 'new_window','width=500,height=800,scrollbars=yes');
				document.form1.action = '/moderateDrinking/LoginServlet';
				document.form1.method = 'POST'; 
				document.form1.target = 'new_window';
				document.form1.submit();
			}
		</script>
</body>
</html>
