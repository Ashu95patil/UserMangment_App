package com.codewithashu.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithashu.user.model.User;
import com.codewithashu.user.model.Admin;

public interface UserRepo extends JpaRepository<User, Integer> {


	
	

}
