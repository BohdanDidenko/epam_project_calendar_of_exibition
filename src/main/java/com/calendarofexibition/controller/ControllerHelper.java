package com.calendarofexibition.controller;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.controller.commands.impl.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerHelper {

    private static ControllerHelper instance;
    private Map<String, Command> commandsMap = new HashMap<>();
    ControllerHelper() {
        commandsMap.put("index", new IndexPageCommand());
        commandsMap.put("events", new GetAllEventsPageCommand());
        commandsMap.put("profile", new ConsumerPageCommand());
        commandsMap.put("login", new LoginCommand());
        commandsMap.put("loginPage", new LoginPageCommand());
        commandsMap.put("regPage", new RegistrationPageCommand());
        commandsMap.put("reg", new RegistrationCommand());
        commandsMap.put("buyTicket", new BuyTicketCommand());
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }

    public Command defineCommand(String commandKey) {
        System.out.println("command: " + commandKey);
        Command command = commandsMap.get(commandKey);
        System.out.println("helper, command: "+command);
        if (command == null) {
            command = commandsMap.get("index");
        }
        return command;
    }

   /* public Map<String, String> extractParameters(HttpServletRequest request) {
        Map<String, String> requestParameters = new HashMap<>();
        List<String> parameters = Collections.list(request.getParameterNames());
        for (String param : parameters) {
            requestParameters.put(param, request.getParameter(param));
        }
        return requestParameters;
    }*/
}
