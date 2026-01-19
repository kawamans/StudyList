package jp.co.seminar.servlet.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException;
import jp.co.seminar.bean.MeetingRoom;
import jp.co.seminar.bean.ReservationBean;

@WebServlet("/Cancel")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 予約を削除する。
	 * キャンセル成功時は予約キャンセル完了画面に遷移し，
	 * 例外を捕捉した場合は，例外メッセージをリクエスト属性にセットして
	 * 予約エラー画面に遷移する
	 * @author 飯田一心
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		try {
			//セッションがない場合ログインしなおし
			if (session == null) {
				throw new Exception("セッションが無効です。再ログインしてください。");
			}

			//meetingroomを取得する
			MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");

			if (meetingRoom == null) {
				throw new Exception("meetingRoom が取得できません。再ログインしてください。");
			}

			//reservationを取得
			ReservationBean reservation = (ReservationBean) session.getAttribute("reservation");
			if (reservation == null) {
				throw new Exception("取消対象の予約情報が取得できません。");
			}

			//meetingroom側で予約キャンセル失敗で例外が来る想定
			meetingRoom.cancel(reservation);
			//成功で完了画面へ遷移
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/cancel/canceled.jsp");
			rd.forward(request, response);
			return;

		} catch (AppException.TimePassedException e) {

			
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		} catch (AppException.UnauthorizedCancelException e) {

			
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		} catch (AppException.CancelFailedException e) {

			
			request.setAttribute("errorReason", e.getMessage());
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		} catch (Exception e) {

			
			request.setAttribute("errorReason", "キャンセル処理に失敗しました。");
			request.getRequestDispatcher("/jsp/cancel/cancelError.jsp")
					.forward(request, response);
			return;

		}

	}

}
