package com.app.repository.impl;


import com.app.model.Genre;
import com.app.repository.GenreRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {

    private static final String PUT_GENER = "INSERT INTO moviesproject.genre VALUES (NULL,?)";
    private static final String GET_ALL_GENERS = "SELECT * FROM moviesproject.genre ORDER BY type_of_genre";
    private static final String DELETE_GENER = "DELETE FROM moviesproject.genre WHERE type_of_genre = ?";

    @Override
    public List<Genre> getAll() {

        List<Genre> genres = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_GENERS)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String typeOfGenre = resultSet.getString("type_of_genre");
                genres.add(new Genre(id, typeOfGenre));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
        return genres;
    }

    public int putGenre(Genre genre) {
        int i;

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(PUT_GENER)) {

            preparedStatement.setString(1, genre.getTypeOfGenre());

            i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put genre to 'genre' table", e);
        }
        return i;
    }

    public int removeGenre(Genre genre) {
        int i;

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GENER)) {

            preparedStatement.setString(1, genre.getTypeOfGenre());

            i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete genre from 'genre' table", e);
        }
        return i;
    }

}

