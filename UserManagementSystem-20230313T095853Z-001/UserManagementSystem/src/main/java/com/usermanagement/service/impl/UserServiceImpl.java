package com.usermanagement.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.usermanagement.Repository.UserRepository;
import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import com.usermanagement.service.exception.ResourceNotFoundException;


@Service
public class UserServiceImpl implements UserService


{
	
	

	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDto createUser(UserDto userdto) {
	
		User user = this.dtoTouser(userdto);
		User saveuser = this.userRepo.save(user);
		return this.userTodto(saveuser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		user.setName(userdto.getName());
		
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		User updateduser = userRepo.save(user);
		return this.userTodto(updateduser);
	}

	@Override
	public UserDto getUser(Integer id) {
	
		User user =this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		 
		return this.userTodto(user);
	}

	@Override
	public List<UserDto> getAllUser(Integer pageNumber, Integer pageSize) {
	
		Pageable p=PageRequest.of(pageNumber, pageSize);
		
		 Page<User> page = this.userRepo.findAll(p);
		 List<User> content = page.getContent();
		
		List<UserDto> collect = content.stream().map((post)-> this.mapper.map(post, UserDto.class)).collect(Collectors.toList());
				
		 return collect;
	}

	@Override
	public void deleteUser(Integer id) {
		User user =this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		
		this.userRepo.delete(user);
		
	}
	
	private  User dtoTouser(UserDto userdto)
	{
		User user = this.mapper.map(userdto, User.class);
		/*
		 * user.setId(userdto.getId()); user.setEmail(userdto.getEmail());
		 * user.setPassword(userdto.getPassword());
		 * user.setUser_name(userdto.getUser_name()); user.setAbout(userdto.getAbout());
		 */		
		return user;
	} 
	
	public UserDto userTodto(User user)
	{
		UserDto userdto = this.mapper.map(user, UserDto.class);
		/*
		 * userdto.setId(user.getId()); userdto.setEmail(user.getEmail());
		 * userdto.setPassword(user.getPassword());
		 * userdto.setUser_name(user.getUser_name()); userdto.setAbout(user.getAbout());
		 */
		
		return userdto;
	}

	@Override
	public User findByNameAndPassword(String name, String password) {
	
		User user = this.userRepo.findByNameAndPassword(name, password);
		
		return user;
	}
	
	

}
