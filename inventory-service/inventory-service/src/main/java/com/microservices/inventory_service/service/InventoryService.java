package com.microservices.inventory_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.inventory_service.dto.InventoryResponse;
import com.microservices.inventory_service.repositories.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository inventoryRepository;
	@Transactional(readOnly=true)
	 public List<InventoryResponse> isInStock(List<String> skuCode) {
	      
		List<InventoryResponse>l= inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory->maptoInventoryResponse(inventory.getSkuCode(), inventory.getQuantity()>0)).toList();
		//List<InventoryResponse>l=skuCode.stream().forEach(i->{inventoryRepository.findBySkuCode(i).get()!=null});
		System.out.println(l+ "Responses ");
		return l;
	}
				
	
public InventoryResponse maptoInventoryResponse(String skuCode,boolean qty)
{
	System.out.println(skuCode+ " "+qty);
	return new InventoryResponse(skuCode,qty);

}
				
				
}
	
