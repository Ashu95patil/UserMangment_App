package com.codewithashu.user.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.codewithashu.user.model.Admin;


@SuppressWarnings("serial")
public class UserInfoDetails implements UserDetails {

            Admin admin =new Admin();
	
	



	public UserInfoDetails(Admin admin) {
				super();
				this.admin = admin;
			}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		HashSet<SimpleGrantedAuthority> set=new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.admin.getRole()));
		return set;
		
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.admin.getPassword();
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.admin.getEmail();
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
