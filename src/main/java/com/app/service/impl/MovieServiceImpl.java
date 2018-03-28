package com.app.service.impl;

import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.MovieRepository;
import com.app.repository.impl.MovieRepositoryImpl;
import com.app.service.MovieService;
import com.app.util.Assert;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl() {
        movieRepository = new MovieRepositoryImpl();
    }


    @Override
    public List<Movie> getAll() {

        return movieRepository.getAll();
    }

    @Override
    public List<Movie> getByGenre(Genre genre) {
        Assert.notNull(genre, "movie must not be null.");
        return movieRepository.getByGenre(genre);
    }

    @Override
    public Movie create(Movie movie, String directorsName) {
        Assert.notNull(movie, "movie must not be null.");
        return movieRepository.create(movie, directorsName);
    }

    @Override
    public void remove(Movie movie) {
        Assert.notNull(movie, "movie must not be null.");
        movieRepository.remove(movie);
    }


}
