package com.app.repository;

import com.app.model.Director;

import java.util.List;

public interface DirectorRepository {

    List<Director> getDirectorList();

    int putDirector(Director director);

    int deleteDirector(Director director);

    int updateDirector(Director director);
}
