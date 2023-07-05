package com.blog.app.ws11.service;

import com.blog.app.ws11.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);

    UserDto getUserByUserId(String id);

    UserDto updateUser(String id, UserDto userDto);
}
