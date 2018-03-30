package com.app.controller;

import com.app.model.Director;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class UpdateDirectorCommand implements Command {
    private DirectorService directorService;


    UpdateDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {



        Director director = new Director();
        director.setName(request.getParameter("director_name"));
        director.setDayOfBirth(LocalDate.parse(request.getParameter("director_day_of_birth")));
        director.setImage(request.getParameter("director_image"));

        Director updatedDirector = directorService.update(director);
        request.setAttribute("updated_director", updatedDirector);
    }
}



