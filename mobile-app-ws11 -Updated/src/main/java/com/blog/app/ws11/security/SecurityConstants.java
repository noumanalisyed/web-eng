package com.blog.app.ws11.security;

import com.blog.app.ws11.SpringApplicationContext;

public class SecurityConstants {
    public static final long TOKEN_EXPIRATION_TIME = 8640000000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
   // public static final String TOKEN_SECRET = "jf9i4jgu83nfl0";

    public static String getTokenSecret(){
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperties.getTokenSecret();
    }
}
