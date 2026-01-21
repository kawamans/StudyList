<%@ page contentType="text/html; charset=UTF-8" %>

<div class="login-user-name">
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	ログインユーザー：<c:out value="${ meetingRoom.user.name }" />&nbsp;様
</div>