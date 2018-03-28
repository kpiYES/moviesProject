package com.app.repository;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAll();

    List<Movie> getByGenre(Genre genre);

    Movie create(Movie movie, String directorsName);

    void remove(Movie movie);
}
