package jp.co.seminar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String msg = request.getParameter("message");
		String tmp = request.getParameter("num");
		int num = Integer.parseInt(tmp);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		for (int i = 0; i < num; i++) {
			out.println(msg+"<br>");
		}
		out.println("</body></html>");
	}

}
