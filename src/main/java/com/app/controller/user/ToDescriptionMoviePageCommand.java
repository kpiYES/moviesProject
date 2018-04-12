package com.app.controller.user;

import com.app.controller.Command;
import com.app.model.Movie;
import com.app.service.DirectorService;
import com.app.service.GenreService;
import com.app.service.MovieService;
import com.app.service.impl.DirectorServiceImpl;
import com.app.service.impl.GenreServiceImpl;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToDescriptionMoviePageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        GenreService genreService = new GenreServiceImpl();
        DirectorService directorService = new DirectorServiceImpl();
        MovieService movieService = new MovieServiceImpl();

        Movie movie = movieService.getByTitle(request.getParameter("title"));
        movie.setGenres(genreService.getSetByMovie(movie));
        movie.setDirector(directorService.getByMovie(movie));


        request.setAttribute("movie", movie);
        request.setAttribute("jsp", "descriptionMoviePage.jsp");
    }
}

