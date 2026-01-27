<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
	<body>
		
		<c:set var="meetingRoom" value="${ sessionScope.meetingRoom }" />
	
		<%
			if (session == null || session.getAttribute("loginUser") == null) {
	       		 
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/menu.jsp");
				rd.forward(request, response);
			}
		%>
		
		<%-- タイトル --%>
		<div class="title1">
			<h1>会議室予約</h1>
		</div>
		
		<div class="hr">
			<hr>
		</div>
		
		
		<div class="field1">
		
			<%-- 左側：ロゴ画像 --%>
			<div class="left-area">
				<img src="${pageContext.request.contextPath}/img/logo-top-ts.png" alt="ロゴ">
			</div>
			
			<%-- 右側：タイトル＋ログインフォーム --%>
			<div class="right-area">
				
				<%-- タイトル --%>
				<div class="title2-login">
				<h2>ログイン</h2>
				</div>
				<c:if test="${not empty message}">
    				<div class="error">
        			${message}
    				</div>
				</c:if>
			
				<%-- ログインフォーム --%>
				<div class="contents1-login">
					<form action="<%= request.getContextPath() %>/Login" method="post">
					<div class="contents1-label">利用者ID:</div> <input type="text" name="userId" value="${userId != null ? userId : ''}"><br>
					<div class="contents1-label">パスワード:</div> <input type="password" name="userPw"><br>
					<div class="button1">
						<input type="submit" value="ログイン">
					</div>
				</form>
				
			</div>
			</div>
		 </div>
	</body>
</html>