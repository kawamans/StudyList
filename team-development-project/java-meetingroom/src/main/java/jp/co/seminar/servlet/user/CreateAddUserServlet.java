package jp.co.seminar.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.bean.AppException.AlreadyRegisteredUserException;
import jp.co.seminar.bean.AppException.InsertUserFailedException;
import jp.co.seminar.bean.ExtraMR;
import jp.co.seminar.bean.UserBean;

/**
 * ユーザー情報を登録処理する 
 * @author 川満 達也
 */
@WebServlet("/CreateAddUser")
public class CreateAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || (session.getAttribute("user") == null && session.getAttribute("loginUser") == null)) {
			response.sendRedirect(request.getContextPath()+"jsp/login.jsp");
			return;
		}
		
		
		String next = "userError.jsp";
		
		ExtraMR ex = new ExtraMR();
		UserBean user = (UserBean)session.getAttribute("user");
		
		try {
			ex.createUser(user);
			user = ex.getUser();
			next = "userCompletion.jsp";
			
		} catch(AlreadyRegisteredUserException e) {
			request.setAttribute("error", "このパスワードは使用されています。");
			System.out.println(e);
		} catch(InsertUserFailedException e) {
			request.setAttribute("error", "登録に失敗しました。");
			System.out.println(e);
		} catch(Exception e) {
			request.setAttribute("error", "処理に失敗しました。");
			System.out.println(e);
		}
		
		
		session.setAttribute("user", user);
		session.setAttribute("page", "create");
		
		System.out.println(user.toString());
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/userSituation/" + next);
		rd.forward(request, response);
	}

}
