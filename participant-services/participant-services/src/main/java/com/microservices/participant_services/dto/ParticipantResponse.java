package com.microservices.participant_services.dto;

import java.math.BigDecimal;


public class ParticipantResponse {
	private Integer id;
	private String name;
	private String email;
	private int phone;
	private String topic;
	private String timepreference;
	private boolean transport;
	public ParticipantResponse() {}
	
	public ParticipantResponse(Integer id, String name, String email, int phone, String topic, String timepreference,
			boolean transport) {
		super();
		this.id = id;
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
