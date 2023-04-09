package com.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByNameAndPassword(String name, String password);

}
