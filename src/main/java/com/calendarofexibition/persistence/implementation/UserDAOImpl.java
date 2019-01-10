package com.calendarofexibition.persistence.implementation;

import com.calendarofexibition.model.entity.Consumer;
import com.calendarofexibition.model.entity.User;
import com.calendarofexibition.persistence.interfaces.UserDAO;
import org.apache.log4j.Logger;
import java.sql.*;

public class UserDAOImpl implements UserDAO {
    private static volatile UserDAOImpl instance;
    private FactoryConnection factoryConnection;
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
    private static final int ID = 1;
    private static final int ROLE = 2;
    private static final int FIRST_NAME = 2;
    private static final int LAST_NAME = 3;
    private static final int LOGIN = 4;
    private static final int PASSWORD = 5;
    private static final int EMAIL = 7;
    private static final String GET_CONSUMER_BY_ID = "SELECT * FROM consumers WHERE UserId = ?";
    private static String GET_CONSUMER = "SELECT * FROM consumers WHERE UserId IN (SELECT UserId FROM users WHERE UserLogin = ";
    private static final String GET_USER = "SELECT * FROM users WHERE UserLogin = ? and UserPassword = ?";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE UserId = ?";
    private static final String GET_USER_ISACTIVE = "SELECT isActive FROM users WHERE (username, password) VALUES (?,?)";
    private static final String INSERT_USER = "INSERT INTO users (UserRole, UserLogin, UserPassword, IsActive)"+
    "VALUES('consumer', ?, ?, 1)";
    private static final String INSERT_CONSUMER = "INSERT INTO consumers (userid, name, surname, spendMoney, discount, email, phoneNumber)"+
    "VALUES(LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT = "UPDATE consumers SET name, surname, spendMoney, discount, email, phoneNumber" +
            " WHERE userId  VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_LOGIN = "SELECT * FROM users WHERE login = ?";

    private UserDAOImpl() {
        factoryConnection = FactoryConnection.getInstance();
    }

    public static UserDAOImpl getInstance() {
        if (instance == null) {
            synchronized (UserDAOImpl.class){
                if(instance == null){
                    instance = new UserDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public User getUser(String login, String password) {
        User user = new Consumer();
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
//            String role = rs.getString(2);
//            if(role.equals("consumer")){
//
//            }
//            else if(role.equals("admin")){
//
//            }
            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setRole(rs.getString(2));
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Requested User was found in DB");
        return user;
    }

    @Override
    public User getUser(Integer UserId) {
        User user = new Consumer();
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID)) {
            ps.setInt(1, UserId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Requested User was found in DB");
        return user;
    }

    @Override
    public Consumer getConsumer(String login, String password){
        Consumer consumer = new Consumer();
        GET_CONSUMER = GET_CONSUMER +"\'" + login + "\' and userpassword = \'" + password +"\')";
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psConsumer = connection.prepareStatement(GET_CONSUMER)) {
            ResultSet rsConsumer = psConsumer.executeQuery();
            consumer = consumerHelper(rsConsumer);
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Requested Consumer was found in DB");
        return consumer;
    }

    @Override
    public Consumer getConsumer(int id){
        Consumer consumer = new Consumer();

        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement psConsumer = connection.prepareStatement(GET_CONSUMER_BY_ID)) {
            psConsumer.setInt(1, id);
            ResultSet rsConsumer = psConsumer.executeQuery();
           consumer = consumerHelper(rsConsumer);
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Requested Consumer was found in DB");
        return consumer;
    }

    @Override
    public Integer createConsumer(Consumer consumer) {
            Integer id = null;
            User user = null;
            try (Connection connection = factoryConnection.getConnection();
                PreparedStatement ps1 = connection.prepareStatement(INSERT_USER);
                PreparedStatement ps2 = connection.prepareStatement(INSERT_CONSUMER)) {

                ps1.setString(1, consumer.getLogin());
                ps1.setString(2, consumer.getPassword());

                ps2.setString(1, consumer.getName());
                ps2.setString(2, consumer.getSurname());
                ps2.setDouble(3, consumer.getSpentMoney());
                ps2.setDouble(4, consumer.getDiscount());
                ps2.setString(5, consumer.getEmail());
                ps2.setString(6, consumer.getPhoneNumber());
                connection.setAutoCommit(false);
                try{
                    ps1.executeUpdate();
                }
                catch (SQLException e){
                    e.printStackTrace();
                    connection.rollback();
                    System.out.println("1st request rollback");
                   return -1;
                }
                try{
                    id = ps2.executeUpdate();
                    System.out.println("id: " + id);
                   connection.commit();
                }
                catch (SQLException e){
                    connection.rollback();
                    LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
                    return -1;
                }

            } catch (SQLException e) {
                LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
            }
            LOGGER.info("Consumer was successfully added");
        return id;
    }


    @Override
    public Boolean updateConsumer(Consumer consumer) {
        boolean flag = false;
        try (Connection connection = factoryConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_ACCOUNT)) {
            ps.setString(1, consumer.getName());
            ps.setString(2, consumer.getSurname());
            ps.setDouble(3, consumer.getSpentMoney());
            ps.setDouble(4, consumer.getDiscount());
            ps.setString(5, consumer.getEmail());
            ps.setString(6, consumer.getPhoneNumber());
            ps.setInt(   7,  consumer.getId());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            LOGGER.error("SQLException was occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Consumer data was updated");
        return flag;
    }

    @Override
    public Boolean isExist(String login) {
        boolean exist = false;
        try (Connection connection = factoryConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_LOGIN)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            exist = rs.next();

        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in " + getClass().getSimpleName(), e);
        }
        LOGGER.info("Account existence checked in DB");
        return exist;
    }

    private Consumer consumerHelper(ResultSet rs) throws SQLException {
        Consumer consumer = new Consumer();
        if (rs.next()) {
            consumer.setId(rs.getInt(1));
            consumer.setName(rs.getNString(2));
            consumer.setSurname(rs.getString(3));
            consumer.setSpentMoney(rs.getDouble(4));
            consumer.setDiscount(rs.getDouble(5));
            consumer.setEmail(rs.getString(6));
            consumer.setPhoneNumber(rs.getString(7));
        }
        return consumer;
    }
}
