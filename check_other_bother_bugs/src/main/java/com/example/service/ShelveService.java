package com.example.service;

import com.example.dto.ShelveDTO;
import com.example.entity.Shelve;

import java.util.List;
import java.util.Optional;

public interface ShelveService {

    List<ShelveDTO> findAll();

    Shelve getById(Long id_shelve);

    Optional<Shelve> findByDescription(String description);

    void create(ShelveDTO shelveDTO);

    void update(ShelveDTO shelveDTO);

    void deleteById(Long id);
}
