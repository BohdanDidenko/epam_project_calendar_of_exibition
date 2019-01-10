package com.calendarofexibition.service.interfeices;

import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;

public interface OrderService {

    int createOrder (Order order);

    int createTicket(Ticket ticket);
}
