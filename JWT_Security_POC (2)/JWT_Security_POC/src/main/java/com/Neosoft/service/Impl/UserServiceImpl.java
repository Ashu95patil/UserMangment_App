package com.Neosoft.service.Impl;

import com.Neosoft.controller.UserController;
import com.Neosoft.dto.UserDto;
import com.Neosoft.exception.ResourceNotFoundException;
import com.Neosoft.model.Role;
import com.Neosoft.payloads.AppConstants;
import com.Neosoft.repository.RoleRepo;
import com.Neosoft.repository.UserRepo;
import com.Neosoft.model.User;
import com.Neosoft.service.UserServiceI;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceI {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserDto saveUser(UserDto userDto) {
        logger.info("Initiating dao call for the Save the user data ");
        User user = this.modelMapper.map(userDto, User.class);
        User saveUser = this.userRepo.save(user);
        logger.info("Completed dao call for the Save the user data ");
        return this.modelMapper.map(saveUser,UserDto.class);
    }
    @Override
    public UserDto getSingleUser(Long userId) {
        logger.info("Initiating dao call for the get Single user with Id:{}",userId);
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + userId));
        logger.info("Completed dao call for the get Single user with Id:{}",userId);
        return this.modelMapper.map(user, UserDto.class);
    }
    @Override
    public List<UserDto> getAllUser() {
        logger.info("Initiating dao call for the get all Users");
        List<User> allUser = userRepo.findAll();
        List<UserDto> userDtos = allUser.stream().map((user) -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        logger.info("Completed dao call for the get all Users");
        return userDtos;
    }
    @Override
    public UserDto updateUser(UserDto user, Long userId) {
        logger.info("Initiating dao call for the update user data with Id:{}",userId);
        User user1 = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + userId));
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());

        User updatedUser = userRepo.save(user1);
        logger.info("Completed dao call for the update user data with Id:{}",userId);
        return this.modelMapper.map(updatedUser, UserDto.class);
    }
    @Override
    public void deleteUser(Long userId) {
        logger.info("Initiating dao call for the delete user data with Id:{}",userId);
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + userId));
        logger.info("Completed dao call for the delete user data with Id:{}",userId);
        userRepo.delete(user);
    }

    @Override
    public List<UserDto> getUserBySalary(Double salary) {
        logger.info("Initiating dao call for the get all Users as per salary");
        List<User> userbySalary = this.userRepo.findBySalary(salary);
      //  List<User> collect = userbySalary.stream().filter(e -> e.getSalary() < 15000).toList();
        List<UserDto> userDtos = userbySalary.stream().map((usersalary) -> this.modelMapper.map(usersalary, UserDto.class)).collect(Collectors.toList());
        logger.info("Completed dao call for the get all Users as per salary");
        return userDtos;
    }

    @Override
    public UserDto registerNewUser(UserDto userDto) {

        logger.info("Initiating dao call for the Register new user data");
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
        user.getRoles().add(role);
        User regUser = this.userRepo.save(user);
        logger.info("Completed dao call for the Register new user data");
        return this.modelMapper.map(regUser,UserDto.class);
    }
}
