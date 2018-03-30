package com.app.controller;

import com.app.model.Movie;
import com.app.service.MovieService;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllMovieCommand implements Command {

    private MovieService movieService;

    GetAllMovieCommand() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        List<Movie> getAllMovie = movieService.getAll();
        request.setAttribute("get_all_movie", getAllMovie);
    }
}

