package jp.co.seminar.servlet.main;

import java.io.IOException;

/**
 * ログイン処理を行う。
 * 利用者認証を行い、認証成功時は利用者を
 * セッション属性にセットしｍニュー画面に遷移する。
 * 失敗時はログイン画面に戻る。
 * @author 山﨑　恵士
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.LoginUserBean;
import jp.co.seminar.bean.MeetingRoom;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログイン画面へリダイレクト
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストで受信した文字をUTF-8で受信する
		request.setCharacterEncoding("UTF-8");
		
		//セッションを取得
		HttpSession session = request.getSession();
		
		//セッションタイムアウトを設定
		session.setMaxInactiveInterval(60 * 60);
				
		// 会議室管理システムオブジェクト生成
        MeetingRoom meetingRoom = new MeetingRoom(); 
        ExtraMR ex = new ExtraMR();
        		
        //ログイン情報を取得
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        //判定
		if ( meetingRoom.login(userId, userPw)) {
			
			LoginUserBean loginUser = meetingRoom.getUser();
						
				//ログイン者情報をセッションに格納
				session.setAttribute("loginUser", loginUser);
								
				// セッション属性にセット
		        session.setAttribute("meetingRoom", meetingRoom);
		        session.setAttribute("ExtraMR", ex );
		        
				//ログイン成功
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/menu.jsp");
				rd.forward(request, response);

			} else {
				//ログイン失敗
				request.setAttribute("message", "エラーメッセージ：ログインに失敗しました。");
				request.setAttribute("userId", userId);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request, response);
				

			}
			
	
	}

}
