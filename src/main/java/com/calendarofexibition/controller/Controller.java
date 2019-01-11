package com.calendarofexibition.controller;

import com.calendarofexibition.exceptions.RegistrationException;
import com.calendarofexibition.persistence.implementation.UserDAOImpl;
import com.calendarofexibition.util.PagesManager;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.calendarofexibition.controller.commands.*;

public class Controller extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processing(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processing(req, resp);
    }

    private void  processing (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info(this.getClass().getSimpleName() + " processing new request");

        ControllerHelper controllerHelper = ControllerHelper.getInstance();
        String parameter = req.getParameter("command");
        Command command = controllerHelper.defineCommand(parameter);

        String page = "";
        try {
            page = command.execute(req, resp);
        } catch (RegistrationException e) {
            req.setAttribute("message", e.getCause());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PagesManager.getProperty("path.page.login"));
            dispatcher.forward(req, resp);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }
}
