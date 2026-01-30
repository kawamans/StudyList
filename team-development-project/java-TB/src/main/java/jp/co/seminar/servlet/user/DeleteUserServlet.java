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
import jp.co.seminar.bean.LoginUserBean;
import jp.co.seminar.bean.UserBean;

/**
 * ユーザー削除情報生成する
 * @author 川満
 */

@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		// sessionが無ければリダイレクト
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		
		String next = "error.jsp";
		
		try {
			String id = request.getParameter("id");
			ExtraMR ex = (ExtraMR)session.getAttribute("ExtraMR");
			LoginUserBean loginUser = (LoginUserBean)session.getAttribute("loginUser");
			
			// ログイン者本人は削除できないようにブロック
			if (loginUser.getId().equals(id) && id != null) {
				
				next = "userDelete.jsp";
				request.setAttribute("error", "ログイン利用者本人は削除できません。");
				request.setAttribute("userId", id);
				
			} else {
			
				String password = request.getParameter("password");
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String adminflg = request.getParameter("adminflg");
				
				UserBean user = ex.instanceUser(id, password, name, address, adminflg, "select");
					
				next = "userConfirm.jsp";
				
				session.setAttribute("user", user);
				session.setAttribute("page", "delete");
			
			}
		} catch (NullPointerException e) {
			request.setAttribute("error", "不正な操作です。");
			System.out.println(e);
		} catch (Exception e) {
			request.setAttribute("error", "不明なエラーです。");
			System.out.println(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}
}
