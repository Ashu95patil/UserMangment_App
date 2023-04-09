package com.codewithashu.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class ApiSecurity extends WebSecurityConfigurerAdapter{
	
	
	
	
	@Autowired
	private UserInfoUserDetailsService userinfoDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.authorizeRequests()
		.antMatchers("/api/adminlogin/**").permitAll()
		.antMatchers("/api/users/**").hasRole("Admin")
		.antMatchers("/api/depts/**").hasRole("Admin")

		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("isha").password(this.passwordEncoder().encode("1234")).roles("Admin");
//		auth.inMemoryAuthentication().withUser("tejal").password(this.passwordEncoder().encode("1234")).roles("Normal");
		auth.userDetailsService(userinfoDetailsService).passwordEncoder(passwordEncoder());
		
	}
	 
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		
//		
//		
//		return new UserInfoUserDetailsService();
//		
//	}
//	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		
//		return new BCryptPasswordEncoder();
//		
//	}
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//	{
//		return   http.csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/api/adminlogin").hasRole("admin")
//				
//				
//				.anyRequest().authenticated().and()
//			
//				
				
				
//			
//				.formLogin()
//				.and().build();
	
//		
		
	
		
		
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
		
//		
//	}
//	
//	private Object authorizRequests() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Bean  
//	public AuthenticationProvider authenticationProvider()
//	{
//		DaoAuthenticationProvider authenticationProvider =new DaoAuthenticationProvider();
//		
//		authenticationProvider.setUserDetailsService(userDetailsService());
//		
//		authenticationProvider.setPasswordEncoder(passwordEncoder());
//		return authenticationProvider;
//	}
	
	


}
