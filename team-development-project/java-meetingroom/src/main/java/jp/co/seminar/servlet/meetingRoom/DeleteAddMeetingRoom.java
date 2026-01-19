package jp.co.seminar.servlet.meetingRoom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException;
import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.MeetingRoom;
import jp.co.seminar.bean.RoomBean;


/**
 * 削除したい会議室を生成する。
 * @author 谷田　将平
 */

@WebServlet("/DeleteAddMeetingRoom")
public class DeleteAddMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//roomId JSPから取得
		String roomId = request.getParameter("roomId");

		//セッション 取得(セッション切れの場合ログイン画面へ遷移させる)
		HttpSession session = request.getSession();
		if(session == null){
			response.sendRedirect(request.getContextPath() + "jsp/login.jsp");
			return;
		}

		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");
		ExtraMR extramr = (ExtraMR)session.getAttribute("ExtraMR");

		try{
			//meetingRoomBeanの会議室IDを取得
			RoomBean room = meetingRoom.getRoom(roomId);
			
			//sessionへ変数を保存
			session.setAttribute("room", room);
			session.setAttribute("ExtraMR", extramr);
			//フォワードでの遷移処理
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomConfirm.jsp")
				.forward(request, response);
			//対象の会議室が存在しない場合
		}catch(AppException.NonExistentRoomException e){
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp")
			.forward(request, response);
			
			//会議室削除に失敗した場合
		}catch(AppException.DeleteRoomFailedException e){
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp")
			.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/meetingRoom/meetingRoomError.jsp")
			.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインしていない場合、ログイン画面にリダイレクト
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedInUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
	}
}
