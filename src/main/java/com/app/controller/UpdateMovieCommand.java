package com.app.controller;

import com.app.model.Movie;
import com.app.service.MovieService;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMovieCommand implements Command {
    private MovieService movieService;

    UpdateMovieCommand() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Movie movie = new Movie();
        movie.setDirector_id(Long.parseLong(request.getParameter("movie_director_id")));
        movie.setTitle(request.getParameter("movie_title"));
        movie.setRuntime(Integer.parseInt(request.getParameter("movie_runtime")));
        movie.setDescribtion(request.getParameter("movie_describtion"));
        movie.setImage(request.getParameter("movie_image"));

        Movie updatedMovie = movieService.update(movie);
        request.setAttribute("updated_movie", updatedMovie);
    }
}
