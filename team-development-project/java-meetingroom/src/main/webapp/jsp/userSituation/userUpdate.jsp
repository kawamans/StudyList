<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録変更画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>

	<c:set var="ex" value="${sessionScope.ExtraMR}" />
	<c:set var="users" value="${loginUser}" />
	
	<c:if test="${not empty searchUser}">
		<c:set var="users" value="${searchUser}" />
	</c:if>
		
	<%@ include file="/jsp/includeFile/includeUserName.jsp" %>
	
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2>ユーザー情報変更</h2>
	</div>
	
	<c:if test="${error != null}">
		<div class="error">
			${error}
		</div>
	</c:if>
	
	${userId}
	
	<div class="contents2">
			
		<form action="<%= request.getContextPath() %>/UpdateUser" method="POST">
			<div class="input-user">
				<span class="user-name">ID：</span>
				<input type="text" name="id" value="${user != null ? user.id : users.id}" readonly required>
			</div>

			<div class="input-user">
				<span class="user-name">氏名：</span>
				<input type="text" name="name" placeholder="田中太郎" value="${user != null ? user.name : users.name}" required>
			</div>
			
			<div class="input-user">
				<span class="user-name">住所：</span>
				<input type="text" name="address" value="${user != null ? user.address : users.address}" required>
			</div>

			<div class="input-user">
				<span class="user-name">PW：</span>
				<input type="text" name="password" minlength="6" maxlength="10" pattern="[0-9a-zA-Z]*" placeholder="半角英数字6～10文字" value="${user != null ? user.password : users.password}" required>
			</div>
			
			<c:if test="${loginUser.adminflg == '1'}">
				<div class="input-user">
					<span class="user-name">管理者権限：</span>
					<input type="checkbox" name="adminflg" value="1" ${(user != null ? user.adminflg : users.adminflg) == "1" ? "checked" : ""}>
				</div>
			</c:if>
			
			<div class="hr">
				<hr>
			</div>

			<div class="button3">
				<c:if test="${userId == null || empty userId}">
					<button type="button" onclick="location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">戻る</button>
				</c:if>
				
				<c:if test="${userId != null || not empty userId}">
					<button type="button" onclick="location.href='<%= request.getContextPath() %>/jsp/userSituation/userSearch.jsp'">戻る</button>
				</c:if>
				
				<input type="submit" value="決定">
			</div>
		</form>
				
	</div>
</body>
</html>