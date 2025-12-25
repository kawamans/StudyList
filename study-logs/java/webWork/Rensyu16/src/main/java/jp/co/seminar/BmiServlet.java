package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message = "";
		String nextPage = "/error.jsp";
		
		try {
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			
			if (height <= 0 || weight <= 0) {
				throw new Exception();
			}
			
			Bmi bmi = new Bmi(height, weight);
			bmi.bmiKeisan();
			double result = bmi.result();
			message = bmi.bmiAnswer(result);
			nextPage = "/output.jsp";
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
	}

}
