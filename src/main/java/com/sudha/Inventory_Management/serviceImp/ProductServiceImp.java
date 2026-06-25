package com.sudha.Inventory_Management.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudha.Inventory_Management.entity.ProductEntity;
import com.sudha.Inventory_Management.repository.ProductRepository;
import com.sudha.Inventory_Management.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return repository.save(product);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductEntity product) {

        ProductEntity existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setProductName(product.getProductName());
            existing.setCategory(product.getCategory());
            existing.setBrand(product.getBrand());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            existing.setDescription(product.getDescription());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}