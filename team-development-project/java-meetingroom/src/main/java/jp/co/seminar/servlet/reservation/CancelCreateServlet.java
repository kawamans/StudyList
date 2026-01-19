package jp.co.seminar.servlet.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.MeetingRoom;
import jp.co.seminar.bean.ReservationBean;
import jp.co.seminar.bean.RoomBean;

@WebServlet("/CancelCreate")
public class CancelCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String roomId = request.getParameter("roomId");
		String time = request.getParameter("time");
		
		HttpSession session = request.getSession();

		// meetingRoom確認
		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");
		if (meetingRoom == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		    return;
		}

		
		try {
				//meetingRoomBeanの予約生成メソッドを使用して部屋番号、開始時刻取得
				ReservationBean reservation = meetingRoom.createReservation(roomId,time);
				RoomBean room = meetingRoom.getRoom(roomId);
				//取り消す予約と会議室をセット
		
				session.setAttribute("reservation", reservation);
				session.setAttribute("room", room);
		
		request.getRequestDispatcher("/jsp/cancel/cancelConfirm.jsp")
				.forward(request, response);
	}catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("errorReason",  e.getMessage());
		request.getRequestDispatcher("/jsp/reservation/cancelError.jsp")
				.forward(request, response);
		return;
	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインしていない場合、ログイン画面にリダイレクト
		HttpSession session = request.getSession(false); 
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() +"/jsp/login.jsp");
		return; 
        }
	}
}
