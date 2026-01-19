<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報削除画面</title>
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
		<h2>ユーザー情報削除</h2>
	</div>
	
	<div class="user-search">
		<form action="">
			<span>検索ID:</span>
			<input type="text" name="userid" pattern="[0-9]*">
			<input type="submit" value="検索">
		</form>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="contents1">
		<form action="<%= request.getContextPath() %>/" method="POST">
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
			<input type="hidden" name="deletehlg" value="delete">
		</form>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button3">
		<form action="<%= request.getContextPath() %>">
			<input type="submit" value="決定">
		</form>

		<form action="<%= request.getContextPath() %>/jsp/menu.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>

</body>
</html>