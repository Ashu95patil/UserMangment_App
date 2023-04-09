package com.Neosoft.security;

import com.Neosoft.controller.UserController;
import com.Neosoft.exception.ResourceNotFoundException;
import com.Neosoft.model.User;
import com.Neosoft.payloads.AppConstants;
import com.Neosoft.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Initiating for get user from database for UserDetails");
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND));
        logger.info("Completed for get user from database for UserDetails");
        //user.getSalary()
        return user;
    }
}
