package com.app.repository.DataBase;

import com.app.model.Director;

import java.util.List;

public interface DirectorRepository {

    List<Director> getAll();

    Director create(Director director);

    void remove(Director director);

    Director update(Director director);

    Director getByName(String name);

    boolean checkOnExist(String name);
}
