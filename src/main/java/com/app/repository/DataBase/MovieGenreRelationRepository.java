package com.app.repository.DataBase;

import com.app.model.Genre;
import com.app.model.Movie;

public interface MovieGenreRelationRepository {
    void create(Movie movie, Genre genre);
    void remove(Movie movie);
}
