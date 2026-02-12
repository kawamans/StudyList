<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2>ユーザー新規登録</h2>
	</div>
	
	<div class="room-admin">
		<form action="<%= request.getContextPath() %>/CreateUser" method="POST">
			<div class="input-user">
				<span class="user-name">氏名：</span>
				<input type="text" name="name" placeholder="インテックス太郎" maxlength="10" pattern=".*\S+.*" value="${user != null ? user.name : ''}" required>
			</div>

			<div class="input-user">
				<span class="user-name">出生年：</span>
				<input type="text" name="birthYear" maxlength="4" pattern="[0-9]{4}" placeholder="(西暦)1998" value="${user.birthYear != null ? user.birthYear : ''}" required>
			</div>

			<div class="input-user">
				<span class="user-name">住所：</span>
				<input type="text" name="address" pattern=".*\S+.*" maxlength="30" value="${user != null ? user.address : ''}" required>
			</div>

			<div class="input-user">
				<span class="user-name">PW：</span>
				<input type="text" name="password" minlength="6" maxlength="10" pattern="[0-9a-zA-Z]*" placeholder="半角英数字6～10文字" value="${user != null ? user.password : ''}" required>
			</div>

			<div class="input-user">
				<span class="user-name">管理者権限：</span>
				<input type="checkbox" name="adminflg" value="1" ${user.adminflg == '1' ? 'checked' : ''}>
			</div>

			<div class="hr">
				<hr>
			</div>

			<div class="button3">
				<button type="button" onclick="location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">戻る</button>
				<input type="submit" value="決定">
			</div>
		</form>
	</div>
</body>
</html>