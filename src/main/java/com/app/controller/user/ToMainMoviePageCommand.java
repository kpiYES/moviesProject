package com.app.controller.user;

import com.app.controller.Command;
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

        Genre genreForMovie = genreService.getByType(request.getParameter("typeOfGenre"));
        List<Movie> movieList = movieService.getByGenre(genreForMovie);

        for (Movie movie : movieList) {
            movie.setDirector(directorService.getByMovie(movie));
        }

        request.setAttribute("typeOfGenre", genreForMovie.getTypeOfGenre());
        request.setAttribute("movieList", movieList);
        request.setAttribute("jsp", "mainMoviePage.jsp");
    }
}
