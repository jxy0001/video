package com.zhiyou.filter;

import com.zhiyou.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author
 * @date 2019/6/24
 */
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //获取用户请求的URI
        String path = request.getRequestURI();
        User user = (User) session.getAttribute("user");
        System.out.println("Request path:"+path);
        //登陆页面无须过滤
        if(path.indexOf("/videoPlayer/jsp/main.jsp")>-1|| path.indexOf("/videoPlayer/jsp/NoLogin.jsp")>-1){
            filterChain.doFilter(request,response);
            return;
        }
        if (user==null){
            response.sendRedirect("http://localhost:8080/videoPlayer/jsp/NoLogin.jsp");
        }else{
            //已登录，放行
            filterChain.doFilter(request,response);
        }

    }

}
