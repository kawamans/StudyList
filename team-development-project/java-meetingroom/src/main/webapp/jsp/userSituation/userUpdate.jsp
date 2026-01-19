<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録変更画面</title>
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
		<h2>ユーザー情報変更</h2>
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
				<input type="text" name="username" placeholder="田中太郎" value="">
			</div>

			<div class="input-user">
				<span class="user-name">出生年:</span>
				<input type="text" name="userage" maxlength="3" pattern="[0-9]*" placeholder="2000" value="">
			</div>

			<div class="input-user">
				<span class="user-name">住所:</span>
				<input type="text" name="address" value="">
			</div>

			<div class="input-user">
				<span class="user-name">PW:</span>
				<input type="text" name="password" minlength="6" maxlength="10" pattern="[0-9a-zA-Z]*" placeholder="半角英数字6～10文字" value="">
			</div>

			<div class="input-user">
				<span class="user-name">管理者権限:</span>
				<input type="checkbox" name="admin">
			</div>

			<div class="button1">
				<input type="submit" value="決定">
			</div>
		</form>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button1">
		<form action="<%= request.getContextPath() %>/jsp/menu.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>

</body>
</html>