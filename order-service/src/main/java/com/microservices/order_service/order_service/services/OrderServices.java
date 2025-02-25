package com.microservices.order_service.order_service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.order_service.order_service.dto.InventoryResponse;
import com.microservices.order_service.order_service.dto.OrderItemsDto;
import com.microservices.order_service.order_service.dto.OrderRequest;
import com.microservices.order_service.order_service.model.Orders;
import com.microservices.order_service.order_service.model.OrderLineItems;
import com.microservices.order_service.order_service.repository.OrderRepository;

@Service
@Transactional
public class OrderServices {
	@Autowired
	WebClient.Builder webClient;
	@Autowired
	OrderRepository orderRepository;
	 public void placeOrder(OrderRequest orderRequest) {
	        Orders order = new Orders();
	      order.setOrdernumber(UUID.randomUUID().toString());
	        List<OrderLineItems> orderLineItems = orderRequest.getOrderItemsDtos()
	                .stream()
	                .map(this::mapToDto)
	                .toList();

	        order.setOrderLineItems(orderLineItems);
	       List<String> skuCodes= order.getOrderLineItems().stream().map(i->i.getSkuCode()).toList();
	        System.out.println(order.getOrdernumber() +" order Number");
	        System.out.println(order.getOrderLineItems().size());
	       InventoryResponse[] inventoryResponses= webClient.build().get().uri("http://inventory-service/api/inventory/",
	    		   uriBuilder->uriBuilder.queryParam("skuCode", skuCodes).build())
	    		   .retrieve().bodyToMono(InventoryResponse[].class).block();
	       if(inventoryResponses.length!=0)
	       {
	       System.out.println(inventoryResponses.length+ "length");
	      boolean allProductsInStock=  Arrays.stream(inventoryResponses).allMatch(i->i.isInStock() );
	      System.out.println(allProductsInStock);
	      if(allProductsInStock)
	    	  orderRepository.save(order);
	      else
	    	throw new IllegalArgumentException("Product is not in stock");  
	       }
	       else
	    	   throw new IllegalArgumentException("Product is not in inventory");
	        
	 }
	 private OrderLineItems mapToDto(OrderItemsDto orderLineItemsDto) {
	        OrderLineItems orderLineItems = new OrderLineItems();
	        orderLineItems.setPrice(orderLineItemsDto.getPrice());
	        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
	        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
	        return orderLineItems;
	    }
	 public List<Orders> getAllProducts()
	 {
		 return orderRepository.findAll();
	 }
}
