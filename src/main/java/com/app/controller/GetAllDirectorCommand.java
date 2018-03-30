package com.app.controller;

import com.app.model.Director;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllDirectorCommand implements Command {

    private DirectorService directorService;

    GetAllDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        List<Director> getAllDirector = directorService.getAll();
        request.setAttribute("get_all_director", getAllDirector);
    }
}

