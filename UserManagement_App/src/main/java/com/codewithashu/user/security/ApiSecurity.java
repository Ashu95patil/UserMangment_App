package com.codewithashu.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ApiSecurity {
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		
		
		
		return new UserInfoUserDetailsService();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable()
				.authorizeHttpRequests()
				.antMatchers("/api/userlogin").permitAll()
				.and()

				.authorizeHttpRequests()
				.antMatchers("/api/users/{userId}")
				.authenticated()
				.and().formLogin()
				.and().build();
	
		
		
	
		
		
//		http.antMatcher("/api/")
//		.authorizeRequests().anyRequest().hasAuthority("admin")
//		.and()
//		.formLogin()
//		.loginPage("/api/userlogin")
//		.usernameParameter("email")
//		.loginProcessingUrl("/api/userlogin")
//		.defaultSuccessUrl("/swagger-ui.html#/")
//		.permitAll();
//		
//		return http.build();
//		
		
		
	}
	
	@Bean  
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider =new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(userDetailsService());
		
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	


}
