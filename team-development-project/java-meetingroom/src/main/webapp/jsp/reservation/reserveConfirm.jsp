<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.MeetingRoom" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認画面</title>
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
		<h2>予約確認</h2>
	</div>

	<%-- コンテンツ --%>
	<div class="contents1">
	<table>
	<tr>
		<td>予約日：</td>
		<td><c:out value="${reservation.date}" /></td>
	</tr>
	<tr>
		<td>会議室：</td>
		<td><c:out value="${room.name}" /></td>
	<tr>
		<td>予約時刻：</td>
		<td><c:out value="${reservation.start}～${reservation.end}" /></td>
	</tr>
	<tr>
		<td>予約者：</td>
		<td><c:out value="${meetingRoom.user.name}" /></td>
	</tr>
	</table>
	</div>
	
	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>
	
	<%-- 戻るボタン --%>
		<div class="button3">
			<form action="<%= request.getContextPath() %>/jsp/reservation/reserveInput.jsp"
				method="post">
				<input type="submit" value="戻る">
			</form>
		
	<%-- 決定ボタン --%>
			<form action="<%= request.getContextPath() %>/Reserve"
				method="post">
				<input type="submit" value="決定"><br>
			</form>
		</div>

</body>
</html>