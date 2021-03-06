package com.app.controller.admin;

import com.app.controller.Command;
import com.app.model.Director;
import com.app.model.Genre;
import com.app.model.Movie;
import com.app.repository.Server.ServerRepository;
import com.app.service.DirectorService;
import com.app.service.GenreService;
import com.app.service.MovieGenreRelationService;
import com.app.service.MovieService;
import com.app.service.impl.DirectorServiceImpl;
import com.app.service.impl.GenreServiceImpl;
import com.app.service.impl.MovieGenreRelationServiceImpl;
import com.app.service.impl.MovieServiceImpl;
import com.app.util.Genres;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

public class UpdateMovieCommand implements Command {

    final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Misha\\IdeaProjects\\uploadLocation\\Movies\\Images\\";
    final private String PATH_TO_STORE_OF_DESCRIPTIONS = "C:\\Users\\Misha\\IdeaProjects\\uploadLocation\\Movies\\Descriptions\\";
    private MovieService movieService;

    public UpdateMovieCommand() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Set<String> setOfTypesOfGenre = Genres.splitToSet(request.getParameter("genres"));
        GenreService genreService = new GenreServiceImpl();
        Set<Genre> genreSet = new HashSet<>();

        for (String type : setOfTypesOfGenre) {

            if (genreService.checkOnExist(type)) {
                genreSet.add(genreService.getByType(type));
            }
        }

        Director director;
        DirectorService directorService = new DirectorServiceImpl();
        if (directorService.checkOnExist(request.getParameter("name_of_director"))) {
            director = directorService.getByName(request.getParameter("name_of_director"));

            ServerRepository serverRepository = new ServerRepository();
            String image = serverRepository.uploadFile(request, PATH_TO_STORE_OF_IMAGES, request.getParameter("title"), "image");
            String description = serverRepository.uploadFile(request, PATH_TO_STORE_OF_DESCRIPTIONS, request.getParameter("title"), "description");

            Movie movieForRemoving = movieService.getByTitle(request.getParameter("title"));

            Movie movie = new Movie();
            movie.setId(movieForRemoving.getId());
            movie.setDirector_id(director.getId());
            movie.setTitle(request.getParameter("title"));
            movie.setRuntime(Integer.parseInt(request.getParameter("runtime")));
            movie.setDescription(description);
            movie.setImage(image);
            movie.setGenres(genreSet);
            Movie updatedMovie = movieService.update(movie);

            serverRepository.removeFile(movieForRemoving.getImage());

            MovieGenreRelationService movieGenreRelationService = new MovieGenreRelationServiceImpl();
            movieGenreRelationService.update(movie, genreSet);


            request.setAttribute("created_movie", updatedMovie);
            request.setAttribute("result", "New movie has successfully added!");
            request.setAttribute("jsp", "movieChange.jsp");
        }
    }
}
