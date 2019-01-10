package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.*;
import com.calendarofexibition.util.PagesManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//private final static Logger LOGGER = Logger.getLogger(GetAllEventsCommand.class);

public class IndexPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //electionService selectionService = new SelectionServiceImpl(new EventDaoImpl());

       // LOGGER.info(this.getClass().getSimpleName() + " executed");

        return PagesManager.getProperty("path.page.index");
    }
}
