package com.app.service.impl;

import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.DataBase.MovieGenreRelationRepository;
import com.app.repository.DataBase.impl.MovieGenreRelationRepositoryImpl;
import com.app.service.MovieGenreRelationService;
import com.app.util.Assert;

public class MovieGenreRelationServiceImpl implements MovieGenreRelationService {

    private MovieGenreRelationRepository mgRepository;

    public MovieGenreRelationServiceImpl() {
        mgRepository = new MovieGenreRelationRepositoryImpl();
    }

    @Override
    public void create(Movie movie, Genre genre) {
        Assert.notNull(movie, "movie must not be null.");
        Assert.notNull(genre, "genre must not be null.");
        mgRepository.create(movie, genre);
    }

    @Override
    public void remove(Movie movie) {
        Assert.notNull(movie, "movie must not be null.");
        mgRepository.remove(movie);
    }

    @Override
    public void update(Movie movie, Genre genre) {
        Assert.notNull(movie, "movie must not be null");
        Assert.notNull(genre, "genre must not be null.");
        mgRepository.remove(movie);
        mgRepository.create(movie,genre);
    }
}
