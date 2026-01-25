<%@ page contentType="text/html; charset=UTF-8" %>

<div class="login-user-name">
	<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	ログインユーザー：<c:out value="${ sessionScope.loginUser.name }" />&nbsp;様<br>
	ユーザーID：<c:out value="${ sessionScope.loginUser.id }" />
</div>