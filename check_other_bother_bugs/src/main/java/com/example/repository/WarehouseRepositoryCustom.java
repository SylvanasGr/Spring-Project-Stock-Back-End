package com.example.repository;

import com.example.entity.Warehouse;

public interface WarehouseRepositoryCustom {


    Warehouse findByDescription(String description);
}
