package com.example.serviceImpl;

import com.example.dto.WarehouseDTO;
import com.example.entity.Warehouse;
import com.example.repository.WarehouseRepository;
import com.example.service.WarehouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehousesRepository;

    public Warehouse toEntity(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = new Warehouse();
        BeanUtils.copyProperties(warehouseDTO, warehouse);
        return warehouse;
    }

    public WarehouseDTO toDTO(Warehouse warehouse) {
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        BeanUtils.copyProperties(warehouse, warehouseDTO);
        return warehouseDTO;
    }
    @Override
    public List<WarehouseDTO> findAll() {
        List<Warehouse> warehouseList = this.warehousesRepository.findAll();
        List<WarehouseDTO> warehouseDTOList = new ArrayList<>();

        for (Warehouse warehouse : warehouseList) {
            warehouseDTOList.add(this.toDTO(warehouse));
        }
        return warehouseDTOList;
    }

    @Override
    public Warehouse getById(Long id_warehouse) {
        Optional<Warehouse> result = warehousesRepository.findById(id_warehouse);
        Warehouse theWarehouse = null;

        if (result.isPresent()) {
            theWarehouse = result.get();
        } else {
            throw new RuntimeException("Did not find warehouse id - " + id_warehouse);
        }
        return theWarehouse;
    }

    @Override
    public Optional<Warehouse> findByDescription(String description){
        Optional<Warehouse> result = Optional.ofNullable(warehousesRepository.findByDescription(description));
        return result;
    }

    @Override
    public void create(WarehouseDTO warehouseDTO) {
        if(warehouseDTO!=null && warehouseDTO.getId_warehouse()==null){
            this.warehousesRepository.save(this.toEntity(warehouseDTO));
        }

    }

    @Override
    public void update(WarehouseDTO warehouseDTO) {
        if(warehouseDTO!=null && warehouseDTO.getId_warehouse()!=null){
            this.warehousesRepository.save(this.toEntity(warehouseDTO));
        }
    }
    @Override
    public void deleteById(Long id) {
        if (id != null) {
            this.warehousesRepository.deleteById(id);
        }
    }
}