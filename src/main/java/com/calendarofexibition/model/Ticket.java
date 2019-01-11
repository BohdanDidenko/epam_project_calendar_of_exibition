package com.calendarofexibition.model;

import com.calendarofexibition.model.entity.Event;

import java.io.Serializable;

public class Ticket implements Serializable {
    private Integer ticketId;
    private String key;
    private com.calendarofexibition.model.entity.Event event;

    public Ticket() {
    }

    public Ticket(String key, Event event) {
        this.key = key;
        this.event = event;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getPrice (){
        return event.getPrice();
    }

    public String getTitle() {
        return event.getTitle();
    }

    public String getTheme (){
        return event.getTheme();
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (getTicketId() != null ? !getTicketId().equals(ticket.getTicketId()) : ticket.getTicketId() != null) return false;
        if (getKey() != null ? !getKey().equals(ticket.getKey()) : ticket.getKey() != null) return false;
        return event != null ? event.equals(ticket.event) : ticket.event == null;
    }

    @Override
    public int hashCode() {
        int result = getTicketId() != null ? getTicketId().hashCode() : 0;
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "ticketId=" + ticketId +
                ", key='" + key + '\'' +
                ", price=" + event.getPrice() +
                ", title=" + event.getTitle() +
                ", theme=" + event.getTheme() +
                this.getEvent().toString()+
                '}';
    }
}
