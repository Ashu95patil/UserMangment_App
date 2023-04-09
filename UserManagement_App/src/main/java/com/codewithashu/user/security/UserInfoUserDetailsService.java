package com.codewithashu.user.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithashu.user.model.Admin;
import com.codewithashu.user.repository.AdminRepo;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepo adminRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	  Optional<Admin> userinfO =adminRepo.findByEmail(email);
		
		return userinfO.map(UserInfoDetails::new).orElseThrow();
	}

}
