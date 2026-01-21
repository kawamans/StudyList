<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jp.co.seminar.bean.RoomBean"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室登録</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp"%>

	<div class="title1">
		<h1>会議室登録</h1>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="title2">
		<h2>会議室名登録</h2>
	</div>

	<div class="contents1">
		<form action="<%=request.getContextPath()%>/CreateAdd" method="post">
			<div class="input-user">
			<span class="user-name">会議室名:</span>
			<span class="user-data"><input type="text" name="roomId" required></span><br>
			</div>
			<div class="input-user">
			<span class="user-name">階数:</span>
			<span class="user-data"><input type="text" name="floorNum" required></span><br>
			</div>
			<div class="input-user">
			<span class="user-name">部屋番号:</span>
			<span class="user-data"><input type="text" name="roomNum" required></span><br>
			</div>
			<hr>
			<div class="button1">
				<input type="submit" value="登録">
				
			</div>
		</form>
		<div class="button1">
			<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="post">
			<input type=submit value="戻る"></form>
			</div>
	</div>

</body>
</html>
