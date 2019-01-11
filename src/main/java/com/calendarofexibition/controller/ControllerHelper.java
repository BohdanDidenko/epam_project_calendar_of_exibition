package com.calendarofexibition.controller;

import com.calendarofexibition.controller.commands.Command;
import com.calendarofexibition.controller.commands.impl.*;import java.util.HashMap;
import java.util.Map;

public class ControllerHelper {

    private static volatile ControllerHelper instance;
    private Map<String, Command> commandsMap = new HashMap<>();

    private ControllerHelper() {
        commandsMap.put("index", new IndexPageCommand());
        commandsMap.put("events", new GetAllEventsPageCommand());
        commandsMap.put("profile", new ConsumerPageCommand());
        commandsMap.put("login", new LoginCommand());
        commandsMap.put("logout", new LogoutCommand());
        commandsMap.put("loginPage", new LoginPageCommand());
        commandsMap.put("regPage", new RegistrationPageCommand());
        commandsMap.put("reg", new RegistrationCommand());
        commandsMap.put("buyTicket", new BuyTicketCommand());
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            synchronized (ControllerHelper.class){
                if (instance == null) {
                    instance = new ControllerHelper();
                }
            }
        }
        return instance;
    }

    public Command defineCommand(String commandKey) {
        Command command = commandsMap.get(commandKey);
        if (command == null) {
            command = commandsMap.get("index");
        }
        return command;
    }
}
