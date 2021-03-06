package com.app.service;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getByGenre(Genre genre);

    Movie create(Movie movie);

    void remove(Movie movie);

    Movie update(Movie movie);

    Movie getByTitle(String title);

    List<Movie> getByDirector(Director director);
}
