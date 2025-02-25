package com.microservices.order_service.order_service.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.order_service.order_service.dto.OrderRequest;
import com.microservices.order_service.order_service.model.Orders;
import com.microservices.order_service.order_service.services.OrderServices;

@RestController
//@CrossOrigin
@RequestMapping("/api/order")
public class OrderController 
{
	@Autowired
	OrderServices orderServices;
	
	 @PostMapping("/placeorder")
	    public String placeOrder(@RequestBody OrderRequest orderRequest) 
	 {
	 try {
		 System.out.println(orderRequest);
		   orderServices.placeOrder(orderRequest);
		    return "Placed";
	}
	catch(IllegalArgumentException e)
	{
		return e.getMessage();
	}
	}
	 @GetMapping("/getOrders")
	    
	    public List<Orders> getAllOrders() {
	        return orderServices.getAllProducts();
	    }

	   

}
