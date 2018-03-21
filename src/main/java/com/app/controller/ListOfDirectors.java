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

@WebServlet(name = "Dispatcher", urlPatterns = {"/main", "/movie"})
public class ListOfDirectors extends HttpServlet {

    private GenreService genreService;

    public ListOfDirectors() {

        genreService = new GenreServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if ("/main".equals(req.getServletPath())) {
            System.out.println("qqqqqq");
        }
            if ("/movie".equals(req.getServletPath())) {
                System.out.println("aaaaa");
            }

            List<Genre> genreList = genreService.getListOfGenre();
            req.setAttribute("genreList", genreList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/mainPage.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
