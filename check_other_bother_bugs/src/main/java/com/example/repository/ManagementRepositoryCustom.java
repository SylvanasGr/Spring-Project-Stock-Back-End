package com.example.repository;

import com.example.dto.StockRecoveryDTO;
import com.example.entity.Management;

import java.util.List;

public interface ManagementRepositoryCustom {
    Management findByDescription(String description);

    List<StockRecoveryDTO> findImports();

    List<StockRecoveryDTO> findExports();

//    StockRecoveryDTO findTotalImport();
}
