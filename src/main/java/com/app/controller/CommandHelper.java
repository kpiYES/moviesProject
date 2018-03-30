package com.app.controller;

import com.app.exceptions.UnsupportedCommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commandsMap = new HashMap<>();

    CommandHelper() {
        commandsMap.put("GetAllGenre", new GetAllGenreCommand());
        commandsMap.put("Create genre", new CreateGenreCommand());
        commandsMap.put("Remove genre", new RemoveGenreCommand());

        commandsMap.put("GetAllDirector", new GetAllDirectorCommand());
        commandsMap.put("Create director", new CreateDirectorCommand());
        commandsMap.put("Remove director", new RemoveDirectorCommand());
        commandsMap.put("Update director", new UpdateDirectorCommand());

        commandsMap.put("GetAllMovie", new GetAllMovieCommand());
        commandsMap.put("Create movie", new CreateMovieCommand());
        commandsMap.put("Remove movie", new RemoveMovieCommand());
        commandsMap.put("Update movie", new UpdateMovieCommand());


    }


    public Command chooseCommand(HttpServletRequest request) {

        final String commandSignature = request.getParameter("command");
        if (!commandsMap.containsKey(commandSignature)) {
            throw new UnsupportedCommandException(commandSignature);
        }
        return commandsMap.get(commandSignature);
    }

}
