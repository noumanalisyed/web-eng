package com.web.project.web_proj_first;

import java.util.Date;

public class UtilityClass {
    public static String makeItUpper(String data){
        return data.toUpperCase();
    }
    public static String makeItLower(String data){
        return data.toLowerCase();
    }
    public static String getCurrentDateAndTime(){
        return new Date().toString();
    }
}
