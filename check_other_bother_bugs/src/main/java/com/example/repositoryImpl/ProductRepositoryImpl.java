package com.example.repositoryImpl;


import com.example.entity.Product;
import com.example.entity.QProduct;
import com.example.repository.ProductRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product findByDescription(String description) {
        JPAQuery<Product> productJPAQuery = new JPAQuery<>(entityManager);
        QProduct product = QProduct.product;

        Product product1 = productJPAQuery.select(product)
                .from(product).where(product.description_product.eq(description))
                .fetchOne();

        return product1;
    }
}