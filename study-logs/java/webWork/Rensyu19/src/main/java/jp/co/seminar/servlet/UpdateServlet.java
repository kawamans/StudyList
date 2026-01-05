package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.seminar.beans.DictionaryBean;
import jp.co.seminar.dao.DictionaryDAO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String english = request.getParameter("english");
        String japanese = request.getParameter("japanese");
        String oldeng = request.getParameter("oldeng");
        String oldjp = request.getParameter("oldjp");
        String nextPage;
        
        DictionaryBean dict = new DictionaryBean(english, japanese);
            
        if(DictionaryDAO.updateDictionary(dict, oldeng)) {
            request.setAttribute("dict", dict);
            request.setAttribute("oldjp", oldjp);
            nextPage = "/update-result.jsp";
            
        } else {
            nextPage = "/update-error.jsp";
        }
            
        request.setAttribute("oldeng", oldeng);
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

}
