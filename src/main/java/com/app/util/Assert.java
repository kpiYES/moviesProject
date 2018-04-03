package com.app.util;

import com.app.model.Director;
import com.app.model.Genre;
import com.app.model.Movie;

public class Assert {
    public static void notNull(Object object, String message) {

        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
