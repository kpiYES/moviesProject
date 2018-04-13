package com.app.repository.DataBase.impl;


import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.DataBase.MovieGenreRelationRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieGenreRelationRepositoryImpl implements MovieGenreRelationRepository {

    private static final String CREATE_QUERY = "INSERT INTO moviesproject.movie_genre VALUES (?,?)";
    private static final String REMOVE_QUERY = "DELETE FROM moviesproject.movie_genre WHERE movie_id = ?";

    @Override
    public void create(Movie movie, Genre genre) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY)) {
            preparedStatement.setLong(1, genre.getId());
            preparedStatement.setLong(2, movie.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put columns to 'movie_genre' table", e);
        }
    }

    @Override
    public void remove(Movie movie) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY)) {

            preparedStatement.setLong(1, movie.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove columns from 'movie_genre' table", e);
        }
    }


}
