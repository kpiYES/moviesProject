package com.app.controller.admin;

import com.app.controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToDataChangeCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("jsp", "dataChange.jsp");
    }
}
