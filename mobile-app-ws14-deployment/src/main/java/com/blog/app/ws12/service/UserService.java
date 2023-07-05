package com.blog.app.ws12.service;

import com.blog.app.ws12.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);

    UserDto getUserByUserId(String id);

    UserDto updateUser(String id, UserDto userDto);

    UserDto deleteUser(String id);

    List<UserDto> getUsers(int page, int limit);
}
