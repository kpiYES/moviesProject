package com.app.service;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    List<Movie> getMoviesByGenre(Genre genre);
}
