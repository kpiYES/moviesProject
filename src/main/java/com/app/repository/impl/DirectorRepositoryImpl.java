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

    private static final String getAllDirectors = "SELECT *  FROM moviesproject.director ORDER BY name";
    private static final String updateRow = "UPDATE moviesproject.director SET day_of_birth = ?, image = ? WHERE name = ?";
    private static final String deleteRow = "DELETE FROM moviesproject.director WHERE name = ?";
    private static final String putRow = "INSERT INTO moviesproject.director VALUES (NULL ,?,?,?)";

    @Override
    public List<Director> getDirectorList() {

        List<Director> directors = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllDirectors)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String directorName = resultSet.getString("name");
                LocalDate dayOfBirth = resultSet.getObject("day_of_birth", LocalDate.class);
                String image = resultSet.getString("image");
                directors.add(new Director(id, directorName, dayOfBirth, image));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
        return directors;
    }

    public int putDirector(Director director) {
//        ***
//        if name != null

//        ***
        int id = 0;
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(putRow)) {

            preparedStatement.setString(1, director.getName());
            preparedStatement.setObject(2, director.getDayOfBirth());
            preparedStatement.setString(3, director.getImage());
            id = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put new row in 'directors'", e);
        }


// to confirm success
        return id;
    }


    public int deleteDirector(Director director) {
        int id;
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteRow)) {

            preparedStatement.setString(1, director.getName());

            id = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete any row in 'directors'", e);
        }

        return id;
    }

    public int updateDirector(Director director) {
//        ***
//        if name != null

//        ***
        int id = 0;
        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateRow)) {


            preparedStatement.setObject(1, director.getDayOfBirth());
            preparedStatement.setString(2, director.getImage());
            preparedStatement.setString(3, director.getName());
            id = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update any row in 'directors'", e);
        }


// to confirm success
        return id;
    }



}

