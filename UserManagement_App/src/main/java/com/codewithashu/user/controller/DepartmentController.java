package com.codewithashu.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithashu.user.constant.AppConstant;
import com.codewithashu.user.payload.DepartmentDto;
import com.codewithashu.user.payload.DepartmentResponse;
import com.codewithashu.user.service.DepartmentService;


@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	

	
	@PostMapping("/depts")
	
     public ResponseEntity<DepartmentDto> createDepartment( @RequestBody DepartmentDto departmentDto) {
		

                 
                 DepartmentDto createDep = this.departmentService.createDepartment(departmentDto);
		     return new ResponseEntity<DepartmentDto>(createDep, HttpStatus.CREATED);


	}

	@PutMapping("/depts/{dep_id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@Valid @RequestBody DepartmentDto departmentDto, @PathVariable Integer dep_id) {

		DepartmentDto updateDep = this.departmentService.updateDepartment(departmentDto, dep_id);
		
		return new ResponseEntity<DepartmentDto>(updateDep, HttpStatus.CREATED);

	}

	@DeleteMapping("/depts/{dep_id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Integer dep_id) {
		
		this.departmentService.deleteDepartment(dep_id);

		return new ResponseEntity<String>(AppConstant.DEPARTMENT_DELETE, HttpStatus.OK);

	}

	@GetMapping("/depts")

	public ResponseEntity<List<DepartmentDto>> getAllDepartment() {

		List<DepartmentDto> allDepartment = this.departmentService.getAllDepartment();

		return new ResponseEntity<List<DepartmentDto>>(allDepartment, HttpStatus.OK);
	}

	@GetMapping("/depts/{dep_id}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Integer dep_id) {

		 DepartmentDto getDep = this.departmentService.getDepartment(dep_id);

		return new ResponseEntity<DepartmentDto>(getDep, HttpStatus.OK);
	}


}
