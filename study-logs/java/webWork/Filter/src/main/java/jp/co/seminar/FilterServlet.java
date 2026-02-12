package jp.co.seminar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ログ出力:サーブレット:doGet:開始");
        //本来なら何らかの処理
        //遷移
        System.out.println("ログ出力:サーブレット:doGet:終了");
        request.getRequestDispatcher("output.jsp").forward(request, response);
    }
}
