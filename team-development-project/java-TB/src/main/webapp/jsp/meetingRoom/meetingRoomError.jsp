<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室エラー</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%-- ログイン中のユーザー名表示 --%>
	<%@ include file="/jsp/includeFile/includeUserName.jsp"%>

	<%-- セッションゲット--%>
	<c:set var="page" value="${sessionScope.page}"/>
	<c:set var="room" value="${sessionScope.room}" />
	<c:set var="errorReason" value="${requestScope.errorReason}" />

	<div class="title1">
		<h1>会議室管理</h1>
	</div>

	<div class="hr">
		<hr>
	</div>

	<%--pageの入っている名前によって表示内容を変える --%>
	<div class="title2">
		<c:choose>
			<c:when test="${page == 'create'}">
			<h2>会議室登録エラー</h2>

			</c:when>

			<c:otherwise>
				<h2>会議室削除エラー</h2>
			</c:otherwise>

		</c:choose>
	</div>

	<div class="contents2">
		<p>
			<c:out value="${errorReason}" />
		</p>
	</div>


	<c:if test="${room != null}">
		<div class="room-reserve">
			<table>
				<tr>
					<th>会議室ID：</th>
					<td><c:out value="${room.id}" /></td>
				</tr>

				<tr>
					<th>会議室名：</th>
					<td><c:out value="${room.name}" /></td>
				</tr>

			</table>
		</div>
	</c:if>

	<div class="hr">
		<hr>
	</div>

	<div class="button1">
		<form action="<%=request.getContextPath()%>/jsp/menu.jsp"
			method="get">
			<input type="submit" value="確認">
		</form>
	</div>

</body>
</html>