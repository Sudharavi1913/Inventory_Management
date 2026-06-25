package com.sudha.Inventory_Management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudha.Inventory_Management.entity.ProductEntity;

@Service
public interface ProductService {
	
    ProductEntity saveProduct(ProductEntity product);

    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(Long id);

    ProductEntity updateProduct(Long id, ProductEntity product);

    void deleteProduct(Long id);
	
	

}
