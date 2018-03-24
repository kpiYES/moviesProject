package com.app.controller;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.service.DirectorService;
import com.app.service.GenreService;
import com.app.service.impl.DirectorServiceImpl;
import com.app.service.impl.GenreServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Dispatcher", urlPatterns = {"/dispatcher"})
public class ListOfDirectors extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        if ("/".equals(req.getServletPath())) {
//            System.out.println("qqqqqq");


//            List<Genre> genreList = genreService.getListOfGenre();
//            req.setAttribute("genreList", genreList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dataChange.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("genre_add"));
        System.out.println(req.getParameter("genre_delete"));
        System.out.println(req.getServletPath());
        if ("/dispatcher".equals(req.getServletPath()) && req.getParameter("genre_add") != null) {

            GenreService genreService = new GenreServiceImpl();
            String name = req.getParameter("genre_add");
            Genre genre = new Genre();
            genre.setTypeOfGenre(name);
            int result = genreService.addGenre(genre);

            req.setAttribute("resultAdd", result);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dataChange.jsp");

        }

        if ("/dispatcher".equals(req.getServletPath()) && req.getParameter("genre_delete") != null) {
            GenreService genreService = new GenreServiceImpl();
            String name = req.getParameter("genre_delete");
            Genre genre = new Genre();
            genre.setTypeOfGenre(name);
            int result = genreService.deleteGenre(genre);
            System.out.println(result);
            req.setAttribute("resultDelete", result);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dataChange.jsp");


//
//
//
//        }

        }
    }
}




