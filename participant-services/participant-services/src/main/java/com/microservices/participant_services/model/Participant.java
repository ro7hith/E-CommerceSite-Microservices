package com.microservices.participant_services.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Participant {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private int phone;
	private String topic;
	private String timepreference;
	private boolean transport;

	public Participant() {
		super();
	}
	public Participant( String name, String email, int phone, String topic, String timepreference,
			boolean transport) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.topic = topic;
		this.timepreference = timepreference;
		this.transport = transport;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTimepreference() {
		return timepreference;
	}
	public void setTimepreference(String timepreference) {
		this.timepreference = timepreference;
	}
	public boolean getTransport() {
		return transport;
	}
	public void setTransport(boolean transport) {
		this.transport = transport;
	}
	
	
}