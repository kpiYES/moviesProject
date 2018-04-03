package com.app.repository.DataBase;

import com.app.model.Genre;

import java.util.List;
import java.util.Set;

public interface GenreRepository {
    List<Genre> getAll();

    Genre create(Genre genre);

    void remove(Genre genre);

    Genre getByTitle(String title);

    boolean checkOnExist(String typeOfGenre);
}

