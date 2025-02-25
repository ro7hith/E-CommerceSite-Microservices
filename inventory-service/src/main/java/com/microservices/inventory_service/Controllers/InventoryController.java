package com.microservices.inventory_service.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.microservices.inventory_service.dto.InventoryResponse;
import com.microservices.inventory_service.service.InventoryService;
@RestController
//@CrossOrigin
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	 @GetMapping("/")
	    @ResponseStatus(HttpStatus.OK)
	    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		 System.out.println(skuCode);
	        return inventoryService.isInStock(skuCode);
	    }

}
