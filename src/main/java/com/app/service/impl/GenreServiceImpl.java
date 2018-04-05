package com.app.service.impl;

import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.DataBase.GenreRepository;
import com.app.repository.DataBase.impl.GenreRepositoryImpl;
import com.app.service.GenreService;
import com.app.util.Assert;

import java.util.List;
import java.util.Set;

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
        Assert.notNull(genre.getTypeOfGenre(), "Type of genre must not be null.");
        return genreRepository.create(genre);
    }

    @Override
    public void remove(Genre genre) {
        Assert.notNull(genre.getTypeOfGenre(), "Type of genre must not be null.");
        genreRepository.remove(genre);
    }

    @Override
    public Genre getByType(String type) {
        Assert.notNull(type, "Type must not be null.");
        return genreRepository.getByType(type);
    }

    @Override
    public boolean checkOnExist(String typeOfGenre) {
        Assert.notNull(typeOfGenre, "TypeOfGenre must not be null");
        return genreRepository.checkOnExist(typeOfGenre);
    }

    @Override
    public Set<Genre> getSetByMovie(Movie movie) {
        Assert.notNull(movie, "Movie must not be null");
        return genreRepository.getSetByMovie(movie);
    }
}
