package com.app.controller;

import com.app.service.DirectorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ListOfDirectors extends HttpServlet {

    private DirectorServiceImpl directorService;

    ListOfDirectors() {
        directorService = new DirectorServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }
}
