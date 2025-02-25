package com.microservices.order_service.order_service.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Ordernumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItemsList;
	public Orders() {
		super();
	}
	public Orders(String Ordernumber, List<OrderLineItems> orderLineItems) {
		super();
		
		
		this.Ordernumber = Ordernumber;
		this.orderLineItemsList = orderLineItems;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrdernumber() {
		return Ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		Ordernumber = ordernumber;
	}
	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItemsList;
	}
	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItemsList = orderLineItems;
	}
	
}
