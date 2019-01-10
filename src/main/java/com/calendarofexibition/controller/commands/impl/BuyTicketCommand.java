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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BuyTicketCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws RegistrationException, ServletException, IOException {
        Event event =  new Event();
        EventService eventService = ServiceFactory.getInstance().getEventService();
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        ConsumerService consumerService = ServiceFactory.getInstance().getConsumerService();
        Integer id = Integer.parseInt(req.getParameter("id"));
        event = eventService.getEventById(id);

        Ticket ticket = new Ticket();
        ticket.setKey(new KeyGenerator().getKey());
        ticket.setEvent(event);
        int ticketId = orderService.createTicket(ticket);
        ticket.setTicketId(ticketId);

        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");
        Integer consumerId = user.getId();

        Consumer consumer;
        consumer = consumerService.getConsumer(consumerId);

        Order order = new Order(consumer, ticket);

        int orderId = orderService.createOrder(order);

        return PagesManager.getProperty("path.page.consumerPage");
    }
}
