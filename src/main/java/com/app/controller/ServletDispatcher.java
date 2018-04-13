package com.app.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/dispatcher"})
@MultipartConfig
public class ServletDispatcher extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        CommandHelper commandHelper = new CommandHelper();
        Command command = commandHelper.chooseCommand(req);
        command.execute(req, resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher((String) req.getAttribute("jsp"));
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommandHelper commandHelper = new CommandHelper();
        Command command = commandHelper.chooseCommand(req);
        command.execute(req, resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher((String) req.getAttribute("jsp"));
        requestDispatcher.forward(req, resp);

    }
}




