package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.service.ServiceFactory;
import com.calendarofexibition.service.interfeices.EventService;
import com.calendarofexibition.util.PagesManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ConsumerPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)  {
        EventService eventService = ServiceFactory.getInstance().getEventService();
        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");



        if(user != null && user.getRole().equals("consumer")){
            return PagesManager.getProperty("path.page.consumerPage");
        }

        else if(user != null && user.getRole().equals("admin")){
            return PagesManager.getProperty("path.page.adminPage");
        }

        else {
            return PagesManager.getProperty("path.page.loginPage");
        }
    }
}
