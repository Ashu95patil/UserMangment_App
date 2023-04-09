package com.usermanagement.service;

import java.util.List;

import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;

public interface UserService {

	UserDto createUser(UserDto userdto);

	UserDto updateUser(UserDto userdto, Integer id);

	UserDto getUser(Integer id);

	List<UserDto> getAllUser(Integer pageNumber, Integer pageSize);

	void deleteUser(Integer id);

	
	public User findByNameAndPassword(String name, String password);

}
