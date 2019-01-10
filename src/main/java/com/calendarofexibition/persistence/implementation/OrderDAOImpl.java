package com.calendarofexibition.persistence.implementation;

import com.calendarofexibition.model.Order;
import com.calendarofexibition.model.Ticket;
import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.persistence.interfaces.OrderDAO;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
private FactoryConnection factoryConnection;
    private static volatile OrderDAOImpl instance;
    private final static Logger LOGGER = Logger.getLogger(OrderDAOImpl.class);
    private static final String CREATE_ORDER = "INSERT INTO orders (consumerId, ticketId) VALUES (?,?)";
    private static final String GET_ALL_ORDERS = "SELECT * FROM orders";
    private static final String GET_ORDER_BY_CONSUMER_ID = "SELECT * FROM orders WHERE ConsumerId = ?";
    private static final String GET_ORDER_BY_TICKET_ID = "SELECT * FROM orders WHERE ThicketID = ?";
    private static final String CREATE_TICKET = "INSERT INTO tickets (key, eventId) VALUES (?,?)";

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
    public Integer createOrder(Order order) {
        Integer orderId = -1;
            try (Connection connection = factoryConnection.getConnection();
                 PreparedStatement ps = connection.prepareStatement(CREATE_ORDER)) {
                ps.setInt(1, order.getConsumerId());
                ps.setInt(2, order.getTicketId());
                ResultSet rsOrder = ps.executeQuery();
                if (rsOrder.next()) {
                    System.out.println("after if");
                    orderId = rsOrder.getInt(1);
                }
            } catch (SQLException e) {
                LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
            }
            LOGGER.info("List of Events by theme was received from DB");
            return orderId;
    }

    @Override
    public Integer createTicket(Ticket ticket) {
        Integer ticketId = -1;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_TICKET)) {
            ps.setString(1, ticket.getKey());
            System.out.println("--------" + ticket.getEvent().getEventId());
            ps.setInt(2, ticket.getEvent().getEventId());
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
}
