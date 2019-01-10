package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.exceptions.RegistrationException;
import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.service.ServiceFactory;
import com.calendarofexibition.service.interfeices.ConsumerService;
import com.calendarofexibition.util.PagesManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {


    private final static Logger LOGGER = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws RegistrationException {

        ConsumerService consumerService = ServiceFactory.getInstance().getConsumerService();

        String role = "consumer";
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Boolean isAvailable = true;
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Double spentMoney = 0.0;
        Double discount = 0.0;
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        Consumer consumer = new Consumer(role, login, password, isAvailable, name, surname,
                spentMoney, discount, email, phoneNumber);
        System.out.println("registrationCommand: Consumer:"+consumer);
    /*    if(consumerService.checkUser(login)){
            throw new RegistrationException("This login already exist!");
        }*/

        Integer id = consumerService.createConsumer(consumer);
        System.out.println("registrationCommand: ConsumerId" + id);
        consumer.setId(id);
        HttpSession session = req.getSession();
        session.setAttribute("user", consumer);

        LOGGER.info(this.getClass().getSimpleName() + " executed");
        return PagesManager.getProperty("path.page.loginPage");
    }
}
