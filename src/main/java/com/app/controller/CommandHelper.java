package com.app.controller;

import com.app.exceptions.UnsupportedCommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commandsMap = new HashMap<>();

    CommandHelper() {
        commandsMap.put("DeleteGenre", new RemoveGenreCommand());
        commandsMap.put("AddGenre", new CreateGenreCommand());
    }


    public Command chooseCommand(HttpServletRequest request) {

        final String commandSignature = request.getParameter("command");
        if (!commandsMap.containsKey(commandSignature)) {
            throw new UnsupportedCommandException(commandSignature);
        }
        return commandsMap.get(commandSignature);
    }

}
