package com.app.controller.user;

import com.app.controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DisplayFileCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("path"));
        File file = new File(request.getParameter("path"));
        String contentType = request.getSession().getServletContext().getMimeType(file.getName());
        response.reset();
        response.setBufferSize(10240);
        response.setContentType(contentType);
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file), 10240);
             BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream(), 10240)) {
            byte[] buffer = new byte[10240];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read/write file.");
        }
    }
}
