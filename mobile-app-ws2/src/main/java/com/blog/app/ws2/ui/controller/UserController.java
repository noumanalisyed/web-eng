package com.blog.app.ws2.ui.controller;

import com.blog.app.ws2.service.UserService;
import com.blog.app.ws2.shared.dto.UserDto;
import com.blog.app.ws2.ui.controller.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blog.app.ws2.ui.controller.model.request.UserDetailsRequestModel;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user Was called";
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserDetailsRequestModel userModel){

        UserResponse returnValue = new UserResponse();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userModel,userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
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
