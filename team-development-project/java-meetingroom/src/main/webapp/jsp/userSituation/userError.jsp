<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザーエラー画面</title>
	<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
	</head>
<body>
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2>登録エラー</h2>
		<h2>変更エラー</h2>
		<h2>削除エラー</h2>
	</div>

	<div class="contents1">
		<div class="input-user">
			<span class="user-name">氏名:</span>
			<%-- データベースから取得 --%>
			<span class="user-data">田中太郎</span>
		</div>
		<div class="input-user">
			<span class="user-name">出生年:</span>
			<%-- データベースから取得 --%>
			<span class="user-data">1997</span>
		</div>
		<div class="input-user">
			<span class="user-name">住所:</span>
			<%-- データベースから取得 --%>
			<span class="user-data">愛知県名古屋市</span>
		</div>
		<div class="input-user">
			<span class="user-name">PW:</span>
			<%-- データベースから取得 --%>
			<span class="user-data">********</span>
		</div>
		<div class="input-user">
			<span class="user-name">管理者権限:</span>
			<%-- データベースから取得 --%>
			<span class="user-data">あり</span>
		</div>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button1">
		<form action="<%= request.getContextPath() %>/jsp/menu.jsp" method="get">
			<input type="submit" value="確認">
		</form>
	</div>

</body>
</html>