package com.calendarofexibition.controller.commands;

import com.calendarofexibition.exceptions.RegistrationException;
import com.calendarofexibition.persistence.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    String execute(HttpServletRequest req, HttpServletResponse resp) throws RegistrationException, ServletException, IOException;
}
