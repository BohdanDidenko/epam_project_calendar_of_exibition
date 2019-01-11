package com.calendarofexibition.service.implementation;

import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.persistence.FactoryDAO;
import com.calendarofexibition.persistence.interfaces.EventDAO;
import com.calendarofexibition.service.interfeices.EventService;
import org.apache.log4j.Logger;
import java.util.List;

public class EventServiceImpl implements EventService {
    private final static Logger LOGGER = Logger.getLogger(EventServiceImpl.class);
    private EventDAO eventDAO;

    public EventServiceImpl() {
        this.eventDAO = FactoryDAO.getInstance().getEventDAO();
    }

    @Override
    public Event getEventById(int id) {
        LOGGER.info("serviceLevel: getEventById");
        return eventDAO.findEvent(id);
    }

    @Override
    public List<Event> getAllEvents() {
        LOGGER.info("serviceLevel: getAllEvents");
        return eventDAO.findAll();
    }

    @Override
    public Event getEvent(Event event) {
        LOGGER.info("serviceLevel: getEvent");
        return eventDAO.createEvent(event);
    }
}
