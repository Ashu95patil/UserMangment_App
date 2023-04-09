package com.codewithashu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithashu.user.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	
	

}
