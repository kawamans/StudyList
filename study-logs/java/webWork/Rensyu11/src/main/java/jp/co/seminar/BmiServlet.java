package jp.co.seminar;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		try {
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			double expo = 2;
			double base = 10;
			double result = Math.pow(base, expo);
			double bmi = 0;
			
			if (height <= 0 || weight <= 0) {
				throw new Exception();
			}
			
			// N乗の数式の場合、bmi = Math.pow(height, 2);
			bmi = weight / (height * height);
			
			message = "BMI：" + Math.round(bmi*result)/result;
			
		} catch (ArithmeticException e) {
			message ="入力値を確認してください";
		} catch (NumberFormatException e) {
			message ="入力値を確認してください";
		} catch (Exception e) {
			message ="入力値を確認してください";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(message);
	}

}
