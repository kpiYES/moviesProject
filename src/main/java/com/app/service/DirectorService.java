package com.app.service;

import com.app.model.Director;

import java.util.List;

public interface DirectorService {
    List<Director> getAll();

    Director create(Director director);

    void remove(Director director);

    Director update(Director director);
}
