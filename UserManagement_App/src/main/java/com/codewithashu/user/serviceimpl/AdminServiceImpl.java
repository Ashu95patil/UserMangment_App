package com.codewithashu.user.serviceimpl;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codewithashu.user.model.Admin;
import com.codewithashu.user.payload.AdminDto;
import com.codewithashu.user.repository.AdminRepo;
import com.codewithashu.user.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public AdminDto createUser(AdminDto adminDto) {

		Admin admin = this.modelMapper.map(adminDto, Admin.class);
		
		Admin saveUserInfo = this.adminRepo.save(admin);
		
		return this.modelMapper.map(saveUserInfo, AdminDto.class);
	}

	
	

}
