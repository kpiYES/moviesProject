package com.app.service.impl;


import com.app.model.Director;
import com.app.repository.DataBase.DirectorRepository;
import com.app.repository.DataBase.impl.DirectorRepositoryImpl;
import com.app.service.DirectorService;
import com.app.util.Assert;

import java.util.List;

public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directorRepository;

    public DirectorServiceImpl() {

        directorRepository = new DirectorRepositoryImpl();
    }

    @Override
    public List<Director> getAll() {

        return directorRepository.getAll();
    }

    @Override
    public Director create(Director director) {
        Assert.notNull(director, "director must not be null.");
        return directorRepository.create(director);
    }

    @Override
    public void remove(Director director) {
        Assert.notNull(director, "director must not be null.");
        directorRepository.remove(director);
    }

    @Override
    public Director update(Director director) {
        Assert.notNull(director, "director must not be null.");
        return directorRepository.update(director);
    }


}
