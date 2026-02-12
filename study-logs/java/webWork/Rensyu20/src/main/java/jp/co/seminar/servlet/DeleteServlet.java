package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.seminar.dao.DictionaryDAO;
import jp.co.seminar.util.DictionaryList;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String delete = request.getParameter("delete");
        String search = request.getParameter("search");
        
        DictionaryList list = DictionaryDAO.getList(delete, search);
        String nextPage;
        
        if(list.size()==1) {
            if(DictionaryDAO.deleteDictionary(delete)) {
                request.setAttribute("deleteword", delete);
                nextPage = "/delete-result.jsp";
            } else {
                request.setAttribute("deleteword", delete);
                nextPage = "/delete-error.jsp";
            }
        } else {
            request.setAttribute("deleteword", delete);
            nextPage = "/delete-error.jsp";
        }        
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

}
