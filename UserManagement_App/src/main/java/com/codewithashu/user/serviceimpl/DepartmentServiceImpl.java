package com.codewithashu.user.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithashu.user.constant.AppConstant;
import com.codewithashu.user.exception.UserNotFoundException;
import com.codewithashu.user.model.Department;
import com.codewithashu.user.model.User;
import com.codewithashu.user.payload.DepartmentDto;
import com.codewithashu.user.payload.DepartmentResponse;
import com.codewithashu.user.payload.UserDto;
import com.codewithashu.user.payload.UserResponse;
import com.codewithashu.user.repository.DepartmentRepo;
import com.codewithashu.user.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {

		Department department = this.modelMapper.map(departmentDto, Department.class);

		Department saveDep = this.departmentRepo.save(department);

		return this.modelMapper.map(saveDep, DepartmentDto.class);

	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto, Integer dep_id) {

		Department department = this.departmentRepo.findById(dep_id)
				.orElseThrow(() -> new UserNotFoundException(AppConstant.DEPARTMENT, AppConstant.DEP_ID, dep_id));

		department.setDep_id(departmentDto.getDep_id());
		department.setDep_name(departmentDto.getDep_name());
		department.setUser(departmentDto.getUser());

		Department updateDep = this.departmentRepo.save(department);

		return this.modelMapper.map(updateDep, DepartmentDto.class);
	}

	@Override
	public void deleteDepartment(Integer dep_id) {
		Department department = this.departmentRepo.findById(dep_id)
				.orElseThrow(() -> new UserNotFoundException(AppConstant.DEPARTMENT, AppConstant.DEP_ID, dep_id));

		departmentRepo.delete(department);

	}

	@Override
	public DepartmentDto getDepartment(Integer dep_id) {

		Department department = this.departmentRepo.findById(dep_id)
				.orElseThrow(() -> new UserNotFoundException(AppConstant.DEPARTMENT, AppConstant.DEP_ID, dep_id));

		return this.modelMapper.map(department, DepartmentDto.class);

	}

	@Override
	public List<DepartmentDto> getAllDepartment() {

		List<Department> findAll = this.departmentRepo.findAll();

		;

		List<DepartmentDto> allDep = findAll.stream().map((dep) -> this.modelMapper.map(dep, DepartmentDto.class))
				.collect(Collectors.toList());

		return allDep;
	}

}
