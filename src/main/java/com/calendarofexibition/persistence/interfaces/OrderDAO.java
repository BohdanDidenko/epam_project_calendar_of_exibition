package com.calendarofexibition.persistence.interfaces;

import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;
import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.Event;
import java.util.List;

public interface OrderDAO {

    /**
     * Get all consumer's tickets
     * @return list of tickets for special consumer
     */
    List<Ticket> getAllTicketsForConsumer(Integer consumerId);

    /**
     * Get ticket's id by ticket
     * @param ticket ticket
     * @return ticket's id
     */
    Integer getTicketIdByTicket(Ticket ticket);


    /**
     * Create new Order in database
     * @param order new order
     * @return order's id
     */
    Integer createOrder(Order order);

    /**
     * Create new Order in database
     * @param ticket new order
     * @return ticket's id
     */
    Integer createTicket(Ticket ticket);

    /**
     * Get order by id
     * @param id id of order
     * @return order
     */
    Order getOrdersByaEvent(Integer id);
    /**
     * @param order new Order
     * @param event id ordered
     * @param consumerId  id of Consumer which requested this order
     * @return list of orders
     */
    boolean saveOrder(Order order, Event event, int consumerId);

    /**
     * Obtaining all order related to Consumer
     * @param consumer person who made these Orders
     * @return List of Orders
     */
    List<Order> getOrdersByConsumer(Consumer consumer);

    /**
     * Obtaining all active order related to Consumer
     * @param consumer person who made these Orders
     * @return List of Orders
     */
    List<Order> getActiveOrdersByConsumer(Consumer consumer);
}
