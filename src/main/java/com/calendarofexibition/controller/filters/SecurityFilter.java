package com.calendarofexibition.controller.filters;


import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.persistence.implementation.UserDAOImpl;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    private final static Logger LOGGER = Logger.getLogger(SecurityFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        String role = ((User)req.getSession().getAttribute("user")).getRole();

        if(role == null){
            req.setAttribute("command", "loginPage");
                   }
        LOGGER.info(this.getClass().getSimpleName() + " filter");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
