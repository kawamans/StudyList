package jp.co.seminar.servlet.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException;
import jp.co.seminar.bean.MeetingRoom;
import jp.co.seminar.bean.ReservationBean;
import jp.co.seminar.bean.RoomBean;

/**
 * 予約を生成する。
 * @author 石坂迪大
 */

@WebServlet("/ReserveCreate")
public class ReserveCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//roomId,time JSPから取得
		String roomId = request.getParameter("roomId");
		String start = request.getParameter("time");

		//セッション 取得(セッション切れの場合ログイン画面へ遷移させる)
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		//ミーティングルームビーンを実装
		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");

		try {
			//meetingRoomのメソッドを使用して予約ビーンと会議室ビーン取得
			ReservationBean reservation = meetingRoom.createReservation(roomId, start);
			RoomBean room = meetingRoom.getRoom(roomId);

			//会議室予約情報をセット
			session.setAttribute("reserve", reservation);
			session.setAttribute("room", room);
			
			//予約確認jspへリダイレクト
			response.sendRedirect(request.getContextPath() +
					"/jsp/reservation/reserveConfirm.jsp");
			
		//生成失敗時
		} catch (AppException.ReservationFailedException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
					.forward(request, response);
			return;
		
		//既に予約されている場合の例外
		}catch (AppException.AlreadyReservedException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
					.forward(request, response);
			return;
		
		//予約時間が過ぎている場合の例外
		}catch (AppException.TimePassedException e) {
			e.printStackTrace();
			request.setAttribute("errorReason",  e.getMessage());
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
					.forward(request, response);
			return;
		
		//その他の例外処理
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorReason",  e.getMessage());
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
					.forward(request, response);
			return;
		}
	}

	

}