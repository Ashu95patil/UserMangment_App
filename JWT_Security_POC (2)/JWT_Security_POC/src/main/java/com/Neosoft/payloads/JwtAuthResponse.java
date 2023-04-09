package com.Neosoft.payloads;

import com.Neosoft.dto.UserDto;
import com.Neosoft.model.User;
import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
}
