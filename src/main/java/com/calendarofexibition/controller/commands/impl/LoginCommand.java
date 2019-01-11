package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.service.ServiceFactory;
import com.calendarofexibition.service.interfeices.ConsumerService;
import com.calendarofexibition.util.PagesManager;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    private final static Logger LOGGER = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ConsumerService consumerService = ServiceFactory.getInstance().getConsumerService();

        User user =  consumerService.getUser(request.getParameter("login"),
                request.getParameter("password"));
        if (user != null && user.getRole().equals("consumer")) {
            request.getSession().setAttribute("user", user);
            return new ConsumerPageCommand().execute(request, response);
        }

        else if (user != null && user.getRole().equals("admin")) {
            request.getSession().setAttribute("user", user);
            return PagesManager.getProperty("path.page.adminPage");
        }

        else {
            request.setAttribute("message", "Wrong login or password");
            return PagesManager.getProperty("path.page.loginPage");
        }
    }
}
