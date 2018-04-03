package com.app.util;

import javax.servlet.http.HttpServletRequest;

public class BackPath {
    public static String findLastJSP(HttpServletRequest request){

        String backPath = request.getHeader("referer");
        return  "views"+backPath.substring(backPath.lastIndexOf("/"),backPath.length());
    }
}
