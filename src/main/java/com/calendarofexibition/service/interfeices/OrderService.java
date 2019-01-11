package com.calendarofexibition.service.interfeices;

import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;

import java.util.List;

public interface OrderService {

    int createOrder (Order order);

    int createTicket(Ticket ticket);

    int getTicketIdByTicket(Ticket ticket);

    List<Ticket> getAllTicketsForConsumer(Integer consumerId);
}
