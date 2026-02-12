package controller;

/**
 * 社員情報管理コントローラー
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberBean;
import service.MemberService;

public class MemberController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            
            /*
             *  IDとPassWordと元に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理
             *  ※ MemberBeanとMemberServiceをimportするのを忘れないでください。
             */

            // 問② MemberServiceクラスをインスタンス化してオブジェクトに格納して下さい。
            MemberService memberService = new MemberService();
            
            // 問③ インスタンスからsearch関数を実行し、その返り値をオブジェクトに格納して下さい。
            MemberBean memberBean = memberService.search(id, password);
            
            // 問④ nullの部分に適切な引数をセットして下さい。
            request.setAttribute("MemberBean", memberBean);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
