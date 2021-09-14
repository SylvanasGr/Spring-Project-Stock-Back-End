package com.example.repository;

import com.example.entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends JpaRepository<Management,Long>,ManagementRepositoryCustom{
}
