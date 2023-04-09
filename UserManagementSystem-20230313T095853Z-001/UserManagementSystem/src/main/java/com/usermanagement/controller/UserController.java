package com.usermanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import com.usermanagement.service.exception.AuthenticationException;
import com.usermanagement.service.impl.EmailSendService;

import jakarta.mail.MessagingException;


@RestController
@RequestMapping("/api")
public class UserController {

	
	public static String role="";
	@Autowired
	private UserService userservice;


	@Autowired
	private EmailSendService servicec;
	
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createuser( @RequestBody UserDto userdto) throws Exception
	{
	
		if(role.equalsIgnoreCase("admin"))
		{
		UserDto createUser = this.userservice.createUser(userdto);
		
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);

		}
		else
		{
			 throw new AuthenticationException("Please login with admin first");
		}
		
		
		}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserDto> updateuser( @RequestBody UserDto userdto,@PathVariable Integer id)
	{
	
		UserDto createUser = this.userservice.updateUser(userdto, id);
		
		return  ResponseEntity.ok(createUser);
	}
	
	
	@GetMapping("/getalluser")
	public ResponseEntity<UserDto> getuserAll(
			@RequestParam(value="pageNumber", defaultValue = "2" ,required = false) Integer pageNumber,
			@RequestParam(value="pageSize", defaultValue = "2" ,required = false)Integer pageSize)
	{
		 List<UserDto> allUser = userservice.getAllUser(pageNumber, pageSize);
		 
		return new ResponseEntity<UserDto>((UserDto) allUser, HttpStatus.FOUND);
	}
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<UserDto> getusers(@PathVariable Integer id)
	{
		return ResponseEntity.ok(this.userservice.getUser(id));
	}
	
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable Integer id)
	{
		this.userservice.deleteUser(id);
		
		return "User Deleted Successfully";
	}
	
	
	

	@GetMapping("/adminlogin/username/{name}/password/{password}")
	public String adminlogin(@PathVariable String name , @PathVariable String password)
	{

		User user = this.userservice.findByNameAndPassword(name, password);
		
		
		String rol = user.getRoles();
		
		role=rol;

		return rol+"Login Successfully";
	
	}
	

	
	
	
	
}
