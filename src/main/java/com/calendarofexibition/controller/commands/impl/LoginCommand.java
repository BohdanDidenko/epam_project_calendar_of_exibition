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

    private final static Logger LOGGER = Logger.getLogger(GetAllEventsPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ConsumerService consumerService = ServiceFactory.getInstance().getConsumerService();

        System.out.println("login: " + request.getParameter("login") + " password: " + request.getParameter("password"));
        User user =  consumerService.getUser(request.getParameter("login"), request.getParameter("password"));
        System.out.println(user + "this is USER!!!!");
        System.out.println("loginCommand: user: " + user);

        if (user != null && user.getRole().equals("consumer")) {
            request.getSession().setAttribute("user", user);
            return PagesManager.getProperty("path.page.consumerPage");

        }

        else if (user != null && user.getRole().equals("admin")) {
            request.getSession().setAttribute("user", user);
            return PagesManager.getProperty("path.page.adminPage");

        }

        else {
            return PagesManager.getProperty("path.page.login");
        }

//        LOGGER.info(this.getClass().getSimpleName() + " executed");
//        return page;
    }
}
