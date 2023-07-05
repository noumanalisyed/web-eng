package com.blog.app.ws4.service.impl;

import com.blog.app.ws4.io.entity.UserEntity;
import com.blog.app.ws4.io.repository.UserRepository;
import com.blog.app.ws4.service.UserService;
import com.blog.app.ws4.shared.Utils;
import com.blog.app.ws4.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;
    @Override
    public UserDto createUser(UserDto userDto) {

        if(userRepository.findByEmail(userDto.getEmail()) != null)
            throw new RuntimeException("User Already Exist !!! ");
        UserEntity userEntity = new UserEntity();
        userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        String publicUserId = utils.generateUserId(30);
        userDto.setUserId(publicUserId);
        BeanUtils.copyProperties(userDto,userEntity);

        UserEntity savedEntity = userRepository.save(userEntity);
        UserDto returnUser = new UserDto();
        BeanUtils.copyProperties(savedEntity,returnUser);
        return returnUser;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
