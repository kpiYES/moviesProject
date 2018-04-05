package com.app.controller;

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
import com.app.util.StringToSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

public class UpdateMovieCommand implements Command {

    final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Misha\\IdeaProjects\\uploadLocation\\Movies\\Images\\";
    final private String PATH_TO_STORE_OF_DESCRIPTIONS = "C:\\Users\\Misha\\IdeaProjects\\uploadLocation\\Movies\\Descriptions\\";
    private MovieService movieService;

    UpdateMovieCommand() {
        movieService = new MovieServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Set<String> setOfTypesOfGenre = StringToSet.splitStringOfGenresToSet(request.getParameter("genres"));
        GenreService genreService = new GenreServiceImpl();
        Set<Genre> genreSet = new HashSet<>();

        for (String type : setOfTypesOfGenre) {
            if (genreService.checkOnExist(type)) {
                genreSet.add(genreService.getByType(type));
//               если не существует - сообщить, что не существует
//               если существует - продолжить
            }
        }

        Director director;
        DirectorService directorService = new DirectorServiceImpl();
        if (directorService.checkOnExist(request.getParameter("name_of_director"))) {
            director = directorService.getByName(request.getParameter("name_of_director"));
            System.out.println( director.getId());
            System.out.println(director.getName());
            ServerRepository serverRepository = new ServerRepository();
            String image = serverRepository.uploadToServer(request, PATH_TO_STORE_OF_IMAGES, request.getParameter("title"), "image");
            String description = serverRepository.uploadToServer(request, PATH_TO_STORE_OF_DESCRIPTIONS, request.getParameter("title"), "description");

            Movie movieForRemoving = movieService.getByTitle(request.getParameter("title"));
            System.out.println(movieForRemoving.getId());
            System.out.println(movieForRemoving.getDirector_id());
            System.out.println(movieForRemoving.getTitle());
            System.out.println(movieForRemoving.getRuntime());
            System.out.println(movieForRemoving.getDescription());
            System.out.println(movieForRemoving.getImage());

            Movie movie = new Movie();
            movie.setId(movieForRemoving.getId());
            movie.setDirector_id(director.getId());
            movie.setTitle(request.getParameter("title"));
            movie.setRuntime(Integer.parseInt(request.getParameter("runtime")));
            movie.setDescription(description);
            movie.setImage(image);
            movie.setGenres(genreSet);
            Movie updatedMovie = movieService.update(movie);
            System.out.println(updatedMovie.getId());

            serverRepository.removeFile(movieForRemoving.getImage());

            MovieGenreRelationService movieGenreRelationService = new MovieGenreRelationServiceImpl();
            for(Genre genre: genreSet) {
                movieGenreRelationService.update(movie,genre);
            }

            request.setAttribute("created_movie", updatedMovie);
            request.setAttribute("result", "New movie has successfully added!");
            request.setAttribute("jsp", "movieChange.jsp");
        }
    }
}
