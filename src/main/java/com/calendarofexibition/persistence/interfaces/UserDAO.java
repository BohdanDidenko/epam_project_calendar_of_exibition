package com.calendarofexibition.persistence.interfaces;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.User;

import java.sql.SQLException;

/**
 * User Data Access Object interface
 */
public interface UserDAO {

    /**
     * @param UserId    Consumer's Id in database
     * @return Cunsumer found in database with requested login and password
     */

    User getUser(Integer UserId);

    /**
     * @param login    User's login
     * @param password User's password
     * @return Cunsumer found in database with requested login and password
     */
    User getUser(String login, String password);

    /**
     * @param id Consumer's id
     * @return Cunsumer found in database with User's id
     */

    Consumer getConsumer(int id);

    /**
     * @param login Consumer's login
     * @param password Consumer's password
     * @return Cunsumer found in database with User's id
     */
    Consumer getConsumer(String login, String password);


    /**
     * @param consumer will be created in database
     * @return boolean result of transaction success
     */
    Integer createConsumer(Consumer consumer);

    /**
     * @param consumer will be updated in database
     * @return boolean result of operation success
     */
    Boolean updateConsumer(Consumer consumer);
    /**
     * @param login login of special user
     * @return boolean result of operation success
     */
    Boolean isExist(String login);

}
