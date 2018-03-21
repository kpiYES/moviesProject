package com.app.service.impl;

import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.MovieRepository;
import com.app.repository.impl.MovieRepositoryImpl;
import com.app.service.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl() {
        movieRepository = new MovieRepositoryImpl();
    }


    @Override
    public List<Movie> getAllMovies() {

        return movieRepository.getMovieList();
    }

    @Override
    public List<Movie> getMoviesByGenre(Genre genre) {
        return movieRepository.getMovieListByGenre(genre);
    }


}
