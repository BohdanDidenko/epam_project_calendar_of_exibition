package com.calendarofexibition.persistence.abstraction.interfaces;


import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.entity.Event;

import java.util.Map;

public interface OrderDAO {
    /**
     * Obtaining all order related to Consumer
     *
     * @param consumerId id of Account which requested its orders
     * @return map of orders and related expositions
     */
    Map<Order, Event> getOrders(int consumerId);

    /**
     * Saves new order in database
     *
     * @param order      new Order
     * @param event id ordered
     * @param consumerId  id of Consumer which requested its orders
     * @return map of orders and related expositions
     */
    boolean saveOrder(Order order, Event event, int consumerId);
}
