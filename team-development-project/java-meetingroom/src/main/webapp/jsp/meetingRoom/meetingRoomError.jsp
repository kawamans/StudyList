<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室削除エラー</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>

<%-- セッションとリクエストゲット --%>

	
	<div class="title1">
		<h1>会議室削除</h1>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="title2">
		<h2>会議室削除エラー</h2>
	</div>

	
	
	<p></p>
	<div class="contents1">
		会議室名：大会議室<br>
		階数:3<br>
		部屋番号:C<br>
	</div>
 		
	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>
	
	<%-- 確認ボタン --%>
		<div class="button1">
			<form action="<%= request.getContextPath() %>/jsp/meetingRoom/meetingRoomDelete.jsp" method="post">
				<input type="submit" value="確認">
			</form>
		</div>

</body>
</html>