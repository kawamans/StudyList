<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
	<body>
		<div class="title1">
			<h1>会議室予約</h1>
		</div>
		
		<div class="hr">
			<hr>
		</div>
			
		<div class="title2">
			<h2>ログイン</h2>
		</div>
			
			<div class="contents1">
				<form action="<%= request.getContextPath() %>/Login" method="post">
				<div class="label">利用者ID:</div> <input type="text" name="userId"><br>
				<div class="label">パスワード:</div> <input type="password" name="userPw"><br>
				<div class="button1">
					<input type="submit" value="ログイン">
				</div>
			</form>
			</div>

	</body>
</html>