package com.app.repository.DataBase.impl;

import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.DataBase.MovieRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private static final String CREATE_QUERY = "INSERT INTO moviesproject.movie  VALUES (NULL,? ,? ,? ,? ,? )";
    private static final String GET_ALL_QUERY = "SELECT id, director_id, title, runtime, describtion, image FROM moviesproject.movie ORDER BY movie.title";
    private static final String REMOVE_QUERY = "DELETE FROM moviesproject.movie WHERE title = ?";
    private static final String UPDATE_QUERY = "UPDATE moviesproject.movie SET director_id = ?, runtime = ?, describtion = ?, image = ? WHERE title = ?";
    private static final String GET_BY_GENRE_QUERY = "SELECT m.id, m.director_id, m.title, m.runtime, m.describtion, m.image " +
            "FROM moviesproject.movie m INNER JOIN moviesproject.movie_genre g " +
            "ON m.id = g.movie_id " +
            "WHERE g.genre_id = ?" +
            " ORDER BY m.title";
    private static final String GET_BY_AUTOR_QUERY = "";

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                Long director_id = resultSet.getLong("director_id");
                String title = resultSet.getString("title");
                int runtime = resultSet.getInt("runtime");
                String describtion = resultSet.getString("describtion");
                String image = resultSet.getString("image");

                movies.add(new Movie(id, director_id, title, runtime, describtion, image));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list of movies  from table 'movie'", e);
        }
    }

    @Override
    public List<Movie> getByGenre(Genre genre) {

        List<Movie> movies = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getByGenreStatement(connection, genre);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                Long director_id = resultSet.getLong("director_id");
                String title = resultSet.getString("title");
                int runtime = resultSet.getInt("runtime");
                String describtion = resultSet.getString("describtion");
                String image = resultSet.getString("image");

                movies.add(new Movie(id, director_id, title, runtime, describtion, image));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list of movies by genre from table 'movie'", e);
        }
    }

    @Override
    public Movie create(Movie movie) {
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getCreateStatement(connection, movie);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                long generatedId = resultSet.getLong(1);
                movie.setId(generatedId);

            }
            return movie;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put movie to 'movie' table", e);
        }
    }

    public void remove(Movie movie) {
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY)) {

            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't remove movie from table 'movie'", e);
        }
    }

    public Movie update(Movie movie) {

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = getUpdateStatement(connection, movie);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                long generatedId = resultSet.getLong(1);
                movie.setId(generatedId);
            }
            return movie;

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update movie form table 'movie'", e);
        }
    }


    private PreparedStatement getByGenreStatement(Connection connection, Genre genre) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_GENRE_QUERY);
        preparedStatement.setLong(1, genre.getId());
        return preparedStatement;
    }

    private PreparedStatement getCreateStatement(Connection connection, Movie movie) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setLong(1, movie.getDirector_id());
        preparedStatement.setString(2, movie.getTitle());
        preparedStatement.setInt(3, movie.getRuntime());
        preparedStatement.setString(4, movie.getDescription());
        preparedStatement.setString(5, movie.getImage());
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    private PreparedStatement getUpdateStatement(Connection connection, Movie movie) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
        preparedStatement.setLong(1, movie.getDirector_id());
        preparedStatement.setInt(2, movie.getRuntime());
        preparedStatement.setString(3, movie.getDescription());
        preparedStatement.setString(4, movie.getImage());
        preparedStatement.setString(5, movie.getTitle());
        return preparedStatement;
    }


}
