package com.app.controller;

import com.app.model.Movie;
import com.app.service.MovieService;
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

        Movie movie = new Movie();
        movie.setTitle(request.getParameter("movie_title"));

        movieService.remove(movie);


    }
}
