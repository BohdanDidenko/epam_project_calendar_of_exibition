package com.calendarofexibition.persistence.abstraction;


import com.expocalendar.project.persistence.abstraction.interfaces.*;
import com.expocalendar.project.persistence.implementation.mysql.MySQLDAOFactory;

public abstract class FactoryDAO {

    public static final int MYSQL = 1;

    /**
     * @return instance of concrete AccountDAO implementation.
     */
    public abstract ConsumerDAO getAccountDAO();

    /**
     * @return instance of concrete ExpoHallDAO implementation.
     */
    public abstract ExpoHallDAO getExpoHallDAO();
    /**
     * @return instance of concrete ExpositionDAO implementation.
     */
    public abstract EventDAO getExpositionDAO();
    /**
     * @return instance of concrete CreditCardDAO implementation.
     */
    public abstract OrderDAO getCreditCardDAO();
    /**
     * @return instance of concrete OrderDAO implementation.
     */
    public abstract OrderDAO getOrderDAO();

    /**
     * @return concrete FactoryDAO implementation
     */
    public static FactoryDAO getDAOFactory(int factory) {
        FactoryDAO factoryDAO = null;

        switch (factory) {
            case MYSQL:
                factoryDAO = new MySQLDAOFactory();
        }
        return factoryDAO;
    }


}
