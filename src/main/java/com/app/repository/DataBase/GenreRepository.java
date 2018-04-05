package com.app.repository.DataBase;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;
import java.util.Set;

public interface GenreRepository {
    List<Genre> getAll();

    Genre create(Genre genre);

    void remove(Genre genre);

    Genre getByType(String type);

    Set<Genre> getSetByMovie(Movie movie);

    boolean checkOnExist(String typeOfGenre);
}

