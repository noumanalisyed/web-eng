package com.blog.app.ws4.security;

import com.blog.app.ws4.ui.controller.model.request.UserLoginRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserLoginRequestModel userLoginRequestModel = new ObjectMapper()
                    .readValue(request.getInputStream(), UserLoginRequestModel.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginRequestModel.getEmail(),
                            userLoginRequestModel.getPassword(), new ArrayList<>()));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
    protected void sucessfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication auth)throws IOException, ServletException {
        String userName = ((User) auth.getPrincipal()).getUsername();
        String tokens = Jwts.builder().setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis()+ SecurityConstants.TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET).compact();
         response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+tokens);
    }
}
