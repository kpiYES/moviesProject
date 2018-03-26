package com.app.repository.impl;

import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.MovieRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {


    @Override
    public List<Movie> getMovieList() {
        String query = " SELECT * FROM moviesproject.movie ORDER BY movie.title";
        List<Movie> movies = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int director_id = resultSet.getInt("director_id");
                String title = resultSet.getString("title");
                int runtime = resultSet.getInt("runtime");
                String describtion = resultSet.getString("describtion");
                String image = resultSet.getString("image");

                movies.add(new Movie(id, director_id, title, runtime, describtion, image));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list of movies  from table 'movie'", e);
        }

        return movies;
    }

    @Override
    public List<Movie> getMovieListByGenre(Genre genre) {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT m.* " +
                "FROM moviesproject.movie m INNER JOIN moviesproject.movie_genre g " +
                "ON m.id = g.movie_id " +
                "WHERE g.genre_id = ?" +
                " ORDER BY m.title";
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, genre.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int director_id = resultSet.getInt("director_id");
                String title = resultSet.getString("title");
                int runtime = resultSet.getInt("runtime");
                String describtion = resultSet.getString("describtion");
                String image = resultSet.getString("image");

                movies.add(new Movie(id, director_id, title, runtime, describtion, image));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list of movies  from table 'movie'", e);
        }
        return movies;
    }
}
