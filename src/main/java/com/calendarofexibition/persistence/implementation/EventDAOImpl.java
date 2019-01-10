package com.calendarofexibition.persistence.implementation;

import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.persistence.interfaces.EventDAO;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    private static final String GET_ALL_EVENTS = "SELECT * FROM events";
    private static final String GET_ALL_BY_THEME = "SELECT * FROM events WHERE theme = ?";
    private static final String GET_COUNT_BY_THEME = "SELECT SUM(title) WHERE theme AS count VALUE (?)";
    private static final String GET_EVENT_BY_ID = "SELECT * FROM events WHERE EventId = ?";
    private static final String GET_LIST_THEMS = "SELECT DISTINCT theme FROM events ";
    private static final String INSERT_EVENT = "INSERT INTO users (title, theme, startDate, endDate, price," +
                                                "pathToPicture) VALUES (?,?,?,?,?,?,?)";
    private static final String GET_LAST_ID = "SELECT MAX(EventID) AS LastID FROM Events";
    private static final String UPDATE_EVENT = "UPDATE events SET title, theme, startDate, endDate, price" +
                                                            "pathToPicture (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_EVENT = "DELETE FROM events WHERE EventId VALUES (?)";
    private FactoryConnection factoryConnection;
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    public EventDAOImpl() {
        this.factoryConnection = FactoryConnection.getInstance();
    }

    @Override
    public List<Event> findAll() {
        List<Event> list = new LinkedList<>();
        Event event;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_ALL_EVENTS)) {
            ResultSet rsEvent = psEvent.executeQuery();
            while (rsEvent.next()) {
                event = buildEvent(rsEvent);
                list.add(event);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("All events was received from DB");
        return list;
    }

    @Override
    public List<Event> findAll(String theme) {
        List<Event> list = new LinkedList<>();
        Event event = new Event();
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_ALL_BY_THEME)) {
             psEvent.setString(1, theme);
             ResultSet rsEvent = psEvent.executeQuery();
            while (rsEvent.next()) {
                event = buildEvent(rsEvent);
                list.add(event);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("List of Events by theme was received from DB");
        return list;
    }

    @Override
    public int countEvent(String theme) {
       Integer result = -1;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_COUNT_BY_THEME)) {
            psEvent.setString(1, theme);
            ResultSet rsEvent = psEvent.executeQuery();
            if (rsEvent.next()) {
                result = rsEvent.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Amount of by theme was received from DB");
        return result;
    }

    @Override
    public Event findEvent(int eventId) {
        Event event = null;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_EVENT_BY_ID)) {
            psEvent.setInt(1, eventId);
            ResultSet rsEvent = psEvent.executeQuery();
            if (rsEvent.next()) {
                event = buildEvent(rsEvent);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Event was found in DB");
        return event;
    }

    @Override
    public List<String> findThemes() {
        List<String> list = new LinkedList<>();
        String theme;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_LIST_THEMS)) {
            ResultSet rsEvent = psEvent.executeQuery();
            while (rsEvent.next()) {
                theme = rsEvent.getString(1);
                list.add(theme);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Themes was extracted from DB");
        return list;
    }

    @Override
    public Event createEvent(Event event) {
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(INSERT_EVENT);
             PreparedStatement psId = connection.prepareStatement(GET_LAST_ID)) {
            connection.setAutoCommit(false);
            psEvent.setString(1, event.getTitle());
            psEvent.setString(2, event.getTitle());
            psEvent.setDate(  3, new Date(event.getStartDate().getTimeInMillis()));
            psEvent.setDate(  4, new Date(event.getEndDate().getTimeInMillis()));
            psEvent.setDouble(5, event.getPrice());
            psEvent.setString(6, event.getPathToPicture());
            psEvent.setString(7, event.getDescription());
            psEvent.executeUpdate();
            ResultSet rsId;

            try{
                psEvent.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
                LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
                return null;
            }

            try{
                rsId = psId.executeQuery();
            }
            catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
                LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
                return null;
            }

            if (rsId.next()) {
                event.setEventId(rsId.getInt(1));
            }
        } catch (SQLException e) {

        }
        LOGGER.info("Event was added  in DB");
        return event;
    }

    @Override
    public boolean updateEvent(Event event) {
        Boolean result = false;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(UPDATE_EVENT)) {
            psUpdate.setString(1, event.getTitle());
            psUpdate.setString(2, event.getTitle());
            psUpdate.setDate(  3, new Date(event.getStartDate().getTimeInMillis()));
            psUpdate.setDate(  4, new Date(event.getEndDate().getTimeInMillis()));
            psUpdate.setDouble(5, event.getPrice());
            psUpdate.setString(6, event.getPathToPicture());
            psUpdate.setString(7, event.getDescription());
            psUpdate.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Event was found in DB");
        return result;
    }

    @Override
    public boolean deleteEvent(int eventId) {
        Boolean result = false;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psDelete = connection.prepareStatement(DELETE_EVENT)) {
            psDelete.setInt(1, eventId);
            psDelete.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Event whit id: " + eventId+"was deleted");
        return result;
    }

    private Event buildEvent (ResultSet rsEvent) throws SQLException {
        Event event = new Event();
        Date myDate;
        GregorianCalendar cal = new GregorianCalendar();
        event.setEventId(rsEvent.getInt(1));
        event.setTitle(rsEvent.getNString(2));
        event.setDescription(rsEvent.getString(3));
        myDate = rsEvent.getDate( 4 );
        cal.setTime(myDate);
        event.setStartDate(cal);
        myDate = rsEvent.getDate( 5 );
        cal.setTime(myDate);
        event.setEndDate(cal);
        event.setPrice(rsEvent.getDouble(6));
        event.setPathToPicture(rsEvent.getString(7));
        return event;
    }
}
