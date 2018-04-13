package com.app.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Genres {

    public static Set<String> splitToSet(String genres) {

        String newString = genres.replaceAll(",\\s", ",").toLowerCase();
        return new HashSet<>(Arrays.asList(newString.split(",")));
    }
}
