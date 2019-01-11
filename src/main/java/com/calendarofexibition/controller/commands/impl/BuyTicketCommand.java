package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.exceptions.RegistrationException;
import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;
import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.service.ServiceFactory;
import com.calendarofexibition.service.interfeices.ConsumerService;
import com.calendarofexibition.service.interfeices.EventService;
import com.calendarofexibition.service.interfeices.OrderService;
import com.calendarofexibition.util.KeyGenerator;
import com.calendarofexibition.util.PagesManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyTicketCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws RegistrationException{

        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");

        if (user == null) {
            return PagesManager.getProperty("path.page.loginPage");
        }

        EventService eventService = ServiceFactory.getInstance().getEventService();
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        ConsumerService consumerService = ServiceFactory.getInstance().getConsumerService();
        Event event;
        Integer eventId = Integer.parseInt(req.getParameter("id"));
        event = eventService.getEventById(eventId);
        Ticket ticket = new Ticket();
        ticket.setKey(new KeyGenerator().getKey());
        ticket.setEvent(event);
        orderService.createTicket(ticket);
        int ticketId = orderService.getTicketIdByTicket(ticket);
        ticket.setTicketId(ticketId);
        Integer consumerId = user.getId();
        Consumer consumer = consumerService.getConsumer(consumerId);
        Order order = new Order(consumer, ticket);
        orderService.createOrder(order);
        //req.setAttribute("message", "");
        return new ConsumerPageCommand().execute(req, resp);

                //PagesManager.getProperty("path.page.consumerPage");
    }
}
