package com.app.service;

import com.app.model.Genre;
import com.app.model.Movie;

public interface MovieGenreRelationService {
    void create(Movie movie, Genre genre);

    void remove(Movie movie);

    void update(Movie movie, Genre genre);

}
