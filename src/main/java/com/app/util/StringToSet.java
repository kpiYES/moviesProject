package com.app.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringToSet {

    public static Set<String> splitStringOfGenresToSet(String genres) {
        Set<String> setOfTypesOfGenre;
        String newString = genres.replaceAll(",\\s", ",").toLowerCase();
        return setOfTypesOfGenre = new HashSet<>(Arrays.asList(newString.split(",")));
    }
}
