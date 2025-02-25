package com.microservices.auth_service.Model.Dao.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservices.auth_service.Model.Pojo.OurUsers;
import com.microservices.auth_service.Model.Repositories.UserRepo;
import com.microservices.auth_service.Model.dto.AuthRequest;

@Service
public class AuthService {
@Autowired
UserRepo userRepo;
@Autowired
PasswordEncoder passwordEncoder;
@Autowired
jwtService service;
public String SaveUser(AuthRequest authRequest)
{
	
	OurUsers users=new OurUsers();
	users.setEmail(authRequest.getEmail());
	users.setPassword(passwordEncoder.encode(authRequest.getPassword()));
	users.setRole(authRequest.getRoles());
	userRepo.save(users);
	return "User saved";

	}

public String generateToken(String email)
{
	return service.generateToken(email);
}
public void validate(String token)
{
service.validatetoken(token);	
}
}
