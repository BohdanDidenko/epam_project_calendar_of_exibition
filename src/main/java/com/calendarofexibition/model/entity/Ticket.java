package com.calendarofexibition.model.entity;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Ticket implements Serializable {
    private Integer ticketId;
    private String key;
    private GregorianCalendar dataVisiting;
    private Event event;

    public Ticket() {
    }

    public Ticket(Integer ticketId, String key, GregorianCalendar dataVisiting, Event event) {
        this.ticketId = ticketId;
        this.key = key;
        this.dataVisiting = dataVisiting;
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

    public GregorianCalendar getDataVisiting() {
        return dataVisiting;
    }

    public void setDataVisiting(GregorianCalendar dataVisiting) {
        if(event.getStartDate().after(dataVisiting) && event.getEndDate().before(dataVisiting)) {
            this.dataVisiting = dataVisiting;
        }
        else {
            throw new UnsupportedOperationException("The date out of range available dates");
        }
    }

    public Double getPrice (){
        return event.getPrice();
    }

    public String getTitle() {
        return event.getTitle();
    }

    public String getThema (){
        return event.getTheme();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (getTicketId() != null ? !getTicketId().equals(ticket.getTicketId()) : ticket.getTicketId() != null) return false;
        if (getKey() != null ? !getKey().equals(ticket.getKey()) : ticket.getKey() != null) return false;
        if (getDataVisiting() != null ? !getDataVisiting().equals(ticket.getDataVisiting()) : ticket.getDataVisiting() != null)
            return false;
        return event != null ? event.equals(ticket.event) : ticket.event == null;
    }

    @Override
    public int hashCode() {
        int result = getTicketId() != null ? getTicketId().hashCode() : 0;
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        result = 31 * result + (getDataVisiting() != null ? getDataVisiting().hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "ticketId=" + ticketId +
                ", key='" + key + '\'' +
                ", dataVisiting=" + dataVisiting +
                ", price=" + event.getPrice() +
                ", title=" + event.getTitle() +
                '}';
    }
}
