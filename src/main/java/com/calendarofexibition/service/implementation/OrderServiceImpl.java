package com.calendarofexibition.service.implementation;

import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;
import com.calendarofexibition.persistence.implementation.OrderDAOImpl;
import com.calendarofexibition.persistence.interfaces.OrderDAO;
import com.calendarofexibition.service.interfeices.OrderService;
import org.apache.log4j.Logger;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final static Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);
    private OrderDAO orderDAO;

    public OrderServiceImpl() {
        this.orderDAO = OrderDAOImpl.getInstance();
    }

    @Override
    public int createOrder(Order order) {
        LOGGER.info("serviceLevel: createOrder");
        return orderDAO.createOrder(order);
    }

    @Override
    public int createTicket(Ticket ticket) {
        LOGGER.info("serviceLevel: createTicket");
        return orderDAO.createTicket(ticket);
    }

    @Override
    public int getTicketIdByTicket(Ticket ticket) {
        LOGGER.info("serviceLevel: getTicketIdByTicket");
        return orderDAO.getTicketIdByTicket(ticket);
    }

    @Override
    public List<Ticket> getAllTicketsForConsumer(Integer consumerId) {
        LOGGER.info("serviceLevel: getAllTicketsForConsumer");
        return orderDAO.getAllTicketsForConsumer(consumerId);
    }
}
