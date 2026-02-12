package jp.co.seminar.servlet.main;

import java.io.IOException;

/**
 * ログアウト処理を行なう。
 * セッションを破棄し、ログイン画面にリダイレクトする。  
 * 
 * @author 山﨑　恵士
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストで受信した文字をUTF-8で受信する
		request.setCharacterEncoding("UTF-8");
		
		//セッションがなければnullを返す
		HttpSession session = request.getSession(false);
		
		//セッションを破棄
		if(session != null) {
			session.invalidate();
		}
	
		//ログイン画面へ遷移
		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
	}

}
