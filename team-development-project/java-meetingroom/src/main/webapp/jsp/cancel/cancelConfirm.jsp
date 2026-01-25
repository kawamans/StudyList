<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.seminar.bean.MeetingRoom" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>キャンセル確認画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
<%-- 会議室予約システムビーン 取得 --%>
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	<div class="title1">
		<h1>会議室予約キャンセル</h1>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="title2">
		<h2>キャンセル確認</h2>
	</div>
	
	<div class="room-reserve">
		<table>
		<tr>
			<th>予約日</th>
			<td><c:out value="${reserve.date}" /></td>
		</tr>
		<tr>
			<th>会議室</th>
			<td><c:out value="${room.name}"/></td>
		</tr>
		<tr>
			<th>予約時刻</th>
			<td><c:out value="${reserve.start}"/>～<c:out value="${reserve.end}"/></td>
		</tr>
		<tr>
			<th>予約者</th>
			<td><c:out value="${meetingRoom.user.name}"/> </td>
		</tr>
		</table>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<%-- 戻るボタン --%>
	<div class="button3">
		<form action="<%=request.getContextPath()%>/jsp/cancel/cancelInput.jsp" method="post">
			<input type="submit" value="戻る">
		</form>

		<form action="<%=request.getContextPath()%>/Cancel" method="post">
			<input type="submit" value="決定">
		</form>
	</div>
	
</body>
</html>