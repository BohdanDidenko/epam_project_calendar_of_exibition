package com.calendarofexibition.controller.filters;


import com.calendarofexibition.persistence.implementation.UserDAOImpl;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoggerFilter implements Filter {

    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    public void init(FilterConfig fConfig)  {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();

        if (uri.equals("/")){
            res.sendRedirect("/index");
            return;
        }

        LOGGER.info(this.getClass().getSimpleName() + " filter");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}

