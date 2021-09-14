package com.example.repositoryImpl;

import com.example.entity.QWarehouse;
import com.example.entity.Warehouse;
import com.example.repository.WarehouseRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class WarehouseRepositoryImpl implements WarehouseRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Warehouse findByDescription(String description) {
        JPAQuery<Warehouse> warehouseJPAQuery = new JPAQuery<>(entityManager);
        QWarehouse warehouse = QWarehouse.warehouse;

        Warehouse warehouse1 = warehouseJPAQuery.select(warehouse)
                .from(warehouse)
                .where(warehouse.description_warehouse.eq(description))
                .fetchOne();

        return warehouse1;
    }
}