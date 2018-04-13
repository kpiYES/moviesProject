package com.app.repository.DataBase.impl;


import com.app.model.Director;
import com.app.model.Movie;
import com.app.repository.DataBase.DirectorRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepositoryImpl implements DirectorRepository {

    private static final String GET_ALL_QUERY = "SELECT id, name, day_of_birth, image  FROM moviesproject.director ORDER BY name";
    private static final String CREATE_QUERY = "INSERT INTO moviesproject.director (id, name,day_of_birth,image) VALUES (NULL ,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE moviesproject.director SET day_of_birth = ?, image = ? WHERE name = ?";
    private static final String REMOVE_QUERY = "DELETE FROM moviesproject.director WHERE name = ?";
    private static final String GET_BY_NAME_QUERY = "SELECT id, name, day_of_birth, image FROM moviesproject.director WHERE name = ?";
    private static final String GET_BY_MOVIE_QUERY = "SELECT d.id, d.name, d.day_of_birth, d.image FROM moviesproject.director d INNER JOIN moviesproject.movie m ON d.id = m.director_id WHERE m.title = ?";
    private static final String CHECK_ON_EXIST_QUERY = "SELECT id FROM moviesproject.director WHERE name=?";

    @Override
    public List<Director> getAll() {

        List<Director> directors = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                LocalDate dayOfBirth = resultSet.getObject("day_of_birth", LocalDate.class);
                System.out.println(dayOfBirth);
                String image = resultSet.getString("image");
                directors.add(new Director(id, name, dayOfBirth, image));
            }
            return directors;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with directors from table 'director'", e);
        }
    }

    @Override
    public Director create(Director director) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getCreateStatement(connection, director);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                long generatedId = resultSet.getLong(1);
                director.setId(generatedId);
            }
            return director;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put director to 'director' table", e);
        }
    }

    @Override
    public void remove(Director director) {
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY)) {

            preparedStatement.setString(1, director.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove director from table 'directors'", e);
        }
    }

    @Override
    public Director update(Director director) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setObject(1, director.getDayOfBirth());
            preparedStatement.setString(2, director.getImage());
            preparedStatement.setString(3, director.getName());
            preparedStatement.executeUpdate();

            return director;

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update director from table 'director'", e);
        }
    }

    public Director getByName(String name) {
        Director director = new Director();
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getByNameStatement(connection, name);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                director.setId(resultSet.getLong("id"));
                director.setName(resultSet.getString("name"));
                director.setDayOfBirth(resultSet.getObject("day_of_birth", LocalDate.class));
                director.setImage(resultSet.getString("image"));
            }
            return director;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get director by name from table 'director'", e);
        }
    }

    @Override
    public Director getByMovie(Movie movie) {
        Director director = new Director();
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getByMovieStatement(connection, movie);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                director.setId(resultSet.getLong("id"));
                director.setName(resultSet.getString("name"));
                director.setDayOfBirth(resultSet.getObject("day_of_birth", LocalDate.class));
                director.setImage(resultSet.getString("image"));
            }
            return director;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get director by movie from table 'director'", e);
        }
    }

    @Override
    public boolean checkOnExist(String name) {
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getCheckOnExistQueryStatement(connection, name);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't check director on exist from table 'director'", e);
        }
    }


    private PreparedStatement getCreateStatement(Connection connection, Director director) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, director.getName());
        preparedStatement.setObject(2, director.getDayOfBirth());
        preparedStatement.setString(3, director.getImage());
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    private PreparedStatement getByNameStatement(Connection connection, String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME_QUERY);
        preparedStatement.setString(1, name);
        return preparedStatement;
    }

    private PreparedStatement getByMovieStatement(Connection connection, Movie movie) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_MOVIE_QUERY);
        preparedStatement.setString(1, movie.getTitle());
        return preparedStatement;
    }

    private PreparedStatement getCheckOnExistQueryStatement(Connection connection, String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ON_EXIST_QUERY);
        preparedStatement.setString(1, name);
        return preparedStatement;
    }
}

