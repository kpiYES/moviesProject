package com.app.service;

import com.app.model.Genre;
import com.app.model.Movie;

import java.util.List;
import java.util.Set;

public interface MovieGenreRelationService {
    void create(Movie movie, Genre genre);

    void remove(Movie movie);

    void update(Movie movie, Set<Genre> genre);

}
