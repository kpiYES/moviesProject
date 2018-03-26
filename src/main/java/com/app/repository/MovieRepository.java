package com.app.repository;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovieList();

    List<Movie> getMovieListByGenre(Genre genre);
}
