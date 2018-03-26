package com.app.controller;

import com.app.model.Genre;
import com.app.service.GenreService;
import com.app.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddGenreCommand implements Command {
    private GenreService genreService;


    AddGenreCommand() {
        genreService = new GenreServiceImpl();
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Genre genre = new Genre();
        genre.setTypeOfGenre(request.getParameter("genre_add"));
        if (genreService.addGenre(genre) == 1) {
            return "Operation has been successfully completed";
        }
        return "Operation hasn't successfully completed ";
    }
}
