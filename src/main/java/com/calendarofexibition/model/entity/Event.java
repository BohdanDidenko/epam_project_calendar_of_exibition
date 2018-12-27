package com.calendarofexibition.model.entity;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Event implements Serializable {
    private int eventId;
    private String title;
    private String theme;
    private String description;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private Double price;
    private String pathToPicture;

    public Event() {
    }

    public Event(int eventId, String title, String theme, String description,
                 GregorianCalendar startDate, GregorianCalendar endDate, Double price, String pathToPicture) {
        this.eventId = eventId;
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.pathToPicture = pathToPicture;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        if (getEventId() != event.getEventId()) return false;
        if (getTitle() != null ? !getTitle().equals(event.getTitle()) : event.getTitle() != null) return false;
        if (getTheme() != null ? !getTheme().equals(event.getTheme()) : event.getTheme() != null) return false;
        if (getDescription() != null ? !getDescription().equals(event.getDescription()) : event.getDescription() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(event.getStartDate()) : event.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(event.getEndDate()) : event.getEndDate() != null) return false;
        if (getPrice() != null ? !getPrice().equals(event.getPrice()) : event.getPrice() != null) return false;
        if (getPathToPicture() != null ? !getPathToPicture().equals(event.getPathToPicture()) : event.getPathToPicture() != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getEventId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getTheme() != null ? getTheme().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getPathToPicture() != null ? getPathToPicture().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", theme='" + theme + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", pathToPicture='" + pathToPicture + '\'' +
                '}';
    }
}
