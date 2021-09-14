package com.example.repositoryImpl;

import com.example.entity.QShelve;
import com.example.entity.Shelve;
import com.example.repository.ShelveRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ShelveRepositoryImpl implements ShelveRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Shelve findByDescription(String description) {
        JPAQuery<Shelve> shelveJPAQuery = new JPAQuery<>(entityManager);
        QShelve shelve = QShelve.shelve;

        Shelve shelve1 = shelveJPAQuery.select(shelve)
                .from(shelve).where(shelve.description_shelve.eq(description))
                .fetchOne();

        return shelve1;
    }
}
