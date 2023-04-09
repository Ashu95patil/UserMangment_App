package com.Neosoft.service;

import com.Neosoft.dto.UserDto;
import com.Neosoft.model.User;

import java.util.List;

public interface UserServiceI {

    UserDto registerNewUser(UserDto user);

    UserDto saveUser(UserDto user);

    UserDto getSingleUser(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto user,Long userId);

    void deleteUser(Long userId);

    List<UserDto> getUserBySalary(Double salary);

}
