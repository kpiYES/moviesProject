package com.app.controller.user;

import com.app.controller.Command;
import com.app.model.Director;
import com.app.service.DirectorService;
import com.app.service.MovieService;
import com.app.service.impl.DirectorServiceImpl;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToDirectorPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        MovieService movieService = new MovieServiceImpl();
        DirectorService directorService = new DirectorServiceImpl();
        Director director = directorService.getByName(request.getParameter("name"));
        director.setMovies(movieService.getByDirector(director));

        request.setAttribute("director", director);
        request.setAttribute("jsp", "directorPage.jsp");
    }
}
