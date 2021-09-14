package com.example.repository;

import com.example.entity.Shelve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve, Long>, ShelveRepositoryCustom{
}
