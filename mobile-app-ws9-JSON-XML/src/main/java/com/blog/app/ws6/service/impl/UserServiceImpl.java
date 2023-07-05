package com.blog.app.ws6.service.impl;

import com.blog.app.ws6.io.entity.UserEntity;
import com.blog.app.ws6.io.repository.UserRepository;
import com.blog.app.ws6.service.UserService;
import com.blog.app.ws6.shared.Utils;
import com.blog.app.ws6.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) throw new UsernameNotFoundException(email);
        UserDto returnUser = new UserDto();
        BeanUtils.copyProperties(userEntity,returnUser);
        return returnUser;
    }

    @Override
    public UserDto getUserByUserId(String id) {
        UserEntity userEntity = userRepository.getUserEntityById(id);
        if(userEntity == null) throw new UsernameNotFoundException("User Not Exist");
        UserDto returnUserDto = new UserDto();
        BeanUtils.copyProperties(userEntity,returnUserDto);
        return returnUserDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null)
            throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
