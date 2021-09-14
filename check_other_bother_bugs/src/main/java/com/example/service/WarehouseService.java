package com.example.service;

import com.example.dto.WarehouseDTO;
import com.example.entity.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    List<WarehouseDTO> findAll();

    Warehouse getById(Long id_warehouse);

    Optional<Warehouse> findByDescription(String description);

    void create(WarehouseDTO warehouseDTO);

    void update(WarehouseDTO warehouseDTO);

    void deleteById(Long id);
}