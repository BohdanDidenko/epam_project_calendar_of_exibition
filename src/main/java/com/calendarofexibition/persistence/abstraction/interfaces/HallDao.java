package com.calendarofexibition.persistence.abstraction.interfaces;

import com.calendarofexibition.model.ExpoHall;
import com.calendarofexibition.model.entity.Event;

import java.util.List;

public interface HallDao {

    /**
     * Obtain all ExpoHall from database
     * @return list of Events
     */
    List<ExpoHall> findAll();

    /**
     * find Expositions corresponds to user's request
     * @param query String depending on selected parameters
     * @return boolean result of operation
     */
    List<Event> findEvent(String query);

    /**
     * count Events corresponds to user's request
     * @param query String depending on selected parameters
     * @return boolean result of operation
     */
    int countEvent(String query);

    /**
     * Find exposition in database
     * @param eventId of Event to be found in database
     * @return boolean result of operation
     */
    Event findEvent(int eventId);

    /**
     * Obtain all themes from database
     * @return list of themes
     */
    List<String> findThemes();

    /**
     *
     * @param event to be updated
     * @return boolean result of operation
     */
    boolean createEvent(Event event);

    /**
     *
     * @param event to be updated
     * @return boolean result of operation
     */
    boolean updateEvent(Event event);

    /**
     *
     * @param eventId of Event to be deleted
     * @return boolean result of operation
     */
    boolean deleteEvent(int eventId);
}
