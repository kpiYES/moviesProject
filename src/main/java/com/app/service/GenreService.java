package com.app.service;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;
import java.util.Set;

public interface GenreService {
    List<Genre> getAll();

    Genre create(Genre genre);

    void remove(Genre genre);

    Genre getByType(String type);

    boolean checkOnExist(String typeOfGenre);

    Set<Genre> getSetByMovie(Movie movie);

}
