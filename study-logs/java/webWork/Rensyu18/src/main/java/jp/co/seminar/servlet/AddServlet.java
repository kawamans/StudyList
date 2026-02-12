package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.seminar.beans.DictionaryBean;
import jp.co.seminar.dao.DictionaryDAO;
import jp.co.seminar.util.DictionaryList;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストで受信した文字をUTF-8文字コードで受信する
        request.setCharacterEncoding("UTF-8");
        //データ受信
        String english = request.getParameter("english");
        String japanese = request.getParameter("japanese");
        //検索メソッドで登録済か確認
        DictionaryList list = DictionaryDAO.getList(english);
        String nextPage;
        if(list.size()==0) {
            DictionaryBean dict = new DictionaryBean(english, japanese);
            //登録
            if(DictionaryDAO.addDictionary(dict)) {
                //登録成功
                request.setAttribute("dict", dict);
                nextPage = "/add_result.jsp";
            } else {
                //登録失敗
                request.setAttribute("english", english);
                nextPage = "/add_error.jsp";
            }
        } else {
            //登録済
            request.setAttribute("english", english);
            nextPage = "/add_error.jsp";
        }        
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}