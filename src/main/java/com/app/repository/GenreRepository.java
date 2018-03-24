package com.app.repository;

import com.app.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getAll();

    int putGenre(Genre genre);

    int removeGenre(Genre genre);
}
