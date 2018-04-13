package com.app.repository.DataBase.impl;


import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.DataBase.GenreRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenreRepositoryImpl implements GenreRepository {

    private static final String CREATE_QUERY = "INSERT INTO moviesproject.genre VALUES (NULL,?)";
    private static final String GET_ALL_QUERY = "SELECT id, type_of_genre FROM moviesproject.genre ORDER BY type_of_genre";
    private static final String REMOVE_QUERY = "DELETE FROM moviesproject.genre WHERE type_of_genre = ?";
    private static final String CHECK_ON_EXIST_QUERY = "SELECT id FROM moviesproject.genre WHERE type_of_genre=?";
    private static final String GET_BY_TYPE_QUERY = "SELECT id, type_of_genre FROM moviesproject.genre WHERE type_of_genre=?";
    private static final String GET_BY_MOVIE_QUERY = "SELECT g.id, g.type_of_genre FROM moviesproject.genre g INNER JOIN moviesproject.movie_genre mg ON g.id = mg.genre_id WHERE mg.movie_id = ?";

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
            throw new RuntimeException("Couldn't get list with values from 'genre' table", e);
        }
    }

    @Override
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

    @Override
    public void remove(Genre genre) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY)) {

            preparedStatement.setString(1, genre.getTypeOfGenre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove genre from 'genre' table", e);
        }
    }

    @Override
    public Genre getByType(String type) {

        Genre genre = new Genre();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getByTypeStatement(connection, type);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                genre.setId(resultSet.getLong("id"));
                genre.setTypeOfGenre(resultSet.getString("type_of_genre"));
            }
            return genre;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get set with genres from 'genre' table", e);
        }
    }

    @Override
    public Set<Genre> getSetByMovie(Movie movie) {

        Set<Genre> genreSet = new HashSet<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getByMovieStatement(connection, movie);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String typeOfGenre = resultSet.getString("type_of_genre");
                genreSet.add(new Genre(id, typeOfGenre));
            }
            return genreSet;

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get set with genres from 'genre' table", e);
        }
    }

    @Override
    public boolean checkOnExist(String typeOfGenre) {
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getCheckOnExistQueryStatement(connection, typeOfGenre);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't check genre on exist from table 'genres'", e);
        }
    }

    private PreparedStatement getCreateStatement(Connection connection, Genre genre) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, genre.getTypeOfGenre());
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    private PreparedStatement getCheckOnExistQueryStatement(Connection connection, String type_of_genre) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ON_EXIST_QUERY);
        preparedStatement.setString(1, type_of_genre);
        return preparedStatement;
    }

    private PreparedStatement getByTypeStatement(Connection connection, String type) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_TYPE_QUERY);
        preparedStatement.setString(1, type);
        return preparedStatement;
    }

    private PreparedStatement getByMovieStatement(Connection connection, Movie movie) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_MOVIE_QUERY);
        preparedStatement.setLong(1, movie.getId());
        return preparedStatement;
    }

}

