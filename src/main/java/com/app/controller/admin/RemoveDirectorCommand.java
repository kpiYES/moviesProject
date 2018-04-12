package com.app.controller.admin;

import com.app.controller.Command;
import com.app.model.Director;
import com.app.repository.Server.ServerRepository;
import com.app.service.DirectorService;
import com.app.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveDirectorCommand implements Command {

    private DirectorService directorService;

    public RemoveDirectorCommand() {
        directorService = new DirectorServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Director directorForRemoving = directorService.getByName(request.getParameter("name"));
        directorService.remove(directorForRemoving);
        ServerRepository serverRepository = new ServerRepository();
        serverRepository.removeFile(directorForRemoving.getImage());
        request.setAttribute("result", "Genre has successfully removed!");
        request.setAttribute("jsp", "directorChange.jsp");
    }
}
