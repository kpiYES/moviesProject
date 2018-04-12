package com.app.controller.user;

import com.app.controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToMainPageCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("jsp", "mainPage.jsp");
    }
}
