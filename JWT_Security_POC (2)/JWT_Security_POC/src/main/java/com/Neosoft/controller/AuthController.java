package com.Neosoft.controller;

import com.Neosoft.dto.UserDto;
import com.Neosoft.exception.ApiException;
import com.Neosoft.model.User;
import com.Neosoft.payloads.AppConstants;
import com.Neosoft.payloads.JwtAuthRequest;
import com.Neosoft.payloads.JwtAuthResponse;
import com.Neosoft.repository.UserRepo;
import com.Neosoft.security.JwtTokenHelper;
import com.Neosoft.service.UserServiceI;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceI userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
        logger.info("Initiated request for register the user details");
        UserDto registerUser = this.userService.registerNewUser(userDto);
        logger.info("Completed request for register the user details");
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) {
        logger.info("Initiated request for login to create Token");
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        response.setUser(this.modelMapper.map((User) userDetails, UserDto.class));
        logger.info("Completed request for login to create Token");
        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            logger.error("Exception while trying to authenticationToken:{}",e.getMessage());
            throw new ApiException(AppConstants.INVALID_USERNAME_PASSWORD);
        }
    }

    @GetMapping("/user/")
    public ResponseEntity<UserDto> getUser(Principal principal) {
        logger.info("Initiated request for the get User");
        User user = this.userRepo.findByEmail(principal.getName()).get();
        logger.info("Completed request for the get User");
        return new ResponseEntity<UserDto>(this.modelMapper.map(user, UserDto.class), HttpStatus.OK);
    }

}
