package com.example.service;

import com.example.dto.ProductDTO;
import com.example.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll();

    Product getById(Long id);

    Optional<Product> findByDescription(String description);

    void create(ProductDTO productDTO);

    void update(ProductDTO productDTO);

    void deleteById(Long id);

}
