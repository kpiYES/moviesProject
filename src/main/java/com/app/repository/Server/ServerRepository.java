package com.app.repository.Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ServerRepository {


    public String saveToServer(HttpServletRequest req, String pathToStore, String partOfFileName, String type) {

        try {
            Part filePart = req.getPart(type);
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String[] partsOfName = fileName.split("\\.");
            String extension = partsOfName[partsOfName.length - 1];
            File file = File.createTempFile(partOfFileName, "." + extension, new File(pathToStore));

           try( InputStream inputStream = filePart.getInputStream()) {
               Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
               System.out.println(file.toPath());

               return file.toString();
           }
        } catch (IOException | ServletException e) {
            throw new RuntimeException("Couldn't save file", e);
        }
    }
}
