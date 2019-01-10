package com.calendarofexibition.persistence.implementation;

import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;
import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.persistence.interfaces.OrderDAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
private FactoryConnection factoryConnection;
    private static volatile OrderDAOImpl instance;
    private final static Logger LOGGER = Logger.getLogger(OrderDAOImpl.class);
    private static final String GET_ALL_TICKETS = "SELECT * FROM tickets WHERE eventId IN ()";
    private static final String CREATE_ORDER = "INSERT INTO `calendarofexposition`.`orders` (consumerId, ticketId) VALUES (?,?)";
    private static final String GET_ALL_ORDERS = "SELECT * FROM orders";
    private static final String GET_ORDER_BY_CONSUMER_ID = "SELECT * FROM orders WHERE ConsumerId = ?";
    private static final String GET_ORDER_BY_TICKET_ID = "SELECT * FROM orders WHERE ThicketID = ?";
    private static final String GET_TICKETID_BY_KEY = "SELECT ticketId FROM tickets WHERE tickets.key = ?";
    private static final String CREATE_TICKET = "INSERT INTO `calendarofexposition`.`tickets` (`key`, `eventId`) VALUES (?,?)";

    private OrderDAOImpl() {
        factoryConnection = FactoryConnection.getInstance();
    }

    public static OrderDAOImpl getInstance() {
        if (instance == null) {
            synchronized (OrderDAOImpl.class){
                if(instance == null){
                    instance = new OrderDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Ticket> getAllTicketsForConsumer() {
        List<Ticket> list = new LinkedList<>();
        Ticket ticket;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_ALL_TICKETS)) {
            ResultSet rs = psEvent.executeQuery();
            while (rs.next()) {
                ticket = buildTicket(rs);
                list.add(ticket);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("All events was received from DB");
        return list;
    }

    @Override
    public Integer createOrder(Order order) {
        Integer orderId = -1;
            try (Connection connection = factoryConnection.getConnection();
                 PreparedStatement ps = connection.prepareStatement(CREATE_ORDER)) {
                ps.setInt(1, order.getConsumerId());
                System.out.println("ticketId: " + order.getTicket().getTicketId());
                ps.setInt(2, order.getTicket().getTicketId());
                        ps.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
            }
            LOGGER.info("List of Events by theme was received from DB");
            return orderId;
    }

    @Override
    public Integer getTicketIdByTicket(Ticket ticket) {
        Integer ticketId = -1;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_TICKETID_BY_KEY)) {
            ps.setString(1, ticket.getKey());
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    ticketId = rs.getInt(1);
                }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("List of Events by theme was received from DB");
        return ticketId;
    }

    @Override
    public Integer createTicket(Ticket ticket) {
        Integer ticketId = -1;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_TICKET)) {

            ps.setString(1, ticket.getKey());
            ps.setInt(2, ticket.getEvent().getEventId());

                    ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("List of Events by theme was received from DB");
        return ticketId;
    }

    @Override
    public Order getOrdersByaEvent(Integer id) {
        return null;
    }

    @Override
    public boolean saveOrder(Order order, Event event, int consumerId) {
        return false;
    }

    @Override
    public List<Order> getOrdersByConsumer(Consumer consumer) {
        return null;
    }

    @Override
    public List<Order> getActiveOrdersByConsumer(Consumer consumer) {
        return null;
    }

    private Ticket buildTicket (ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(rs.getInt(1));
        ticket.setKey(rs.getString(2));
        ticket.getEvent().setEventId(rs.getInt(3));
        return ticket;
    }
}
