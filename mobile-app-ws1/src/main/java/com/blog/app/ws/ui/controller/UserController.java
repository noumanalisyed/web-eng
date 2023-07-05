package com.blog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "get user Was called";
    }

    @PostMapping
    public String createUser(){
        return "create user was called ";
    }

    @PutMapping
    public String updateUser(){
        return "update user Was called";
    }

    @DeleteMapping
    public String deletUser(){
        return "delete user was called ";
    }

}
