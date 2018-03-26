package com.app.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/dispatcher"})
public class ServletDispatcher extends HttpServlet {

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

        CommandHelper commandHelper = new CommandHelper();
        Command command = commandHelper.chooseCommand(req);
        String result = command.execute(req, resp);

//        System.out.println(req.getParameter("genre_add"));
//        System.out.println(req.getParameter("genre_delete"));
//        System.out.println(req.getServletPath());
//        if ("/dispatcher".equals(req.getServletPath()) && req.getParameter("genre_add") != null) {
//            System.out.println("a");
//            GenreService genreService = new GenreServiceImpl();
//            String name = req.getParameter("genre_add");
//            Genre genre = new Genre();
//            genre.setTypeOfGenre(name);
//            System.out.println(genre.getTypeOfGenre());
//            int result = genreService.addGenre(genre);
//            System.out.println(result);
//            req.setAttribute("resultAdd", result);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/genreChange.jsp");
//            requestDispatcher.forward(req,resp);
//        }
//
//        if ("/dispatcher".equals(req.getServletPath()) && req.getParameter("genre_delete") != null) {
//            System.out.println("b");
//            GenreService genreService = new GenreServiceImpl();
//            String name = req.getParameter("genre_delete");
//            Genre genre = new Genre();
//            genre.setTypeOfGenre(name);
//            int result = genreService.deleteGenre(genre);
//            System.out.println(result);
//            req.setAttribute("resultDelete", result);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/genreChange.jsp");
//            requestDispatcher.forward(req,resp);
//        }
    }
}




