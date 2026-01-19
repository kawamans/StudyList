<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室登録</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
	<body>
		<div class="title1">
			<h1>会議室登録</h1>
		</div>
		
		<div class="hr">
			<hr>
		</div>
		
		<div class="title2">
			<h2>会議室名登録</h2>
		</div>
			
			<div class="contents1">
			<form action="<%= request.getContextPath() %>/servlet/meetingRoom/CreateMeetingRoom.java" method="post">
				<div class="label">会議室名:</div> <input type="text" name="roomId"><br>
				<div class="label">階数:</div> <input type="text" name="floorNum"><br>
				<div class="label">部屋番号:</div> <input type="text" name="roomNum"><br>
				<hr>
				<div class="button1">
					<input type="submit" value="登録">
				</div>
			</form>
			</div>

	</body>
</html>
