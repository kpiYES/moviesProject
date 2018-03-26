package com.app.repository;

import com.app.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getAll();

    Genre create(Genre genre);

    void remove(Genre genre);
}
