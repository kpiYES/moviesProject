package com.app.util;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.model.Movie;

public class Assert {
    public static void notNull(Object object, String message) {

        if (object == null) {
            throw new IllegalArgumentException(message);
        }

//        if (object instanceof Genre){
//
//            Genre genre = (Genre)object;
//            if(genre.getTypeOfGenre()==null){
//                throw new IllegalArgumentException(message);
//            }
//        }
//
//        if (object instanceof Director){
//
//            Director director = (Director) object;
//            if(director.getName()==null){
//                throw new IllegalArgumentException(message);
//            }
//        }
//
//        if (object instanceof Movie){
//
//            Movie movie = (Movie) object;
//            if(movie.getTitle()==null || movie.getDirector_id()==0){
//                throw new IllegalArgumentException(message);
//            }
//        }
//

//                               OR

//        if (object.getClass()==Genre.class){
//            Genre genre = (Genre)object;
//            if(genre.getTypeOfGenre()==null){
//                throw new IllegalArgumentException(message);
//            }
//        }
//
//        if (object.getClass()==Director.class){
//
//            Director director = (Director) object;
//            if(director.getName()==null){
//                throw new IllegalArgumentException(message);
//            }
//        }
//
//        if (object.getClass()==Movie.class){
//
//            Movie movie = (Movie) object;
//            if(movie.getTitle()==null || movie.getDirector_id()==0){
//                throw new IllegalArgumentException(message);
//            }
//        }

// but in this case i have to change "public Movie create(Movie movie, String directorsName)"
//        to "public Movie create(Movie movie)" and check "director_id" before sending data from form.
// actually, it will be even easy with filled field "director_id", but not so convenient for user.


    }
}
