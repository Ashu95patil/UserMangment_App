package com.codewithashu.user.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.codewithashu.user.model.Department;
import com.codewithashu.user.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	

	private Integer userId;

	@NotEmpty
     private String firstName;
    
	@NotEmpty
	private String lastName;

	@Email(message = "Email address is not valid !!")
	private String email;

	@NotEmpty
	
	//@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[#$@!%&?])[A-Za-z\\d#$@!%&?]{8,}$")
    private String password;

	
	private Long phno;

	
	private Date dob;

	@NotEmpty
	private String gender;

	@NotEmpty
	private String country;

	@NotEmpty
	private String state;

	@NotEmpty
	private String city;
	
	private String isactive;
	
	private List<User> user;




}



