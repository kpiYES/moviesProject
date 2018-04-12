package com.app.service.impl;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.DataBase.MovieRepository;
import com.app.repository.DataBase.impl.MovieRepositoryImpl;
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
    public Movie create(Movie movie) {
        Assert.notNull(movie, "movie must not be null.");
        return movieRepository.create(movie);
    }

    @Override
    public void remove(Movie movie) {
        Assert.notNull(movie, "movie must not be null.");
        movieRepository.remove(movie);
    }

    @Override
    public Movie update(Movie movie) {
        Assert.notNull(movie, "movie must not be null.");
       return movieRepository.update((movie));
    }

    @Override
    public Movie getByTitle(String title) {
        Assert.notNull(title, "title must not be null");
        return movieRepository.getByTitle(title);
    }

    @Override
    public List<Movie> getByDirector(Director director) {
        Assert.notNull(director,"director must not be null");
        return movieRepository.getByDirector(director);
    }


}
