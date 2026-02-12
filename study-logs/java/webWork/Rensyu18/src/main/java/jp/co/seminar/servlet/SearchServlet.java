package jp.co.seminar.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        
        String notword = null;
        DictionaryList dList = new DictionaryList();
        String engword = request.getParameter("engword");
        String jpword = request.getParameter("jpword");
        String nextPage= "/search_result.jsp";
        
        if (engword != null && !engword.isEmpty()) {
        	Pattern engPattern = Pattern.compile("^[a-zA-Z]+$");
        	Matcher engMatcher = engPattern.matcher(engword);
        	
        	if (engMatcher.matches()) {
        		 dList = DictionaryDAO.getList(engword);
        	} else {
        		notword = engword;
        	}
        	
        	if (dList.size() == 0) {
                request.setAttribute("english", notword);
                nextPage = "/search_error.jsp";
            }
        	
        } else if (jpword != null && !jpword.isEmpty()) {
        	
        	Pattern jpPattern = Pattern.compile("^[\\p{IsHiragana}\\p{IsKatakana}\\p{IsHan}]+$");
        	Matcher jpMatcher = jpPattern.matcher(jpword);
    	
        	if (jpMatcher.matches()) {
        		dList = DictionaryDAO.getList(jpword);
        	} else {
        		notword = jpword;
        	}
        	
        	if (dList.size() == 0) {
                request.setAttribute("japanese", notword);
                nextPage = "/search_error.jsp";
            }
        } else {
        	nextPage = "/search_error.jsp";
        }
        
        request.setAttribute("list", dList);
        
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
}
