package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //受信データの取得
        String tmp = request.getParameter("len");
        double len = Double.parseDouble(tmp);
        Double circle = len * len * 3.14;
        Double square = len * len;
        //計算結果をリクエスト属性に格納
        request.setAttribute("circle", circle);
        request.setAttribute("square", square); 
        String nextPage = "/output.jsp";
        //結果表示ページに遷移
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
