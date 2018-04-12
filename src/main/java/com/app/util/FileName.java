package com.app.util;

public class FileName {

    public static String getExstention(String fileName){

    String[] partsOfName = fileName.split("\\.");
    return partsOfName[partsOfName.length - 1];
    }

//    public static String getReplaceSlash(String string){
//
//
//    }
}
