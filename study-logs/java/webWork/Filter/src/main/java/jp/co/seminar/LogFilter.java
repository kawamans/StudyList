package jp.co.seminar;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class LogFilter implements Filter {

    //破棄メソッド------------------------------------------------
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            //呼び出し前に行いたいフィルター処理
            System.out.println("ログ出力:フィルタ:doFilter:開始");

            chain.doFilter(request, response);
          //呼び出し後に行いたいフィルター処理

            System.out.println("ログ出力:フィルタ:doFilter:終了");
        } catch (ServletException se) {
            System.out.println("ServletExceptionが発生しました。");
        } catch (IOException e) {
            System.out.println("IOExceptionが発生しました。");
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("ログ出力:フィルタ:init:開始");
        System.out.println("ログ出力:フィルタ:init:終了");
    }
}
