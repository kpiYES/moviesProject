package com.app.controller;

import com.app.model.Movie;
import com.app.repository.Server.ServerRepository;
import com.app.service.MovieGenreRelationService;
import com.app.service.MovieService;
import com.app.service.impl.MovieGenreRelationServiceImpl;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveMovieCommand implements Command {

    private MovieService movieService;

    RemoveMovieCommand() {
        movieService = new MovieServiceImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Movie movie = movieService.getByTitle(request.getParameter("title"));

        MovieGenreRelationService movieGenreRelationService = new MovieGenreRelationServiceImpl();
        movieGenreRelationService.remove(movie);

        movieService.remove(movie);

        ServerRepository serverRepository = new ServerRepository();
        serverRepository.removeFile(movie.getImage());
        serverRepository.removeFile(movie.getDescription());



        request.setAttribute("result", "Movie has successfully removed!");
        request.setAttribute("jsp", "movieChange.jsp");
    }
}
