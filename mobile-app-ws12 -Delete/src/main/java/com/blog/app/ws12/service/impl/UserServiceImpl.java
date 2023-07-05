package com.blog.app.ws12.service.impl;

import com.blog.app.ws12.exception.UserServiceException;
import com.blog.app.ws12.io.entity.UserEntity;
import com.blog.app.ws12.io.repository.UserRepository;
import com.blog.app.ws12.service.UserService;
import com.blog.app.ws12.shared.Utils;
import com.blog.app.ws12.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        var userEntity = new UserEntity();
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
    public UserDto updateUser(String id, UserDto userDto) {
        var userEntity = userRepository.findByUserId(id);
        if(userEntity == null)
            throw new UserServiceException("User Not Exist !!! ");
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        UserEntity savedEntity = userRepository.save(userEntity);
        UserDto returnUser = new UserDto();
        BeanUtils.copyProperties(userEntity,returnUser);
        return returnUser;
    }

    @Override
    public UserDto deleteUser(String id) {
        var userEntity = userRepository.findByUserId(id);
        if(userEntity == null)
            throw new UserServiceException("User Not Exist !!! ");

        UserDto returnUser = new UserDto();
        BeanUtils.copyProperties(userEntity,returnUser);
        userRepository.delete(userEntity);

        return returnUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null)
            throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
