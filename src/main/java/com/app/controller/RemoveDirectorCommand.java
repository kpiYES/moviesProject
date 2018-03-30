package com.app.controller;

import com.app.model.Director;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveDirectorCommand implements Command {

    private DirectorService directorService;

    public RemoveDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Director director = new Director();
        director.setName(request.getParameter("director_name"));

        directorService.remove(director);
    }
}
