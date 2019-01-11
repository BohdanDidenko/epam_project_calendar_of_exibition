package com.calendarofexibition.service.interfeices;

import com.calendarofexibition.model.entity.Event;
import java.util.List;

/**
 * Interface provides service for getting
 * objects of subject area: Events, ExpoHalls, Themes.
 * Methods implementations implies business logic
 * interacting with appropriate DAO
 *
 * @author Bogdan
 */

public interface EventService {
    /**
     * Creating event
     * @param event without id
     * @return event with id
     */
   Event getEvent(Event event);

    /**
     * getting event by id
     * @param id id of event
     * @return event
     */
    Event getEventById(int id);

    /**
     * getting all Expositions from database
     *
     * @return List of Events
     */
    List<Event> getAllEvents();
}
