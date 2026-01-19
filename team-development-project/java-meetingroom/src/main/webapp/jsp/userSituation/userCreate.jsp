<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>新規登録画面</title>
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
		<h2>ユーザー新規登録</h2>
	</div>
	
	<div class="contents1">
		<form action="<%= request.getContextPath() %>/CreateUserServlet" method="POST">
			<table>
				<tr>
					<th>氏名:</th>
					<td><input type="text" name="name" placeholder="山田 太郎" required></td>
				</tr>
				<tr>
					<th>出生年:</th>
					<td><input type="text" name="birthyear" min="1900" max="2026" maxlength="4" pattern="[0-9]*" placeholder="2000" required></td>
				</tr>
				<tr>
					<th>住所:</th>
					<td><input type="text" name="address" required></td>
				</tr>
				<tr>
				<tr>
					<th>PW:</th>
					<td><input type="text" name="password" minlength="6" maxlength="10" pattern="[0-9a-zA-Z]*" placeholder="半角英数字6～10文字" required></td>
				</tr>
				<tr>
					<th>管理者権限:</th>
					<td><input type="checkbox" name="adminflg" value="1"></td>
				</tr>
			</table>
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