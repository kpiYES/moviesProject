package com.app.controller;

import com.app.model.Genre;
import com.app.service.GenreService;
import com.app.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllGenreCommand implements Command {

    private GenreService genreService;

    GetAllGenreCommand() {
        genreService = new GenreServiceImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        List<Genre> getAllGenre = genreService.getAll();
        request.setAttribute("get_all_genre", getAllGenre);
    }
}
