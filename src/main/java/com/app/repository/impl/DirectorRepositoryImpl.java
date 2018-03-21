package com.app.repository.impl;


import com.app.model.Director;
import com.app.repository.DirectorRepository;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepositoryImpl implements DirectorRepository {

    private static final String Query = "SELECT *  FROM moviesproject.director ORDER BY name";

    @Override
    public List<Director> getDirectorList() {

        List<Director> directors = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String directorName = resultSet.getString("name");
                LocalDate dayOfBirth = resultSet.getObject("day_of_birth",LocalDate.class);
                String image = resultSet.getString("image");
                directors.add(new Director(directorName,dayOfBirth,image));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
        return directors;
    }
}

