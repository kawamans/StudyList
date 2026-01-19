<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>キャンセル確認</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	<div class = title1>
		<h1>会議室予約キャンセル</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class = title2>
		<h2>キャンセル確認</h2>
	</div>
	
	<div class = contents1>
		<p>予約日 <c:out value="${reservation.date}" /></p>
		<p>会議室 <c:out value="${room.name}"/></p>
		<p>予約時刻 <c:out value =" ${reservation.start}"/>～<c:out value = "${reservation.end}"/></p>
		<p>予約者 <c:out value =" ${meetingRoom.user.name }"/> </p>
	</div>
	
	<div>
		<hr>
	</div>
	
	<div class = button3>
		<form action="<%=request.getContextPath()%>/jsp/cancel/cancelInput.jsp" method="post">
			<input type = submit value ="戻る" >
		</form>
			
		<form action="<%=request.getContextPath()%>/Cancel" method="post">
			<input type = submit value="決定">
	</form>
	</div>
	
</body>
</html>