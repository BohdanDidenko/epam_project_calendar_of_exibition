package com.calendarofexibition.service.interfeices;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.User;

public interface ConsumerService {

        /**
         * @param login    User's login
         * @param password User's password
         * @return User obtain in database with requested login and password
         */
        User getUser(String login, String password);
        /**
         * @param UserId    User's Id in database
         * @return User obtain in database with requested login and password
         */
        User getUser(Integer UserId);

        /**
         * @param login Consumer's login
         * @param password Consumer's password
         * @return Cunsumer found in database with User's id
         */
        Consumer getConsumer(String login, String password);

        /**
         * @param id Consumer's id
         * @return Cunsumer found in database with User's id
         */
        Consumer getConsumer(int id);

        /**
         * @param consumer will be created in database
         * @return id of consumer
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
       Boolean checkUser(String login);
}
