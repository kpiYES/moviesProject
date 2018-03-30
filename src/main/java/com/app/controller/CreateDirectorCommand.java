package com.app.controller;

import com.app.model.Director;
import com.app.repository.Server.ServerRepository;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class CreateDirectorCommand implements Command {

    static final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Misha\\IdeaProjects\\Store\\Directors\\Images\\";
    private DirectorService directorService;

    CreateDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {



        ServerRepository serverRepository = new ServerRepository();
        String image = serverRepository.saveToServer(request, PATH_TO_STORE_OF_IMAGES, request.getParameter("name"), request.getParameter("image"));


        Director director = new Director();
        director.setName(request.getParameter("name"));
        director.setDayOfBirth(LocalDate.parse(request.getParameter("day_of_birth")));
        director.setImage(image);

        Director createdDirector = directorService.create(director);
        request.setAttribute("created_director", createdDirector);
    }
}

