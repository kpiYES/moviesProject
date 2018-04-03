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
    private static final String UPDATE_QUERY = "UPDATE moviesproject.movie_genre SET genre_id = ? WHERE movie_id = ?";

    @Override
    public void create(Movie movie, Genre genre) {

        System.out.println(movie.getId());
        System.out.println(genre.getId());
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY)) {
            preparedStatement.setLong(1, genre.getId());
            preparedStatement.setLong(2, movie.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put genre to 'genre' table", e);
        }
    }

    @Override
    public void remove(Movie movie) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY)) {

            preparedStatement.setLong(1, movie.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove genre from 'genre' table", e);
        }
    }

    @Override
    public void update(Movie movie, Genre genre) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {

            preparedStatement.setLong(1, genre.getId());
            preparedStatement.setLong(2, movie.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove genre from 'genre' table", e);
        }
    }


//    private PreparedStatement getCreateStatement(Connection connection,Movie movie, Genre genre) throws SQLException {
//
//        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
//        preparedStatement.setLong(1, genre.getId());
//        preparedStatement.setLong(2, movie.getId());
//        return preparedStatement;
//    }
//
//    private PreparedStatement getUpdateStatement(Connection connection, Movie movie, Genre genre) throws SQLException {
//
//        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
//        preparedStatement.setLong(1, genre.getId());
//        preparedStatement.setLong(2, movie.getId());
//        return preparedStatement;
//    }


//    private PreparedStatement getRemoveStatement(Connection connection, Movie movie) throws SQLException{
//        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY);
//        preparedStatement.setLong(1,movie.getId());
//        return preparedStatement;
//
//
//    }


}
