package jp.co.seminar.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")  
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初期化処理（今回はいらない）
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // リクエストの文字コードをUTF-8に設定
        // レスポンスはJSPで設定済みのため無し
        request.setCharacterEncoding("UTF-8");
        

//        サーブレットへ
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
