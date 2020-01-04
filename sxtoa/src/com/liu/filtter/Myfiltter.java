package com.liu.filtter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Myfiltter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  req =(HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        boolean flag = false;
        String method = req.getParameter("method");
        String uri = req.getRequestURI();
        if (uri.contains("js")){
            flag = true;
        }
        if (uri.contains("css")){
            flag = true;
        }
        if (uri.contains("editor")){
            flag = true;
        }
        if (uri.contains("images")){
            flag = true;
        }
        if (uri.contains("My97DatePicker")){
            flag = true;
        }
        if (method!=null&&method.equals("loginCheck")){
            flag=true;
        }
        if (req.getRequestURI().contains("login.jsp")){
            flag = true;
        }

        Object employee = req.getSession().getAttribute("employee");
        if (employee!=null){
            flag = true;
        }
        if (flag){
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
