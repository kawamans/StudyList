<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.MeetingRoom" %>
<!DOCTYPE html>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセルエラー</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	<%-- 会議室予約システムビーン 取得 --%>
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	<c:set var="reservation" value="${sessionScope.reservation}" />
	<c:set var="room" value="${sessionScope.room}" />
	<div class="title1">
		<h1>会議室予約キャンセル</h1>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="title2">
		<h2>キャンセルエラー</h2>
	</div>

		<%-- エラー内容 --%>
		<p><c:out value="${errorReason}" /></p>
	<div class="room-reserve">
	<table>
	<tr>
			<th>予約日：</th>
			<td><c:out value="${reserve.date}"/></td>
		</tr>
		<tr>
			<th>会議室：</th>
			<td><c:out value="${room.name}"/></td>
		</tr>
		<tr>
			<th>予約時刻：</th>
			<td><c:out value="${reserve.start}"/>～<c:out value="${reserve.end}"/></td>
		</tr>
		<tr>
			<th>予約者：</th>
			<td><c:out value="${meetingRoom.user.name}"/></td>
		</tr>
		</table>
	</div>

	<div class="hr">
		<hr>
	</div>

	<%-- 確認ボタン --%>
	<div class="button1">
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="post">
			<input type="submit" value="確認">
		</form>
	</div>

</body>
</html>