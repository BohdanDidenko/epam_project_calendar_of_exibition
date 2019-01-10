package com.calendarofexibition.service.implementation;

import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.persistence.FactoryDAO;
import com.calendarofexibition.persistence.interfaces.EventDAO;
import com.calendarofexibition.service.interfeices.EventService;
import org.apache.log4j.Logger;

import java.util.List;

public class EventServiceImpl implements EventService {
    private final static Logger LOGGER = Logger.getLogger(EventServiceImpl.class);

   private EventDAO eventDAO = FactoryDAO.getInstance().getEventDAO();

    @Override
    public Event getEventById(int id) {
        return eventDAO.findEvent(id);
    }

    @Override
    public List<Event> getAllExpositions() {
        return eventDAO.findAll();
    }

    @Override
    public Event getEvent(Event event) {
        return eventDAO.createEvent(event);
    }

   /* @Override
    public List<Exposition> findExpositions(Map<String, String> requestParameters, int limit, int offset) {
        String query = QueryHelper.parseQuery(requestParameters, limit, offset);
        LOGGER.info("New query string formed from request parameters " + query);
        return expositionDAO.findExpositions(query);
    }

    @Override
    public int getNumberOfExpositions(Map<String, String> requestParameters) {
        String countQuery = QueryHelper.countQuery(requestParameters);
        LOGGER.info("New query string formed from request parameters " + countQuery);
        return expositionDAO.countExpositions(countQuery);
    }

    @Override
    public List<String> findThemes() {
        return expositionDAO.findThemes();
    }

    @Override
    public Exposition getExposition(Integer id) {
        return expositionDAO.findExposition(id);
    }*/
}
