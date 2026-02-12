package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckZipCodeServlet")
public class CheckZipCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nextPage = "/input.jsp";
		String err = "入力エラー";
		
		try {
			String tmp = request.getParameter("zipcode");
			
			if (tmp != null && tmp.matches("^[0-9]{7}$")) {
				String firstPart = tmp.substring(0,3);
				String endPart = tmp.substring(3);
				String zipcode = firstPart + "-" + endPart;
				err = "";
				request.setAttribute("zipcode", zipcode);
				nextPage = "/output.jsp";
			}
			
		} catch (NumberFormatException e) {
			
		} catch (Exception e) {
			
		}
		
		request.setAttribute("err", err);
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
	}

}
