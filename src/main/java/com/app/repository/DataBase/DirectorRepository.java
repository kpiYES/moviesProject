package com.app.repository.DataBase;

import com.app.model.Director;
import com.app.model.Movie;

import java.util.List;

public interface DirectorRepository {

    List<Director> getAll();

    Director create(Director director);

    void remove(Director director);

    Director update(Director director);

    Director getByName(String name);

    Director getByMovie(Movie movie);

    boolean checkOnExist(String name);
}
