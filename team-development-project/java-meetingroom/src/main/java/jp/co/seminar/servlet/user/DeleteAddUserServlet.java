package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.ExtraMR;

/**
 * ユーザー情報を削除処理する
 * @author 山崎 恵士
 */

@WebServlet("/DeleteAddUserServlet")
public class DeleteAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//パラメータを取得
		String userId = request.getParameter("userId");

		//オブジェクトの宣言
		ExtraMR ex = new ExtraMR();
		
		boolean isLogin = (userId != null && userId.equals(ex.getUser().getId()));
		
		HttpSession session = request.getSession();
	    session.setAttribute("isLogin", isLogin);
	    
	    if (isLogin) {
	        request.setAttribute("userId", userId);
	        request.getRequestDispatcher("/jsp/menu.jsp").forward(request, response);
	    } else {
	        request.setAttribute("error", "IDが違います。");
	        request.getRequestDispatcher("/jsp/userError.jsp").forward(request, response);
	    }
	}

}
