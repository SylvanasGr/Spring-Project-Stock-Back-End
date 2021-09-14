package com.example.service;

import com.example.dto.ManagementDTO;
import com.example.dto.StockRecoveryDTO;
import com.example.entity.Management;

import java.util.List;

public interface ManagementService {


    List<ManagementDTO> findAll();

    Management getById(Long id_action);

    List<Management> findByDescription(String description);

    List<StockRecoveryDTO> findImports();

    List<StockRecoveryDTO> findExports();

    void create(ManagementDTO managementDTO);

    void update(ManagementDTO managementDTO);

    void deleteById(Long id);
}
