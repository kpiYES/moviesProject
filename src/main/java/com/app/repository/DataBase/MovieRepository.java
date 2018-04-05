package com.app.repository.DataBase;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAll();

    List<Movie> getByGenre(Genre genre);

    Movie create(Movie movie);

    void remove(Movie movie);

    Movie update(Movie movie);

    Movie getByTitle(String title);
}
