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

    private static final String CREATE_QUERY = "INSERT INTO moviesproject.genre VALUES (NULL,?)";
    private static final String GET_ALL_QUERY = "SELECT id, type_of_genre FROM moviesproject.genre ORDER BY type_of_genre";
    private static final String REMOVE_QUERY = "DELETE FROM moviesproject.genre WHERE type_of_genre = ?";

    @Override
    public List<Genre> getAll() {

        List<Genre> genres = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String typeOfGenre = resultSet.getString("type_of_genre");
                genres.add(new Genre(id, typeOfGenre));
            }
            return genres;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
    }

    public Genre create(Genre genre) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getCreateStatement(connection, genre);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                long generatedId = resultSet.getLong(1);
                genre.setId(generatedId);
            }
            return genre;

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put genre to 'genre' table", e);
        }
    }

    public void remove(Genre genre) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY)) {

            preparedStatement.setString(1, genre.getTypeOfGenre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove genre from 'genre' table", e);
        }
    }

    private PreparedStatement getCreateStatement(Connection connection, Genre genre) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
        preparedStatement.setString(1, genre.getTypeOfGenre());
        return preparedStatement;
    }

}

