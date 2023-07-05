package com.blog.app.ws12.ui.controller;

import com.blog.app.ws12.service.UserService;
import com.blog.app.ws12.shared.dto.UserDto;
import com.blog.app.ws12.ui.controller.model.request.UserDetailsRequestModel;
import com.blog.app.ws12.ui.controller.model.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public UserResponse getUser(@PathVariable String id){
        logger.info("get User Method Called");
        UserResponse returnValue = new UserResponse();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);
      //  System.out.println(returnValue.getFirstName()+returnValue.getLastName()+returnValue.getEmail());
        return returnValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDetailsRequestModel userModel){

        UserResponse returnValue = new UserResponse();
        logger.info("get User Method Called");
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userModel,userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return ResponseEntity.ok(returnValue);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userModel) {
            UserResponse returnValue = new UserResponse();
            logger.info("get User Method Called");
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userModel, userDto);
            UserDto createdUser = userService.updateUser(id, userDto);
            BeanUtils.copyProperties(createdUser, returnValue);
            return ResponseEntity.ok(returnValue);
        }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getUsers(@RequestParam(value = "page",defaultValue = "0") int page,
                                               @RequestParam(value = "limit",defaultValue = "25") int limit){
        List<UserResponse> userList = new ArrayList<UserResponse>();
        List<UserDto> users  = userService.getUsers(page,limit);

        for ( UserDto userDto : users) {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(userDto,userResponse);
            userList.add(userResponse);
        }
        return userList;
    }
    @DeleteMapping(value = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public  void deleteUser(@PathVariable String id){
        
        UserResponse returnValue = new UserResponse();
        logger.info("delete User Method Called");
        UserDto createdUser = userService.deleteUser(id);
    }

}
