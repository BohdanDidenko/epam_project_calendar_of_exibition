package com.calendarofexibition.service.implementation;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.persistence.interfaces.UserDAO;
import com.calendarofexibition.persistence.implementation.UserDAOImpl;
import com.calendarofexibition.service.interfeices.ConsumerService;
import java.sql.SQLException;

public class ConsumerServiceImpl implements ConsumerService {

    private UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    public User getUser(Integer UserId) {
        return userDAO.getUser(UserId);
    }

    @Override
        public User getUser(String login, String password) {
            return userDAO.getUser(login, password);
    }

    @Override
    public Consumer getConsumer(String login, String password)  {
        return userDAO.getConsumer(login, password);
    }

    @Override
    public Integer createConsumer(Consumer consumer) {
        return userDAO.createConsumer(consumer);

    }

    @Override
    public Consumer getConsumer(int id)  {

        return userDAO.getConsumer(id);
    }

    @Override
    public Boolean updateConsumer(Consumer consumer) {
        return userDAO.updateConsumer(consumer);
    }

    @Override
    public Boolean checkUser(String login) {
        return userDAO.isExist(login);
    }
}
