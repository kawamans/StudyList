<%@ page contentType="text/html; charset=UTF-8" %>

<div class="login-user-name">
	
	<div class="header-logo">
		<img src="${pageContext.request.contextPath}/img/logo-top-ts.png" alt="ロゴ">
	</div>
	
	<div class="user-name2">
		<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
		ログインユーザー：<c:out value="${ sessionScope.loginUser.name }" />&nbsp;様<br>
		ユーザーID：<c:out value="${ sessionScope.loginUser.id }" />
	</div>
	
</div>