package com.app.controller;

import com.app.model.Genre;
import com.app.service.GenreService;
import com.app.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateGenreCommand implements Command {
    private GenreService genreService;


    CreateGenreCommand() {
        genreService = new GenreServiceImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Genre genre = new Genre();
        genre.setTypeOfGenre(request.getParameter("type"));

        Genre createdGenre = genreService.create(genre);
        request.setAttribute("result", "New genre has successfully added!");
        request.setAttribute("jsp", "views/genreChange.jsp");
    }
}
