package com.app.service.impl;

import com.app.model.Genre;
import com.app.repository.GenreRepository;
import com.app.repository.impl.GenreRepositoryImpl;
import com.app.service.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    public GenreServiceImpl() {
        genreRepository = new GenreRepositoryImpl();
    }

    @Override
    public List<Genre> getListOfGenre() {
        return genreRepository.getAll();
    }

    @Override
    public int addGenre(Genre genre) {
        return genreRepository.putGenre(genre);

    }

    @Override
    public int deleteGenre(Genre genre) {
        return genreRepository.removeGenre(genre);
    }
}
