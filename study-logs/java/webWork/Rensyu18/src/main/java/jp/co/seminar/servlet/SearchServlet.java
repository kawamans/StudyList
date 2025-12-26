package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.seminar.dao.DictionaryDAO;
import jp.co.seminar.util.DictionaryList;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //データ受信
        String keyword = request.getParameter("keyword");
        //DAOのインスタンスを生成し、メソッドを呼び出す
        DictionaryList dList = DictionaryDAO.getList(keyword);
        //取得したDBデータをリクエスト属性に格納
        request.setAttribute("list", dList);
        String nextPage= "/search_result.jsp";
        //取得データで遷移先を変更(0件でエラーとする)
        if (dList.size() == 0) {
            request.setAttribute("english", keyword);
            nextPage = "/search_error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
