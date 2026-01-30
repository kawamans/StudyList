<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 問① SimpleDateFormatをimport -->

<!-- 問② Calendarをimport -->

<!-- 問③ headerのスタイルを指定 -->
<div style="ここを修正">
 <label style="ここを修正">
  login
 </label>
 <!-- 問④ 日付のスタイルを指定 -->
 <label style="ここを修正">
 <!-- 問⑤ 課題のフォーマットに合わせて日付を表示するように改修 -->
 <% Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("ここを修正");
    String formatDate = sdf.format("ここを修正");
    out.print("ここを修正");%>
 </label>
</div>

