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

    protected void doGet(
    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String keyword = request.getParameter("keyword");
        String language = request.getParameter("language");
        
        DictionaryList dList = DictionaryDAO.getList(keyword, language);
        String nextPage= "/search_result.jsp";
        	
    	if (dList.size() == 0) {
            request.setAttribute("japanese", keyword);
            nextPage = "/search_error.jsp";
        }
        
        request.setAttribute("list", dList);
        
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
