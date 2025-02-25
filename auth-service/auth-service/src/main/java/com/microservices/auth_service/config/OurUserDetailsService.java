package com.microservices.auth_service.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.microservices.auth_service.Model.Pojo.OurUsers;
import com.microservices.auth_service.Model.Repositories.UserRepo;
@Configuration
public class OurUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Load User BY Name");
		Optional<OurUsers>user	=userrepo.findByEmail(username);
			return user.map(OurUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"));
	}

}


