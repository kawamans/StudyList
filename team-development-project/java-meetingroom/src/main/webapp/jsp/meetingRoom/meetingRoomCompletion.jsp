<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室削除</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
	<%-- タイトル１ --%>
	<div class="title1">
		<h1>会議室削除</h1>
	</div>

	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>

	<%-- タイトル２ --%>
	<div class="title2">
		<h2>削除完了</h2>
	</div>

<%-- 日付をサーブレットから取得して表示させる用
	    Object dateObj = request.getAttribute("reservationDate");
	        Date reservationDate = (Date) dateObj;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	        String formattedDate = sdf.format(reservationDate);
	        <p>予約日: <%= formattedDate %></p>
	        <!-- またはinputタグのvalue属性に設定 -->
	        <input type="text" name="date" value="<%= formattedDate %>">
	 --%>
	
	<%-- コンテンツ --%>
	<div class="contents1">
		会議室名：大会議室<br>
		階数:3<br>
		部屋番号:C<br>
	</div>
 		
	<%-- hr --%>
	<div class="hr">
		<hr>
	</div>
	
	<%-- 戻るボタン --%>
		<div class="button1">
			<form action="<%= request.getContextPath() %>/jsp/menu.jsp" method="post">
				<input type="submit" value="戻る">
			</form>
		</div>

</body>
</html>