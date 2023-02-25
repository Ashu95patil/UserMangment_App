package com.codewithashu.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithashu.user.payload.AdminDto;
import com.codewithashu.user.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminLogin {
	
	@Autowired
	private AdminService userInfoService;
	
	
	@PostMapping("/userlogin")
	public ResponseEntity<AdminDto> createUserlogin(@Valid @RequestBody AdminDto userInfoDto)
	{
		AdminDto createuserlogin = this.userInfoService.createUser(userInfoDto);
		
		return new ResponseEntity<AdminDto>(createuserlogin,HttpStatus.CREATED);
	}
	
	

}
