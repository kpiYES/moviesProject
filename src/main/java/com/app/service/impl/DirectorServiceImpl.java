package com.app.service.impl;


import com.app.model.Director;
import com.app.repository.DirectorRepository;
import com.app.repository.impl.DirectorRepositoryImpl;
import com.app.service.DirectorService;

import java.util.List;

public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directorRepository;

    public DirectorServiceImpl() {

        directorRepository = new DirectorRepositoryImpl();
    }

    @Override
    public List<Director> getListOfDirectors() {

        return directorRepository.getDirectorList();
    }

    @Override
    public int addDirector(Director director) {
        return directorRepository.putDirector(director);
    }

    @Override
    public int deleteDirector(Director director) {
        return directorRepository.deleteDirector(director);
    }

    @Override
    public int updateDirector(Director director) {
        return directorRepository.updateDirector(director);
    }


}
