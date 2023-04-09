package com.codewithashu.user.service;

import java.util.List;

import com.codewithashu.user.payload.DepartmentDto;

import com.codewithashu.user.payload.DepartmentResponse;


public interface DepartmentService {

	
	DepartmentDto createDepartment(DepartmentDto departmentDto);

	DepartmentDto updateDepartment(DepartmentDto departmentDto, Integer dep_id);

	void deleteDepartment(Integer dep_id);

	DepartmentDto getDepartment(Integer dep_id);

	List<DepartmentDto> getAllDepartment();

}
