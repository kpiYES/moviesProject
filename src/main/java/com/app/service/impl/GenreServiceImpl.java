package com.app.service.impl;

import com.app.model.Genre;
import com.app.repository.GenreRepository;
import com.app.repository.impl.GenreRepositoryImpl;
import com.app.service.GenreService;
import com.app.util.Assert;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    public GenreServiceImpl() {
        genreRepository = new GenreRepositoryImpl();
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public Genre create(Genre genre) {
        Assert.notNull(genre, "genre must not be null.");
        return genreRepository.create(genre);
    }

    @Override
    public void remove(Genre genre) {
        Assert.notNull(genre, "genre must not be null.");
        genreRepository.remove(genre);
    }
}
