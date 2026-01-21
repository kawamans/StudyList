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

	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
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
	
	<%-- エラーメッセージ --%>
	<p><c:out value="${errorReason}" /></p>
	
	<%-- エラー内容 --%>
	<c:if test="${not empty reserve}">
		<div class="room-reserve">
			<table>
			<tr>
				<th>予約日：</th>
				<td><c:out value="${reserve.date}" /></td>
			</tr>
			<tr>
				<th>会議室：</th>
				<td><c:out value="${room.name}" /></td>
			</tr>
			<tr>
				<th>予約時刻：</th>
				<td><c:out value="${reserve.start}～${reserve.end}" /></td>
			</tr>
			<tr>
				<th>予約者：</th>
				<td><c:out value="${meetingRoom.user.name}" /></td>
			</tr>
			</table>
		</div>
	</c:if>
	
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