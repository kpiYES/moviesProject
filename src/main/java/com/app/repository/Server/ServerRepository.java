package com.app.repository.Server;

import com.app.util.FileName;

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


    public String uploadFile(HttpServletRequest req, String pathToStore, String partOfFileName, String type) {
        try {
            Part filePart = req.getPart(type);
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String mime = FileName.getMime(fileName);
            File file = File.createTempFile(partOfFileName, "." + mime, new File(pathToStore));

           try( InputStream inputStream = filePart.getInputStream()) {
               Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);


               return file.toString().replaceAll("\\\\","/");
           }
        } catch (IOException | ServletException e) {
            throw new RuntimeException("Couldn't save file", e);
        }
    }

    public void removeFile( String pathToFile){
            File file = new File(pathToFile);
            file.delete();
        }
    }










