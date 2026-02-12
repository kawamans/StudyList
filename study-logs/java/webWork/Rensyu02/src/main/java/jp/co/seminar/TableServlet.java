package jp.co.seminar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Company Directory</title>");
		out.println("</head><body>");
		
		out.println("<table border = \"1\"");
		out.println("<tr><th>名前</th><th>部署</th></tr>");
		out.println("<tr><td>田中 太郎</td><td>営業部</td></tr>");
		out.println("<tr><td>山田 花子</td><td>営業部</td></tr>");
		out.println("<tr><td>佐藤 二郎</td><td>総務部</td></tr>");
		out.println("</table>");
		
		out.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}