package com.app.repository;


import com.app.model.Director;
import com.app.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepositoryImpl {

    public List<Director> getDirectorList() {

        List<Director> directors = new ArrayList<>();
        String Query = "SELECT DISTINCT directors  FROM moviesproject.movies ORDER BY directors";


        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
while(resultSet.next()){
    String directorName = resultSet.getString("directors");
    directors.add(new Director(directorName));
}
        }catch (SQLException e){
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
        return directors;
    }
    }

