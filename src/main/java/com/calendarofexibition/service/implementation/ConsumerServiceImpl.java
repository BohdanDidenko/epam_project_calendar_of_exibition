package com.calendarofexibition.service.implementation;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.persistence.interfaces.UserDAO;
import com.calendarofexibition.persistence.implementation.UserDAOImpl;
import com.calendarofexibition.service.interfeices.ConsumerService;
import org.apache.log4j.Logger;

public class ConsumerServiceImpl implements ConsumerService {
    private final static Logger LOGGER = Logger.getLogger(ConsumerServiceImpl.class);
    private UserDAO userDAO;

    public ConsumerServiceImpl() {
        this.userDAO = UserDAOImpl.getInstance();
    }

    @Override
    public User getUser(Integer UserId) {
        LOGGER.info("serviceLevel: getUser by id");
        return userDAO.getUser(UserId);
    }

    @Override
    public User getUser(String login, String password) {
        LOGGER.info("serviceLevel: getUser by login and password");
        return userDAO.getUser(login, password);
    }

    @Override
    public Consumer getConsumer(String login, String password)  {
        LOGGER.info("serviceLevel: getConsumer by login adn password");
        return userDAO.getConsumer(login, password);
    }

    @Override
    public Integer createConsumer(Consumer consumer) {
        LOGGER.info("serviceLevel: createConsumer");
        return userDAO.createConsumer(consumer);
    }

    @Override
    public Consumer getConsumer(int id)  {
        LOGGER.info("serviceLevel: getConsumer by id");
        return userDAO.getConsumer(id);
    }

    @Override
    public Boolean updateConsumer(Consumer consumer) {
        LOGGER.info("serviceLevel: updateConsumer");
        return userDAO.updateConsumer(consumer);
    }

    @Override
    public Boolean checkUser(String login) {
        LOGGER.info("serviceLevel: checkUser by login");
        return userDAO.isExist(login);
    }
}
