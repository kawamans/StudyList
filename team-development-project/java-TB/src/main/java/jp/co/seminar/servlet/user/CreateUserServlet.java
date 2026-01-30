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
 * ユーザー登録情報を生成する
 * @author 川満 達也
 */
@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		// sessionが無ければリダイレクト
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthYear = request.getParameter("birthYear");
		String address = request.getParameter("address");
		String adminflg = "0";
		if (request.getParameter("adminflg") != null) {
			adminflg = request.getParameter("adminflg");
		}
		String next = "userConfirm.jsp";
		
		ExtraMR ex = new ExtraMR();
		UserBean user = ex.inputUser(password, name, birthYear, address,  adminflg);
		
		// 新規登録利用者のパスワードをチェック
		if(!UserDao.checkPass(user)) {
			next = "userError.jsp";
			request.setAttribute("error", "このパスワードは使用されています。");
		}
		
		session.setAttribute("user", user);
		session.setAttribute("page", "create");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	
	}

}