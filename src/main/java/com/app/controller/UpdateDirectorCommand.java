package com.app.controller;

import com.app.model.Director;
import com.app.repository.Server.ServerRepository;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class UpdateDirectorCommand implements Command {

    final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Misha\\IdeaProjects\\uploadLocation\\Directors\\Images\\";
    private DirectorService directorService;


    UpdateDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {


        ServerRepository serverRepository = new ServerRepository();
        String image = serverRepository.uploadToServer(request, PATH_TO_STORE_OF_IMAGES, request.getParameter("name"), "image");

        Director directorForRemoving = directorService.getByName(request.getParameter("name"));

        Director director = new Director();
        director.setName(request.getParameter("name"));
        director.setDayOfBirth(LocalDate.parse(request.getParameter("day_of_birth")));
        director.setImage(image);

        Director updatedDirector = directorService.update(director);

        serverRepository.removeFile(directorForRemoving.getImage());

        request.setAttribute("updated_director", updatedDirector);
        request.setAttribute("result", "Director has successfully updated!");
        request.setAttribute("jsp", "views/directorChange.jsp");
    }
}



