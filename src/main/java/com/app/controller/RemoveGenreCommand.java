package com.app.controller;

import com.app.model.Genre;
import com.app.service.GenreService;
import com.app.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveGenreCommand implements Command {

    private GenreService genreService;

    RemoveGenreCommand() {
        genreService = new GenreServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Genre genre = new Genre();
        genre.setTypeOfGenre(request.getParameter("genre_delete"));
        genreService.remove(genre);
    }
}

