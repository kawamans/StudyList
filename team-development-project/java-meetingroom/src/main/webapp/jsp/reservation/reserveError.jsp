<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.MeetingRoom" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="UTF-8">
<title>会議室予約エラー</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	<%-- 会議室予約システムビーン 取得 --%>
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	<c:set var="reservation" value="${ meetingRoom.reservations }" />

	<%-- h2 --%>
	<div class="title1">
		<h1>会議室予約</h1>
	</div>
	
	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>
	
	<%-- h1 --%>
	<div class="title2">
		<h2>予約エラー</h2>
	</div>
	
	<%-- エラー内容 --%>
	<div class="contents1">
	<table>
	<tr>
		<th><c:out value="${errorReason}" /></th>
	</tr>
	<tr>
		<td>予約日：</td>
		<td><c:out value="${reservations.date}" /></td>
	</tr>
	<tr>
		<td>会議室：</td>
		<td><c:out value="${room.name}" /></td>
	</tr>
	<tr>
		<td>予約時刻：</td>
		<td><c:out value="${reservations.start}～${reservations.end}" /></td>
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
	
	<%-- 確認ボタン --%>
	<div class="button1">
		<form action="<%= request.getContextPath() %>/jsp/menu.jsp" method="get">
			<input type="submit" value="確認">
		</form>
	</div>


</body>
</html>