package com.blog.app.ws10.service;

import com.blog.app.ws10.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);

    UserDto getUserByUserId(String id);
}
