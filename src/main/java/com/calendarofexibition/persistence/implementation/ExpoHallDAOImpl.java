package com.calendarofexibition.persistence.implementation;

import com.calendarofexibition.model.ExpoHall;
import com.calendarofexibition.persistence.interfaces.ExpoHallDAO;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ExpoHallDAOImpl implements ExpoHallDAO {
    private static volatile ExpoHallDAOImpl instance;
    private static FactoryConnection factoryConnection;
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
    private static final String GET_ALL_ExpoHall = "SELECT * FROM expohalls";
    private static final String UPDATE_EVENT = "UPDATE expohalls SET hallId, name, isAvailable, freePlaces (?, ?, ?, ?)";

    private ExpoHallDAOImpl() { factoryConnection = FactoryConnection.getInstance();}

    public static ExpoHallDAOImpl getInstance() {
        if (instance == null) {
            synchronized (ExpoHallDAOImpl.class){
                if(instance == null){
                    instance = new ExpoHallDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<com.calendarofexibition.model.ExpoHall> findAllHalls() {
        List<ExpoHall> list = new LinkedList<>();
        ExpoHall expoHall;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psEvent = connection.prepareStatement(GET_ALL_ExpoHall)) {
            ResultSet rsExpoHall = psEvent.executeQuery();
            while (rsExpoHall.next()) {
                expoHall = builExpodHall(rsExpoHall);
                list.add(expoHall);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("All ExpoHalls was received from DB");
        return list;
    }

    @Override
    public Boolean updateExpoHall(ExpoHall expoHall) {
        Boolean result = false;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(UPDATE_EVENT)) {
            psUpdate.setInt(1, expoHall.getHallId());
            psUpdate.setString(2, expoHall.getName());
            psUpdate.setBoolean(3, expoHall.getAvailable());
            psUpdate.setInt(4, expoHall.getFreePlaces());
            psUpdate.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("ExpoHall was updated in DB");
        return result;
    }


    private ExpoHall builExpodHall (ResultSet rsExpoHall) throws SQLException {
            ExpoHall expoHall = new ExpoHall();
            expoHall.setHallId(rsExpoHall.getInt(1));
            expoHall.setName(rsExpoHall.getString(2));
            expoHall.setAvailable(rsExpoHall.getBoolean(3));
            expoHall.setFreePlaces(rsExpoHall.getInt(4));
        return expoHall;
    }
}
