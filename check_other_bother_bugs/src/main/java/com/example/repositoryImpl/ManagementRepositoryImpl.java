package com.example.repositoryImpl;

import com.example.dto.StockRecoveryDTO;
import com.example.entity.Management;
import com.example.entity.QManagement;
import com.example.entity.QProduct;
import com.example.repository.ManagementRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ManagementRepositoryImpl implements ManagementRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Management findByDescription(String description) {
        JPAQuery<Management> managementJPAQuery = new JPAQuery<>(entityManager);
        QManagement management = QManagement.management;

        Management management1 = (Management) managementJPAQuery.select(management)
                .from(management).where(management.action_description.eq(description))

                .fetch();

        return management1;
    }

    @Override
    public List<StockRecoveryDTO> findImports() {
        JPAQuery<StockRecoveryDTO> stockRecoveryDTOJPAQuery = new JPAQuery<>(entityManager);
        QManagement management = QManagement.management;
        QProduct product = QProduct.product;

        return stockRecoveryDTOJPAQuery.select(Projections.bean(StockRecoveryDTO.class,
                product.id_product,
                management.date,
                product.quantity_product,
                management.action_description,
                management.id_action))
                .from(management)
                .innerJoin(product)
                .on(management.product_id.eq((product))
                        .and(management.action_description.eq("import"))).fetch();
    }


    @Override
    public List<StockRecoveryDTO> findExports() {
        JPAQuery<StockRecoveryDTO> stockRecoveryDTOJPAQuery = new JPAQuery<>(entityManager);
        QManagement management = QManagement.management;
        QProduct product = QProduct.product;

        return stockRecoveryDTOJPAQuery.select(Projections.bean(StockRecoveryDTO.class,
                product.id_product,
                management.date,
                product.quantity_product,
                management.action_description,
                management.id_action))
                .from(management)
                .innerJoin(product)
                .on(management.product_id.eq(product)
                        .and(management.action_description.eq("export"))).fetch();
    }


//    @Override
//    public StockRecoveryDTO findTotalImport(){
//      JPAQuery<StockRecoveryDTO> stockRecoveryDTOJPAQuery = new JPAQuery<>(entityManager);
//      QManagement management = QManagement.management;
//      QProduct product = QProduct.product;
//
//      return stockRecoveryDTOJPAQuery.select(Projections.bean(StockRecoveryDTO.class,
//              product.id_product,
//              management.date,
//              product.quantity_product,
//              management.action_description))
//    }
//

}