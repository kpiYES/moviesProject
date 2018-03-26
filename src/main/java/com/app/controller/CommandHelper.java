package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commandsMap = new HashMap<>();

    CommandHelper() {
        commandsMap.put("DeleteGenre", new DeleteGenreCommand());
        commandsMap.put("AddGenre", new AddGenreCommand());
    }


    public Command chooseCommand(HttpServletRequest request) {

        Command command;

        return command = commandsMap.get(request.getParameter("command"));
    }

}
