<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
	<body>
		<div class="title1">
			<h1>会議室予約</h1>
		</div>

		<div class="hr">
			<hr>
		</div>

		<div class="title2">
			<h2>メニュー</h2>
		</div>


		<div class="button2">
			<form
				action="<%=request.getContextPath()%>/jsp/reservation/reserveInput.jsp"
				method="post">
				<input type="submit" value="会場予約">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/cancel/cancelInput.jsp"
				method="post">
				<input type="submit" value="予約キャンセル">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userUpdate.jsp"
				method="post">
				<input type="submit" value="登録情報変更">
			</form>

			<form
				action="<%=request.getContextPath()%>/Logout"
				method="post">
				<input type="submit" value="ログアウト">
			</form>
		</div>

		<%	
			//セッションからuserAdwminFlgを取得
			String adminFlg = (String) session.getAttribute("adminFlg");
			//"1"かどうかを判定
   			if ("1".equals(adminFlg)) {
			// 管理者の処理
		%>
		
		<div class="button2">

			<form
				action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomConfirm.jsp"
				method="post">
				<input type="submit" value="会議室登録">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/meetingRoom/meetingRoomDelete.jsp"
				method="post">
				<input type="submit" value="会議室削除">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userCreate.jsp"
				method="post">
				<input type="submit" value="ユーザー新規登録">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userUpdate.jsp"
				method="post">
				<input type="submit" value="ユーザー変更">
			</form>

			<form
				action="<%=request.getContextPath()%>/jsp/userSituation/userDelete.jsp"
				method="post">
				<input type="submit" value="ユーザー削除">
			</form>
		</div>

		<%
			} else {
			// 利用者の処理
			}
		%>

	</body>
</html>