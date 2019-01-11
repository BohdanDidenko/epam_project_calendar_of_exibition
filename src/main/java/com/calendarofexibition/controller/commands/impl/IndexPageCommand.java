package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.controller.commands.*;
import com.calendarofexibition.util.PagesManager;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexPageCommand implements Command {

    private final static Logger LOGGER = Logger.getLogger(IndexPageCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        LOGGER.info(this.getClass().getSimpleName() + " executed");
        return PagesManager.getProperty("path.page.index");
    }
}
