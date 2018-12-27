package com.calendarofexibition.persistence.implementation.mysql;

import com.expocalendar.project.persistence.abstraction.DAOFactory;
import com.expocalendar.project.persistence.abstraction.interfaces.*;


public class MySQLDAOFactory extends DAOFactory {

    @Override
    public UserDAO getAccountDAO() {
        return MySQLAccountDAO.getInstance();
    }

    @Override
    public ExpoHallDAO getExpoHallDAO() {
        return MySQLExpoHallDAO.getInstance();
    }

    @Override
    public EventDAO getExpositionDAO() {
        return MySQLExpositionDAO.getInstance();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return MySQLOrderDAO.getInstance();
    }
}
