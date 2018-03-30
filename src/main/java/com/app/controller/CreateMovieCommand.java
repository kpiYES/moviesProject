package com.app.controller;

import com.app.model.Movie;
import com.app.repository.Server.ServerRepository;
import com.app.service.MovieService;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateMovieCommand implements Command {

    static final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Misha\\IdeaProjects\\Store\\Movies\\Images\\";
    static final private String PATH_TO_STORE_OF_DESCRIPTIONS = "C:\\Users\\Misha\\IdeaProjects\\Store\\Directors\\Descriptions\\";

    private MovieService movieService;

    CreateMovieCommand() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        ServerRepository serverRepository = new ServerRepository();
        String image = serverRepository.saveToServer(request, PATH_TO_STORE_OF_IMAGES, request.getParameter("title"), request.getParameter("image"));
        String description = serverRepository.saveToServer(request, PATH_TO_STORE_OF_DESCRIPTIONS, request.getParameter("title"), request.getParameter("description"));



        Movie movie = new Movie();
        movie.setDirector_id(Long.parseLong(request.getParameter("director_id")));
        movie.setTitle(request.getParameter("title"));
        movie.setRuntime(Integer.parseInt(request.getParameter("runtime")));
        movie.setDescribtion("description");
        movie.setImage("image");

        Movie createdMovie = movieService.create(movie);
        request.setAttribute("created_movie", createdMovie);
    }
}
