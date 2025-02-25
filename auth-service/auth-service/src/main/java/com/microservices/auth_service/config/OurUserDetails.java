package com.microservices.auth_service.config;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.microservices.auth_service.Model.Pojo.OurUsers;


public class OurUserDetails implements UserDetails 
{
	/**
	 * 
	 */
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private List<GrantedAuthority> roles;
	public OurUserDetails(OurUsers ourusers)
	{
		System.out.println("OurUSer Details");
		this.email=ourusers.getEmail();
		this.password=ourusers.getPassword();
		this.roles=Arrays.stream(ourusers.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
	return this.roles;
	
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	

}
