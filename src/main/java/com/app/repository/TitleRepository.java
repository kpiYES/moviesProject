package com.app.repository;

import com.app.model.Movie;

import java.util.List;

public interface TitleRepository {
    List<Movie> getTitleList();
}
