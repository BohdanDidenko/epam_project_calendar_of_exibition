package com.calendarofexibition.persistence.abstraction.interfaces;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.User;

/**
 * User Data Access Object interface
 */
public interface UserDAO {

    /**
     * @param login    User's login
     * @param password User's password
     * @return Consumer found in database with requested login and password
     */
    User findUser(String login, String password);

    /**
     * @param consumer will be created in database
     * @return boolean result of transaction success
     */
    boolean createConsumer(Consumer consumer);

    /**
     * @param login requested
     * @return boolean result depending on account with this login exist's in database
     */
    boolean isExist(String login);

    /**
     * @param consumer will be updated in database
     * @return boolean result of operation success
     */
    boolean updateConsumer(Consumer consumer);

}
