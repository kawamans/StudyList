<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.MeetingRoom" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約完了画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	<%-- 会議室予約システムビーン 取得 --%>
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />

	<%-- タイトル１ --%>
	<div class="title1">
		<h1>会議室予約</h1>
	</div>

	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>

	<%-- タイトル２ --%>
	<div class="title2">
		<h2>予約完了</h2>
	</div>

	<%-- コンテンツ --%>
	<div class="contents1">
	<table>
	<tr>予約ID：</tr>
	<tr><c:out value="${reservation.id}" /></tr>
	<tr>予約日：</tr>
	<tr><c:out value="${reservation.date}" /></tr>
	<tr>会議室：</tr>
	<tr><c:out value="${room.name}" /></tr>
	<tr>予約時刻：</tr>
	<tr><c:out value="${reservation.start}～${reservation.end}" /></tr>
	<tr>予約者：</tr>
	<tr><c:out value="${meetingRoom.user.name}" /></tr>
	</table>
	</div>
 		
	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>
	
	<%-- 完了ボタン --%>
		<div class="button1">
			<form action="<%= request.getContextPath() %>/jsp/userSituation/menu.jsp" method="post">
				<input type="submit" value="完了">
			</form>
		</div>

</body>
</html>