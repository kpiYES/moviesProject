package com.app.controller;


import com.app.util.BackPath;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


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

        RequestDispatcher requestDispatcher = req.getRequestDispatcher((String)req.getAttribute("jsp"));
        requestDispatcher.forward(req,resp);

    }
}




