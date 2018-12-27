package com.calendarofexibition.model;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.model.entity.Ticket;

import java.io.Serializable;

public class Order implements Serializable {
    private Integer OrderId;
    private Consumer consumer;
    private Ticket ticket;

    public Order() {
    }

    public Order(Integer orderId, Consumer consumer, Ticket ticket) {
        OrderId = orderId;
        this.consumer = consumer;
        this.ticket = ticket;
    }

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        this.OrderId = orderId;
    }

    public String getName() {
        return consumer.getName();
    }

    public String getSurname() {
        return consumer.getSurname();
    }

    public String getPhoneNumber() {
        return consumer.getPhoneNumber();
    }

    public String getEmail() {
        return consumer.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getOrderId() != null ? !getOrderId().equals(order.getOrderId()) : order.getOrderId() != null) return false;
        if (consumer != null ? !consumer.equals(order.consumer) : order.consumer != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getOrderId() != null ? getOrderId().hashCode() : 0;
        result = 31 * result + (consumer != null ? consumer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "OrderId=" + OrderId +
                ", consumerName=" + consumer.getName() +
                ", consumerSurname=" + consumer.getSurname() +
                ", consumerPhoneNumber=" + consumer.getPhoneNumber() +
                ", consumerEmail=" + consumer.getEmail() +
                '}';
    }
}
