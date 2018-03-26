package com.app.service;

import com.app.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getListOfGenre();

    int addGenre(Genre genre);

    int deleteGenre(Genre genre);
}
