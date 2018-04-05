package com.app.controller;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.model.Movie;
import com.app.service.DirectorService;
import com.app.service.GenreService;
import com.app.service.MovieService;
import com.app.service.impl.DirectorServiceImpl;
import com.app.service.impl.GenreServiceImpl;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ToMainMoviePageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        GenreService genreService = new GenreServiceImpl();
        DirectorService directorService = new DirectorServiceImpl();
        MovieService movieService = new MovieServiceImpl();
        Genre genreForMovie = (Genre) request.getSession().getAttribute("genreForMovie");
        List<Movie> movieList = movieService.getByGenre(genreForMovie);

        for(Movie movie : movieList){
            movie.setGenres(genreService.getSetByMovie(movie));
            movie.setDirector(directorService.getByMovie(movie));
        }
        System.out.println(genreForMovie.getTypeOfGenre());
        request.setAttribute("typeOfGenre", genreForMovie.getTypeOfGenre());
        request.setAttribute("movieList", movieList);
        request.setAttribute("jsp", "mainMoviePage.jsp");
    }
}
