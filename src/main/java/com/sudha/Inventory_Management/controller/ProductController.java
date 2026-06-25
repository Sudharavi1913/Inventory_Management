package com.sudha.Inventory_Management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudha.Inventory_Management.entity.ProductEntity;
import com.sudha.Inventory_Management.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	 private final ProductService service;

	    public ProductController(ProductService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public ProductEntity saveProduct(@RequestBody ProductEntity product) {
	        return service.saveProduct(product);
	    }

	    @GetMapping
	    public List<ProductEntity> getAllProducts() {
	        return service.getAllProducts();
	    }

	    @GetMapping("/{id}")
	    public ProductEntity getProductById(@PathVariable Long id) {
	        return service.getProductById(id);
	    }

	    @PutMapping("/{id}")
	    public ProductEntity updateProduct(@PathVariable Long id,
	                                 @RequestBody ProductEntity product) {
	        return service.updateProduct(id, product);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteProduct(@PathVariable Long id) {
	        service.deleteProduct(id);
	        return "Product Deleted Successfully";
	    }

}
