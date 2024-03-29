package com.codewithashu.user.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
import com.codewithashu.user.payload.UserDto;
import com.codewithashu.user.payload.UserResponse;
import com.codewithashu.user.repository.DepartmentRepo;
import com.codewithashu.user.repository.UserRepo;
import com.codewithashu.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto, Integer dep_id) {

		Department dept = departmentRepo.findById(dep_id)
				.orElseThrow(() -> new UserNotFoundException(AppConstant.DEPARTMENT, AppConstant.DEP_ID, dep_id));

		userDto.setIsactive(AppConstant.YES);

		User user = this.modelMapper.map(userDto, User.class);

		user.setDepartments(dept);
		

		User saveUser = this.userRepo.save(user);

		return this.modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(AppConstant.USER, AppConstant.USER_ID, userId));

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setDob(userDto.getDob());
		user.setGender(userDto.getGender());
		user.setPhno(userDto.getPhno());
		user.setCountry(userDto.getCountry());
		user.setState(userDto.getState());
		user.setCity(userDto.getCity());

		User updateUser = this.userRepo.save(user);

		return this.modelMapper.map(updateUser, UserDto.class);
	}

	@Override
	public boolean deleteUser(Integer userId) {

		Optional<User> findById = this.userRepo.findById(userId);
		if (findById.isPresent()) {
			User user = findById.get();

			user.setIsactive(AppConstant.NO);
			userRepo.save(user);

			return true;

		} else {

			throw new UserNotFoundException(AppConstant.USER, AppConstant.USER_ID, userId);
		}

	}

	@Override
	public UserDto getuser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(AppConstant.USER, AppConstant.USER_ID, userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserResponse getAllUser(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		Sort sort = (sortDir.equalsIgnoreCase(AppConstant.SORT_DIR) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending());

		PageRequest p = PageRequest.of(pageNumber, pageSize, sort);

		Page<User> pageuser = this.userRepo.findAll(p);

		List<User> alluser = pageuser.getContent();

		List<UserDto> allusers = alluser.stream().map((use) -> this.modelMapper.map(use, UserDto.class))
				.collect(Collectors.toList());

		UserResponse userResponse = new UserResponse();

		userResponse.setContent(allusers);
		userResponse.setPageNumber(pageuser.getNumber());
		userResponse.setPageSize(pageuser.getSize());
		userResponse.setTotalElement(pageuser.getTotalElements());
		userResponse.setTotalPage(pageuser.getTotalPages());
		userResponse.setLastPage(pageuser.isLast());

		return userResponse;
	}

}
