package com.calendarofexibition.model;

import com.calendarofexibition.model.entity.Event;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

public class ExpoHall implements Serializable{
    private Integer hallId;
    private String name;
    private GregorianCalendar bookedFrom;
    private GregorianCalendar bookedTo;
    private Boolean isAvailable;
    private Integer freePlaces;
    private List<Event> event;

    public ExpoHall() {
    }


    public ExpoHall(Integer hallId, String name, GregorianCalendar bookedFrom, GregorianCalendar bookedTo,
                    Boolean isAvailable, Integer freePlaces) {
        this.hallId = hallId;
        this.name = name;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.isAvailable = isAvailable;
        this.freePlaces = freePlaces;
    }

    public ExpoHall(Integer hallId, String name, GregorianCalendar bookedFrom, GregorianCalendar bookedTo,
                    Boolean isAvailable, Integer freePlaces, List<Event> event) {
        this.hallId = hallId;
        this.name = name;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.isAvailable = isAvailable;
        this.freePlaces = freePlaces;
        this.event = event;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(GregorianCalendar bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public GregorianCalendar getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(GregorianCalendar bookedTo) {
        this.bookedTo = bookedTo;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpoHall)) return false;
        ExpoHall expoHall = (ExpoHall) o;
        if (getHallId() != null ? !getHallId().equals(expoHall.getHallId()) : expoHall.getHallId() != null) return false;
        if (getName() != null ? !getName().equals(expoHall.getName()) : expoHall.getName() != null) return false;
        if (getBookedFrom() != null ? !getBookedFrom().equals(expoHall.getBookedFrom()) : expoHall.getBookedFrom() != null)
            return false;
        if (getBookedTo() != null ? !getBookedTo().equals(expoHall.getBookedTo()) : expoHall.getBookedTo() != null)
            return false;
        if (isAvailable != null ? !isAvailable.equals(expoHall.isAvailable) : expoHall.isAvailable != null) return false;
        return getFreePlaces() != null ? getFreePlaces().equals(expoHall.getFreePlaces()) : expoHall.getFreePlaces() == null;
    }

    @Override
    public int hashCode() {
        int result = getHallId() != null ? getHallId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getBookedFrom() != null ? getBookedFrom().hashCode() : 0);
        result = 31 * result + (getBookedTo() != null ? getBookedTo().hashCode() : 0);
        result = 31 * result + (isAvailable != null ? isAvailable.hashCode() : 0);
        result = 31 * result + (getFreePlaces() != null ? getFreePlaces().hashCode() : 0);
        result = 31 * result + event.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "hallId=" + hallId +
                ", name='" + name + '\'' +
                ", bookedFrom=" + bookedFrom +
                ", bookedTo=" + bookedTo +
                ", isAvailable=" + isAvailable +
                ", freePlaces=" + freePlaces +
                event.toString() +
                '}';
    }
}
