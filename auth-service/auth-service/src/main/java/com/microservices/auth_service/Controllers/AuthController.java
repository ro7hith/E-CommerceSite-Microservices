package com.microservices.auth_service.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.microservices.auth_service.Model.Dao.Services.AuthService;
import com.microservices.auth_service.Model.Pojo.OurUsers;
import com.microservices.auth_service.Model.Repositories.UserRepo;
import com.microservices.auth_service.Model.dto.AuthRequest;

@RestController
@RequestMapping("/auth")
//@CrossOrigin
public class AuthController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	AuthService authService;
	@Autowired
	AuthenticationManager authenticationManager;
	@PostMapping("/register")
	public String SaveUser(@RequestBody AuthRequest authRequest)
	{
		return authService.SaveUser(authRequest);
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('user')")
	public List<OurUsers> getUser() {
		System.out.println("getUsers");
		return  userRepo.findAll();
	}
	@PostMapping("/token")
	public ResponseEntity<Map<String,String>> getToken(@RequestBody AuthRequest request)
	//public ResponseEntity<String> getToken(@RequestBody AuthRequest request)
	{
		Map<String,String> map=new HashMap<String, String>();
	
		try {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
		System.out.println("Before");
		if(authentication.isAuthenticated())
		{
			System.out.println("After");
			System.out.println(request.getEmail());
			map.put("roles", authentication.getAuthorities().toArray()[0].toString());
			map.put("token", authService.generateToken(request.getEmail()));
			System.out.println(map.get("token"));
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		else
			map.put("Error","Please Enter Credentials");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		
		}
		catch(Exception ex)
		{
			map.put("Error","Invalid Credentials");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
			}
	}
	@GetMapping("/validate")
	public String validateToken(@RequestParam String token)
	{
		authService.validate(token);
		return "Token Valid";
	}
	
}
