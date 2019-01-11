package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.model.Ticket;
import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.service.ServiceFactory;
import com.calendarofexibition.service.interfeices.ConsumerService;
import com.calendarofexibition.service.interfeices.EventService;
import com.calendarofexibition.service.interfeices.OrderService;
import com.calendarofexibition.util.PagesManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

public class ConsumerPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)  {
        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");

        EventService eventService = ServiceFactory.getInstance().getEventService();
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        ConsumerService consumerService = ServiceFactory.getInstance().getConsumerService();
        Consumer consumer = null;
        if(user != null) {

            consumer = consumerService.getConsumer(user.getId());

            List<Ticket> listTickets = orderService.getAllTicketsForConsumer(user.getId());

            Event event;
            List<Ticket> newListTickets = new LinkedList<>();
            List<Event> eventList = new LinkedList<>();

            for (Ticket ticket : listTickets) {
                event = eventService.getEventById(ticket.getEvent().getEventId());
                ticket.setEvent(event);
                newListTickets.add(ticket);
                eventList.add(event);
            }
            req.setAttribute("tickets", newListTickets);
        }

        if(user != null && user.getRole().equals("consumer")){

            req.setAttribute("message", consumer.getName() + " " + consumer.getSurname());
            return PagesManager.getProperty("path.page.consumerPage");
        }

        else if(user != null && user.getRole().equals("admin")){
            return PagesManager.getProperty("path.page.adminPage");
        }

        else {
            req.setAttribute("message", "");
            return PagesManager.getProperty("path.page.loginPage");
        }
    }
}
