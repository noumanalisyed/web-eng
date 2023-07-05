package com.blog.app.ws6.service;

import com.blog.app.ws6.io.entity.UserEntity;
import com.blog.app.ws6.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);

    UserDto getUserByUserId(String id);
}
