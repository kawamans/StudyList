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
	
	<c:if test="${loginUser.adminflg == '1'}">
		<div class="user-search">
			<form action="<%= request.getContextPath() %>/UpdateUser" method="POST">
				<span>検索ID:</span>
				<input type="text" name="userId" pattern="[0-9]*">
				<input type="hidden" name="flg" value="search">
				<input type="submit" value="検索">
			</form>
		</div>
		
		<div class="hr">
			<hr>
		</div>
	</c:if>
	
	<c:if test="${flg == 'search'}">
		<div class="contents1">
			検索した利用者を表示します。
		</div>
	</c:if>
	
	<c:if test="${flg == null}">
		<c:set var="flg" value="noSearch" />
	</c:if>
	
	<div class="contents1">
		<form action="<%= request.getContextPath() %>/UpdateUser" method="POST">
			<div class="input-user">
				<span class="user-name">氏名:</span>
				<input type="text" name="name" placeholder="田中太郎" value="${flg == 'search' ? user.name : loginUser.name}" required>
			</div>

			<div class="input-user">
				<span class="user-name">ID:</span>
				<input type="text" name="id" value="${flg == 'search' ? user.id : loginUser.id}" readonly required>
			</div>
			
			<div class="input-user">
				<span class="user-name">住所:</span>
				<input type="text" name="address" value="${flg == 'search' ? user.address : loginUser.address}" required>
			</div>

			<div class="input-user">
				<span class="user-name">PW:</span>
				<input type="text" name="password" minlength="6" maxlength="10" pattern="[0-9a-zA-Z]*" placeholder="半角英数字6～10文字" value="${flg == 'search' ? user.password : loginUser.password}" required>
			</div>
			
			<c:if test="${loginUser.adminflg == '1'}">
				<div class="input-user">
					<span class="user-name">管理者権限:</span>
					<input type="checkbox" name="admin" value="1" ${(flg == "search" ? user.adminflg : loginUser.adminflg) == "1" ? "checked" : ""}>
				</div>
			</c:if>
			
			<input type="hidden" name="flg" value="input">
			
			<div class="button1">
				<input type="submit" value="決定">
			</div>
		</form>
	</div>

	<div class="hr">
		<hr>
	</div>

	<div class="button1">
		<form action="<%= request.getContextPath() %>/jsp/menu.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>

</body>
</html>