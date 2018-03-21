package com.app.repository.impl;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.repository.GenreRepository;
import com.app.util.DBManager;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {

    private static final String Query = "SELECT * FROM moviesproject.genre ORDER BY type_of_genre";
    @Override
    public List<Genre> getGenreList() {

        List<Genre> genres = new ArrayList<>();

        try (Connection connection = DBManager.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String typeOfGenre = resultSet.getString("type_of_genre");
                genres.add(new Genre(id,typeOfGenre));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get list with values from column 'directors'", e);
        }
        return genres;
    }

}

