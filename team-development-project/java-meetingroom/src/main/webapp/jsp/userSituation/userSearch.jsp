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
	<c:set var="userList" value="${ex.userList}" />
	
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
	
	<div class="user-search">
		<form action="<%= request.getContextPath() %>/SearchUser" method="POST">
			<span>検索ID：</span>
			<input type="text" name="userId" value="${userId}" pattern="[0-9]*">
			<input type="hidden" name="flg" value="search">
			<input type="submit" value="検索">
		</form>
	</div>
			
	<c:if test="${flg == 'search'}">
		<div class="contents1">
			${result != null ? result : ""}
		</div>
	</c:if>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="contents2">
		<c:forEach var="users" items="${flg == 'search'? searchUser : userList}">
		
			<div class="input-user">
				<span class="user-name">ID：</span>
				<span class="user-data"><c:out value="${users.id}" /></span>
			</div>
			
			<div class="input-user">
				<span class="user-name">氏名：</span>
				<span class="user-data"><c:out value="${users.name}" /></span>
			</div>
			
			<div class="input-user">
				<span class="user-name">管理者権限：</span>
				<span class="user-data"><c:out value="${users.adminflg != null ? (users.adminflg == '1' ? 'あり' : 'なし') : ''}" /></span>
			</div>
			
			<div class="button3">
			
				<form action="<%= request.getContextPath() %>/SearchUser" method="POST">
					<input type="hidden" name="userId" value="${users.id}">
					<input type="hidden" name="flg" value="update">
					<button type="submit">変更</button>
				</form>
				
				<c:if test="${users.id != loginUser.id}">
					<form action="<%= request.getContextPath() %>/SearchUser" method="POST">
						<input type="hidden" name="userId" value="${users.id}">
						<input type="hidden" name="flg" value="delete">
						<button type="submit">削除</button>
					</form>
				</c:if>
				
			</div>
			
			<div class="hr">
				<hr>
			</div>
			
		</c:forEach>
		
		<div class="button3">
			<button type="button" onclick="location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">戻る</button>
		</div>
	</div>
	
</body>
</html>