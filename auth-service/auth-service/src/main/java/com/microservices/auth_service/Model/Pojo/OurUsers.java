package com.microservices.auth_service.Model.Pojo;

import jakarta.persistence.*;

@Entity

public class OurUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 60)
	private String password;
	@Column(length = 15)
	private String roles;
	

	public String getRoles() {
		return roles;
	}

	public void setRole(String roles) {
		this.roles = roles;
	}

	public OurUsers() {
		super();
	}

	public OurUsers( String email, String password,String role) {
		super();
		
		this.email = email;
		this.password = password;
		this.roles=role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
