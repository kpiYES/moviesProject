package com.app.controller;

import com.app.model.Director;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class AddDirectorCommand implements Command {
    private DirectorService directorService;


    AddDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Director director = new Director();
        director.setName(request.getParameter("name_add"));
        director.setDayOfBirth(LocalDate.parse(request.getParameter("day_of_birth_add")));
        director.setImage(request.getParameter("image_add"));
        if (directorService.addDirector(director) == 1) {
            return "Operation has been successfully completed";
        }
        return "Operation hasn't successfully completed ";
    }
}

