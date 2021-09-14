package com.example.repository;

import com.example.entity.Shelve;

public interface ShelveRepositoryCustom {


    Shelve findByDescription(String description);
}
