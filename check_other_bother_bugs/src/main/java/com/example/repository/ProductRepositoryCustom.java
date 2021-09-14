package com.example.repository;

import com.example.entity.Product;

public interface ProductRepositoryCustom {
    Product findByDescription(String description);
}
