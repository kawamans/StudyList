package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.UserBean;

/**
 * ユーザー削除情報生成する
>>>>>>> 9c39472444fa9ef4bfc7891a56dea101924173e2
 * @author 山崎 恵士
 */

@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//未ログイン時、ログイン画面へリダイレクト
    	HttpSession session = request.getSession(false);

    	if (session == null || session.getAttribute("loginUser") == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    	}
	}

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//パラメータを取得
			String userId = request.getParameter("userId");
			
			//ユーザー情報を取得
			UserBean userBean = new UserBean();
			userBean.setId(userId);
			
			//リクエストにセット
			request.setAttribute("delete", userBean);
			
			//確認画面へ
			request.getRequestDispatcher("/jsp/userSituation/userConfirm.jsp").forward(request, response);
			
			}catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/jsp/userSituation/userError.jsp").forward(request, response);
			}
		}	
		
}
