<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<c:set var="pageName" value="${sessionScope.page}" />
<c:choose> 
	<c:when test="${pageName == 'create'}">
		<c:set var="message" value="登録確認" />
	</c:when>
	<c:when test="${pageName == 'update'}">
		<c:set var="message" value="変更確認" />
	</c:when>
	<c:when test="${pageName == 'delete'}">
		<c:set var="message" value="削除確認" />
	</c:when>
	<c:otherwise>
		<c:set var="message" value="不明な操作です" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー確認画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
		
	<div class="title1">
		<h1>ユーザーメニュー</h1>
	</div>
	
	<div class="hr">
		<hr>
	</div>
	
	<div class="title2">
		<h2><c:out value="${message}" /></h2>
	</div>
	
	<c:if test="${error != null}">
		<div class="error">
			${error}
		</div>
	</c:if>
	
	<div class="contents1">
		<form action="<%= request.getContextPath() %>/CreateAddUserServlet" method="POST">
			<table>
				<tr>
					<th>氏名：</th>
					<td><c:out value="${user.name}" /></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${page == 'create'}">
							<th>出生年：</th>
							<td><c:out value="${user.birthYear} /></td>
						</c:when>
						<c:otherwise>
							<th>利用者ID：</th>
							<td><c:out value="${user.id} /></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<th>PW：</th>
					<td><c:out value="${user.password} /></td>
				</tr>
				<tr>
					<th>住所：</th>
					<td><c:out value="${user.address} /></td>
				</tr>
				<tr>
					<c:if test="${loginuser.adminflg == '1'}">
						<th>管理者権限：</th>
						<td${user.adminflg == "1" ? "あり" : "なし"}</td>
					</c:if>
				</tr>
			</table>
			<div class="hr">
				<hr>
			</div>
			<div class="button1">
				<input type="submit" value="確認">
			</div>
		</form>
	</div>
	
	<div class="button1">
		<form action="<%= request.getContextPath() %>/jsp/menu.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>