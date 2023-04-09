package com.Neosoft.controller;

import com.Neosoft.dto.UserDto;
import com.Neosoft.payloads.ApiResponse;
import com.Neosoft.payloads.AppConstants;
import com.Neosoft.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {
        logger.info("Initiated request for save the user details");
        UserDto saveUser = userServiceI.saveUser(userDto);
        logger.info("Completed request for save the user details");
        return new ResponseEntity<UserDto>(saveUser, HttpStatus.CREATED);
    }
    @GetMapping("/Users/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId) {
        logger.info("Initiated request for get the Single user with userId :{}",userId);
        UserDto singleUser = userServiceI.getSingleUser(userId);
        logger.info("Completed request for get the Single user with userId :{}",userId);
        return new ResponseEntity<>(singleUser, HttpStatus.OK);
    }
    @GetMapping("/Users")
    public ResponseEntity<List<UserDto>> getAllUser() {
        logger.info("Initiated request for get the All user details");
        List<UserDto> allUser = userServiceI.getAllUser();
        logger.info("Initiated request for get the All user details");
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
    @PutMapping("Users/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user,@PathVariable Long userId){
        logger.info("Initiated request for update the user data with userId:{}",userId);
        UserDto updatedUser = userServiceI.updateUser(user, userId);
        logger.info("Completed request for update the user data with userId:{}",userId);
     return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
    }
    @DeleteMapping("/Users/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
        logger.info("Initiated request for delete the user data with userId:{}",userId);
        userServiceI.deleteUser(userId);
        logger.info("Completed request for delete the user data with userId:{}",userId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.USER_DELETE,true),HttpStatus.OK);
    }

    @GetMapping("/users/{salary}")
    public ResponseEntity<List<UserDto>> getAllUsersBySalary(@PathVariable Double salary){
        logger.info("Initiated request for get the All user details");
        List<UserDto> userBySalary = this.userServiceI.getUserBySalary(salary);
        logger.info("Completed request for get the All user details");
        return new ResponseEntity<>(userBySalary,HttpStatus.OK);
    }
}
