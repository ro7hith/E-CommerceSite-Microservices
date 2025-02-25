package com.microservices.product_services.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.product_services.dto.ProductRequest;
import com.microservices.product_services.dto.ProductResponse;
import com.microservices.product_services.model.Product;
import com.microservices.product_services.services.ProductServices;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin
public class ProductController {
	@Autowired
	ProductServices productServices;
	
	 @PostMapping("/create")
	   @ResponseStatus(HttpStatus.CREATED)
	    public void createProduct(@RequestBody ProductRequest productRequest) {
	        //productService.createProduct(productRequest);
		   productServices.createProduct(productRequest);
		    
	 }
	 @GetMapping("/getProducts")
	    
	    public ResponseEntity<Object> getAllProducts() {
		 List<ProductResponse> list=productServices.getAllProducts();
			
		 if(list.size()!=0)	
				return ResponseEntity.of(Optional.of(list));
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No records found");
		
		 
	    }

	   

}
