package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.util.PagesManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return PagesManager.getProperty("path.page.registration");
    }
}
