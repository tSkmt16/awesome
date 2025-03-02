<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>体調入力</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="icon" href="<%=request.getContextPath()%>/images/favicon.png" />
<meta charset="UTF-8">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<p>体調の登録が完了しました</p>
	<br>
<<<<<<< HEAD
	<form action="/moderateDrinking/MenuServlet" method="get">
=======
	<form action="/awesome/MenuServlet" method="get">
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		<input type=submit value="メニューへ戻る" class=button-general>
	</form>
	<br><br>
	<input type=button id=btn1 value="周辺のトイレを探す" onClick="linkCheck(1)"
		class=button-link />
	<br>
	<br>
	<input type=button id=btn2 value="周辺のコンビニを探す" onClick="linkCheck(2)"
		class=button-link />
	<br>
	<br>
	<input type=button id=btn3 value="コンビニで買える二日酔いに効くものを探す"
		onClick="linkCheck(3)" class=button-link />
	<br>
	<br>
	<iframe src="" width="480" height="400" style="border: 0;"
		allowfullscreen="" loading="lazy"
		referrerpolicy="no-referrer-when-downgrade" id=iframe></iframe>
	<br><br>	

	<script>
		function linkCheck(btn) {
			var sw = screen.width * 0.8;
			var sh = screen.height * 0.8;
			if (btn == 1) {
				iframe.src = 'https://maps.google.com/maps?output=embed&q=現在地+トイレ&z=15'
			} else if (btn == 2) {
				iframe.src = 'https://maps.google.com/maps?output=embed&q=現在地+コンビニ&z=15'
			} else if (btn == 3) {
				window
						.open(
								'https://www.google.co.jp/search?q=%E4%BA%8C%E6%97%A5%E9%85%94%E3%81%84+%E3%82%B3%E3%83%B3%E3%83%93%E3%83%8B',
								'new_window', 'left=50, top=50, width=' + sw
										+ ', height=' + sh);
			}

		}
	</script>

	<!-- <script type="text/javascript">
		function linkCheck(btn) {
			var sw = screen.width * 0.8;
			var sh = screen.height * 0.8;
			if (btn == 1) {
				window
						.open(
								'https://www.google.co.jp/maps/search/%E7%8F%BE%E5%9C%A8%E5%9C%B0+%E3%82%B3%E3%83%B3%E3%83%93%E3%83%8B',
								'new_window', 'left=50, top=50, width=' + sw
										+ ', height=' + sh);
			} else if (btn == 2) {
				window
						.open(
								'https://www.google.co.jp/maps/search/%E7%8F%BE%E5%9C%A8%E5%9C%B0+%E3%83%88%E3%82%A4%E3%83%AC',
								'new_window', 'left=50, top=50, width=' + sw
										+ ', height=' + sh);
			} else if (btn == 3) {
				window
						.open(
								'https://www.google.co.jp/search?q=%E4%BA%8C%E6%97%A5%E9%85%94%E3%81%84+%E3%82%B3%E3%83%B3%E3%83%93%E3%83%8B',
								'new_window', 'left=50, top=50, width=' + sw
										+ ', height=' + sh);
			}

		} 
	</script> -->

</body>
</html>