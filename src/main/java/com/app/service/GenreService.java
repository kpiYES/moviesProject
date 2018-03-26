package com.app.service;

import com.app.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    Genre create(Genre genre);

    void remove(Genre genre);
}
