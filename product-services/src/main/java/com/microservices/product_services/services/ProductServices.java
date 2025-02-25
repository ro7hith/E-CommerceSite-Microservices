package com.microservices.product_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.product_services.dto.ProductRequest;
import com.microservices.product_services.dto.ProductResponse;
import com.microservices.product_services.model.Product;
import com.microservices.product_services.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository productRepository;
	public void createProduct(ProductRequest productRequest)
	{
		  Product product = new Product(
	                productRequest.getName(),
	                productRequest.getDescription(),
	                productRequest.getPrice());
	               

	        productRepository.save(product);
	        //log.info("Product {} is saved", product.getId());
	    }

	    public List<ProductResponse> getAllProducts() {
	        List<Product> products = productRepository.findAll();

	        return products.stream().map(this::mapToProductResponse).toList();
	    }

	    private ProductResponse mapToProductResponse(Product product) {
	        return new ProductResponse(
	                product.getId(),
	                product.getName(),
	                product.getDescription(),
	                product.getPrice());
	                
	    }

}
