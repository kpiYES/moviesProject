package com.app.repository.impl;


import com.app.model.Director;
import com.app.repository.DirectorRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepositoryImpl implements DirectorRepository {

    private static final String Query = "SELECT DISTINCT director  FROM moviesproject.movies ORDER BY director";

    @Override
    public List<Director> getDirectorList() {

        List<Director> directors = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String directorName = resultSet.getString("director");
                directors.add(new Director(directorName));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
        return directors;
    }
}

