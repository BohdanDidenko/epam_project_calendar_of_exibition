package com.calendarofexibition.controller.commands.impl;

import com.calendarofexibition.model.entity.Event;
import com.calendarofexibition.service.ServiceFactory;
import com.calendarofexibition.service.interfeices.EventService;
import com.calendarofexibition.util.PagesManager;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.calendarofexibition.controller.commands.*;

public class GetAllEventsPageCommand implements Command {

        private final static Logger LOGGER = Logger.getLogger(GetAllEventsPageCommand.class);

        @Override
        public String execute(HttpServletRequest request, HttpServletResponse response) {

            EventService eventService = ServiceFactory.getInstance().getEventService();

            List<Event> listAllEvents =  eventService.getAllExpositions();
            request.setAttribute("events", listAllEvents);
            LOGGER.info(this.getClass().getSimpleName() + " executed");
            return PagesManager.getProperty("path.page.events");
        }
    }
