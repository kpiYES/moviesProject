package com.app.controller;

import com.app.model.Director;
import com.app.model.Movie;
import com.app.repository.Server.ServerRepository;
import com.app.service.DirectorService;
import com.app.service.MovieService;
import com.app.service.impl.DirectorServiceImpl;
import com.app.service.impl.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMovieCommand implements Command {

    final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Misha\\IdeaProjects\\Store\\Movies\\Images\\";
    final private String PATH_TO_STORE_OF_DESCRIPTIONS = "C:\\Users\\Misha\\IdeaProjects\\Store\\Directors\\Descriptions\\";
    private MovieService movieService;

    UpdateMovieCommand() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        ServerRepository serverRepository = new ServerRepository();
        String image = serverRepository.uploadToServer(request, PATH_TO_STORE_OF_IMAGES, request.getParameter("title"), request.getParameter("image"));
        String description = serverRepository.uploadToServer(request, PATH_TO_STORE_OF_DESCRIPTIONS, request.getParameter("title"), request.getParameter("description"));



        Director director;
        Director directorRequest = new Director();
        directorRequest.setName(request.getParameter("name_of_director"));
        DirectorService directorService = new DirectorServiceImpl();
        if( directorService.checkOnExist(request.getParameter("name_of_director"))) {
            director = directorService.getByName(request.getParameter("name_of_director"));
        }else
            director = directorService.create(directorRequest);



        Movie movie = new Movie();
        movie.setDirector_id(director.getId());
        movie.setTitle(request.getParameter("movie_title"));
        movie.setRuntime(Integer.parseInt(request.getParameter("movie_runtime")));
        movie.setDescription(description);
        movie.setImage(image);

        Movie updatedMovie = movieService.update(movie);
        request.setAttribute("updated_movie", updatedMovie);
    }
}
