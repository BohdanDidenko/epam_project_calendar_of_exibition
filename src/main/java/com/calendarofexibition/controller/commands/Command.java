package com.calendarofexibition.controller.commands;

import com.calendarofexibition.exceptions.RegistrationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest req, HttpServletResponse resp) throws RegistrationException;
}
