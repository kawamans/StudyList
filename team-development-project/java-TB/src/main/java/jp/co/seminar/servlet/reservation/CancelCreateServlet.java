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

@WebServlet("/CancelCreate")
public class CancelCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * キャンセルしたい予約を作成する。
	 * リクエストで受け取った会議室ID、
	 * 開始時刻を元に会議室予約システムによりキャンセル情報を生成する。
	 * 後続する処理に備えてキャンセルする予約及び会議室をセッション属性にセットし、
	 * キャンセル確認画面に遷移する。
	 * @author 飯田一心
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String roomId = request.getParameter("roomId");
		String start = request.getParameter("time");
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}

		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");
		
		
		
		try {
				//meetingRoomBeanの予約生成メソッドを使用して予約、会議室beanを取得
				ReservationBean reservation = meetingRoom.createReservation(roomId,start);
				RoomBean room = meetingRoom.getRoom(roomId);
				
				//取り消す予約と会議室をセット
				session.setAttribute("reserve", reservation);
				session.setAttribute("room", room);
		
				response.sendRedirect(request.getContextPath() +
						"/jsp/cancel/cancelConfirm.jsp");
				
	}catch (AppException.ReservationFailedException e){
		e.printStackTrace();
		request.setAttribute("errorReason",  e.getMessage());
		request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
				.forward(request, response);
		return;
	
	}catch (AppException.UnauthorizedCancelException e) {
		request.setAttribute("errorReason", e.getMessage());
		request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
				.forward(request, response);
		return;

	} catch (AppException.CancelFailedException e) {
		request.setAttribute("errorReason", e.getMessage());
		request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
				.forward(request, response);
		return;
		
	} catch (NullPointerException e) {
		request.setAttribute("errorReason","バックキーを使わず、戻るボタンを使用してください" );
		request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
				.forward(request, response);
		return;
		
	}catch (Exception e) {
		request.setAttribute("errorReason", "キャンセル処理に失敗しました。");
		request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
				.forward(request, response);
		return;

	} 
	}

	
	}

