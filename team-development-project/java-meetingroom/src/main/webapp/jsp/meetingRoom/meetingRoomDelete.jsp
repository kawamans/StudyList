<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>会議室削除</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
	<%--必要なセッションをゲット --%>
	<c:set var="extramr" value="${sessionScope.ExtraMR}"/>
	<c:set var="mr" value="${sessionScope.meetingRoom }"/>
	<c:set var="rooms" value="${mr.rooms }"/>
	
	<div class="title1">
		<h1>会議室削除</h1>
	</div>
	
	<div class="hr">
		<hr />
	</div>
	

	<div class="contents1">
		<form action="<%=request.getContextPath()%>/DeleteAddMeetingRoom" method="post">
			<div class="room-item">
				<span class="room-name">
				
				<c:forEach var="t" items="${rooms}">
				<c:out value="${t.id}"/>
				<c:out value="${t.name}"/>
				<button type="submit" name="roomId" value="${t.id}">
					削除</button><br>
				</c:forEach>				
			</div>
			
		</form>
	</div>

	<div class="hr">
		<hr />
	</div>
	<div class="button1">
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="get">
			<input type="submit" value="戻る" />
		</form>
	</div>
</body>
</html>
