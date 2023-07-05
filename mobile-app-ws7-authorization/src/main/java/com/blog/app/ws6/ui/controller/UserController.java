package com.blog.app.ws6.ui.controller;

import com.blog.app.ws6.io.entity.UserEntity;
import com.blog.app.ws6.service.UserService;
import com.blog.app.ws6.shared.dto.UserDto;
import com.blog.app.ws6.ui.controller.model.request.UserDetailsRequestModel;
import com.blog.app.ws6.ui.controller.model.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public UserResponse getUser(@PathVariable String id){
        logger.info("get User Method Called");
        UserResponse returnValue = new UserResponse();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);
        System.out.println(returnValue.getFirstName()+returnValue.getLastName()+returnValue.getEmail());
        return returnValue;
    }

    @PostMapping
    @ResponseBody
    public UserResponse createUser(@RequestBody UserDetailsRequestModel userModel){

        UserResponse returnValue = new UserResponse();
        logger.info("get User Method Called");
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
    public String deleteUser(){
        return "delete user was called ";
    }

}
