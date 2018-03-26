package com.app.controller;

import com.app.model.Genre;
import com.app.service.GenreService;
import com.app.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteGenreCommand implements Command {

    private GenreService genreService;

    DeleteGenreCommand() {
        genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Genre genre = new Genre();
        genre.setTypeOfGenre(request.getParameter("genre_delete"));
        if (genreService.deleteGenre(new Genre()) == 1) {
            return "Operation has been successfully completed";
        }
        return "Operation hasn't successfully completed ";
    }
}

