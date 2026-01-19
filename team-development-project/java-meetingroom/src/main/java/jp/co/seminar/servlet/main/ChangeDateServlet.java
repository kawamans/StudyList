package jp.co.seminar.servlet.main;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;

/**
 * 利用日の変更する。
 * リクエストで受け取った利用日を会議室システムに設定し
 * 予約画面またはキャンセル画面に戻る。
 * 
 * @author 山﨑　恵士
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.MeetingRoom;



@WebServlet("/ChangeDate")
public class ChangeDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログイン画面へ遷移
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッション 取得(セッション切れの場合ログイン画面へ遷移させる)
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		//ミーテングルームビーン取得
		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");

		// リクエストパラメータ取得
		String date = request.getParameter("date");
		String page = request.getParameter("page");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//			if(date.equals(sdf)) {

		//値をセット
		meetingRoom.setDate(date);
        session.setAttribute("meetingRoom", meetingRoom);
//            
//			}else {
//				try {
//					//フォーマット違い時変換してセット
//					sdf.parse(date);
//					meetingRoom.setDate(date);
//		            session.setAttribute("meetingRoom", meetingRoom);
//				}catch (Exception e) {
//					e.printStackTrace();
//					e.getMessage();
//				}
//			}
			
		// 画面遷移
		if ("reserveInput.jsp".equals(page)) {
			request.getRequestDispatcher("/jsp/reservation/reserveInput.jsp")
					.forward(request, response);
		} else if ("cancelInput.jsp".equals(page)) {
			request.getRequestDispatcher("/jsp/cancel/cancelInput.jsp")
					.forward(request, response);
		} else {
			// 想定外の場合はログイン画面へ
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		}

	}

}

