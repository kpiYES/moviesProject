package com.app.util;



public class FileName {

    public static String getMime(String fileName){

    String[] partsOfName = fileName.split("\\.");
    return partsOfName[partsOfName.length - 1];
    }

}
