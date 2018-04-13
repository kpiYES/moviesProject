package com.app.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/dispatcher"})
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request.getParameter("command") == null) {
            request.setAttribute("errMsg", "You must choose the mode");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("errorPage.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("command").equals("To dataChange")) {
            if (!request.getParameter("username").equals("admin") || !request.getParameter("password").equals("admin")) {
                request.setAttribute("errMsg", "Wrong 'username' or 'password' for editor mode.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("errorPage.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
