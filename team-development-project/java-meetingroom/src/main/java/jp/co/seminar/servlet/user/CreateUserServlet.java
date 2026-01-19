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
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthYear = request.getParameter("birthyear");
		String address = request.getParameter("address");
		String adminflg = "0";
		if (request.getParameter("adminflg") != null) {
			adminflg = request.getParameter("adminflg");
		}
		String nextpage = "jsp/userSituation/";
		
		ExtraMR ex = new ExtraMR();
		UserBean userBean = ex.inputUser(password, name, birthYear, address,  adminflg);
		
		if(UserDao.checkPass(userBean)) {
			nextpage += "userConfirm.jsp";
		} else {
			nextpage += "userError.jsp";
			request.setAttribute("error", "このパスワードは使用されています。");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", userBean);
		session.setAttribute("page", "create");
		
		System.out.println(userBean.toString());
		
		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	
	}

}