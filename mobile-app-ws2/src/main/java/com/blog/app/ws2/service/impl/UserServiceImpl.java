package com.blog.app.ws2.service.impl;

import com.blog.app.ws2.io.entity.UserEntity;
import com.blog.app.ws2.io.repository.UserRepository;
import com.blog.app.ws2.service.UserService;
import com.blog.app.ws2.shared.Utils;
import com.blog.app.ws2.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;
    @Override
    public UserDto createUser(UserDto userDto) {

       /* if(userRepository.findByEmail(userDto.getEmail()) != null)
            throw new RuntimeException("User Already Exist !!! ");*/
        UserEntity userEntity = new UserEntity();
        userDto.setEncryptedPassword("test");
        String publicUserId = utils.generateUserId(30);
        userDto.setUserId(publicUserId);
        BeanUtils.copyProperties(userDto,userEntity);
        UserEntity savedEntity = userRepository.save(userEntity);

        UserDto returnUser = new UserDto();
        BeanUtils.copyProperties(savedEntity,returnUser);
        return returnUser;
    }
}
