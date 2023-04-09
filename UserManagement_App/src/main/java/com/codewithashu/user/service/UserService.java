package com.codewithashu.user.service;

import java.util.List;

import com.codewithashu.user.payload.UserDto;
import com.codewithashu.user.payload.UserResponse;

public interface UserService {

	UserDto createUser(UserDto userDto,Integer dep_id);

	UserDto updateUser(UserDto userDto, Integer userId);

	boolean deleteUser(Integer userId);

	UserDto getuser(Integer userId);

	UserResponse getAllUser(Integer pageNumber,Integer pageSize,String sortBy ,String sortDir);

}
