package jp.co.seminar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello5Servlet")
public class Hello5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<title>Say Hello</title>");
		out.println("</head><body>");
		
		for (int i = 0; i < 5; i++) {
			out.print("<p>こんにちは！世界！</p>");
		}
		
		out.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}