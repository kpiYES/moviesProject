package com.app.repository.DataBase;

import com.app.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getAll();

    Genre create(Genre genre);

    void remove(Genre genre);
}

