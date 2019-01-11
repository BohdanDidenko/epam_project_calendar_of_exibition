package com.calendarofexibition.persistence;

import com.calendarofexibition.persistence.implementation.EventDAOImpl;
import com.calendarofexibition.persistence.implementation.ExpoHallDAOImpl;
import com.calendarofexibition.persistence.implementation.OrderDAOImpl;
import com.calendarofexibition.persistence.implementation.UserDAOImpl;
import com.calendarofexibition.persistence.interfaces.EventDAO;
import com.calendarofexibition.persistence.interfaces.ExpoHallDAO;
import com.calendarofexibition.persistence.interfaces.OrderDAO;
import com.calendarofexibition.persistence.interfaces.UserDAO;

public class FactoryDAO {

    private static volatile FactoryDAO instance;

    private FactoryDAO() {
    }

    public static FactoryDAO getInstance() {
        if(instance == null){
            synchronized (FactoryDAO.class){
                if(instance == null){
                    instance = new FactoryDAO();
                }
            }
        }
        return instance;
    }

    /**
     * @return instance of concrete UserDAO implementation.
     */
    public UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }

    /**
     * @return instance of concrete EventDAO implementation.
     */
    public EventDAO getEventDAO() {
        return EventDAOImpl.getInstance();
    }

    /**
     * @return instance of concrete ExpoHallDAO implementation.
     */
    public ExpoHallDAO getExpoHallDAO() {
        return ExpoHallDAOImpl.getInstance();
    }

    /**
     * @return instance of concrete OrderDAO implementation.
     */
    public OrderDAO getOrderDAO() {
        return OrderDAOImpl.getInstance();
    }
}

