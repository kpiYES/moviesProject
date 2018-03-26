package com.app.service;

import com.app.model.Director;

import java.util.List;

public interface DirectorService {
    List<Director> getListOfDirectors();

    int addDirector(Director director);

    int deleteDirector(Director director);

    int updateDirector(Director director);
}
