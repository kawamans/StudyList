package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.UserBean;
import jp.co.seminar.dao.UserDao;

/**
 * ユーザー情報を削除処理する
 * @author 山崎 恵士
 */

@WebServlet("/DeleteAddUser")
public class DeleteAddUserServlet extends HttpServlet {
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
				
			//パラメータを取得
			String userId = request.getParameter("userId");
			
			String nextpage = "jsp/userSituation/";
			
			//UserBeanの作成
			UserBean userBean = new UserBean();
			userBean.setId(userId);

			//オブジェクトの宣言
			ExtraMR ex = new ExtraMR();
					
			//ユーザー削除
			ex.logicalDeleteUser(userBean);
			
			if(UserDao.checkPass(userBean)) {
				nextpage += "userCompletion.jsp";
			} else {
				nextpage += "userError.jsp";
				request.setAttribute("error", "削除に失敗しました。");
			}						
					
			RequestDispatcher rd = request.getRequestDispatcher(nextpage);
			rd.forward(request, response);
		}

}
