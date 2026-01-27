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

/**
 * 予約を登録する。
 * @author 石坂迪大
 */

@WebServlet("/Reserve")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッション 取得(セッション切れの場合ログイン画面へ遷移させる)
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		//予約情報管理Bean 取得
		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");
		ReservationBean reservation = (ReservationBean) session.getAttribute("reserve");
		
		//予約 登録
		try {
			//登録処理
			meetingRoom.reserve(reservation);
			//登録成功時
			response.sendRedirect(request.getContextPath() +
									"/jsp/reservation/reserved.jsp");
				return;
				
		//登録に失敗した場合の例外
		} catch (AppException.ReservationFailedException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
			.forward(request, response);
			return;
			
		//予約時間が過ぎている場合の例外
		}catch (AppException.TimePassedException e) {
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
		
		//ヌルポ対策
		}catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("errorReason", "戻るボタンを使用してください。");
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
			.forward(request, response);
			return;
		
		//その他例外
		}catch (Exception e) {
			request.setAttribute("errorReason", "会議室予約処理に失敗しました。");
			request.getRequestDispatcher("/jsp/reservation/reserveError.jsp")
					.forward(request, response);
			return;
		}
	}
}
