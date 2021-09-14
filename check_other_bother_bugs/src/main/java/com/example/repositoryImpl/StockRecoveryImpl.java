//package com.example.repositoryImpl;
//
//import com.example.dto.StockRecoveryDTO;
//import com.example.repository.StockRecoverRepositoryCustom;
//import com.querydsl.jpa.impl.JPAQuery;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//public class StockRecoveryImpl  implements StockRecoverRepositoryCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<StockRecoveryDTO> findFinalStockDTO(){
//        JPAQuery<StockRecoveryDTO> stockRecoveryDTOJPAQuery = new JPAQuery<>(entityManager);
//        QStockRecoveryDTO
//    }
//}
