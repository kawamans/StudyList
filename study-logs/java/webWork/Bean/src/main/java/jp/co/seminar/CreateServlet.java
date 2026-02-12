package jp.co.seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //受信データを取得
        String name = request.getParameter("name");
        String job = request.getParameter("job");
        int age = Integer.parseInt(request.getParameter("age"));
        //会員インスタンスを生成
        Customer cst = new Customer();
        cst.setName(name);
        cst.setJob(job);
        cst.setAge(age);
        //会員インスタンスをリクエスト属性にセット
        request.setAttribute("customer", cst);
        String nextPage = "/output.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
