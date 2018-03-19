package com.app.repository.impl;

import com.app.model.Movie;
import com.app.repository.TitleRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleRepositoryImpl implements TitleRepository {


    private static String Query = "SELECT movietitle FROM moviesproject.movies ORDER BY movietitle";


    @Override
    public List<Movie> getTitleList() {
        List<Movie> movies = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("movietitle");
                movies.add(new Movie(title));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'movietitle'", e);
        }

        return movies;
    }
}
