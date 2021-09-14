package com.example.rest;

import com.example.dto.WarehouseDTO;
import com.example.entity.Warehouse;
import com.example.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("/warehouse")
public class WarehouseRestController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/all")
    private List<WarehouseDTO> findAll() {
        return warehouseService.findAll();
    }

    @GetMapping(value = "{id_warehouse}")
    private Warehouse findById(@PathVariable final Long id_warehouse) {
        Warehouse warehouseDTO = warehouseService.getById(id_warehouse);
        if (warehouseDTO == null) {
            throw new RuntimeException(("Warehouse id not found -  " + id_warehouse));
        }
        return warehouseDTO;
    }

    @RequestMapping(value = "/dw/{description_warehouse}", method = RequestMethod.GET)
    private Optional<Warehouse> findByDescription(@PathVariable("description_warehouse") String description) {
        Optional<Warehouse> warehouse = warehouseService.findByDescription(description);
        if (warehouse == null) {
            throw new RuntimeException(("Warehouse description not found - " + description));
        }
        return warehouse;
    }


    @PostMapping("/create")
    private void create(@RequestBody WarehouseDTO warehouseDTO) {
        this.warehouseService.create(warehouseDTO);
    }

    @PutMapping("/update")
    private void update(@RequestBody WarehouseDTO warehouseDTO) {
        this.warehouseService.update(warehouseDTO);
    }

    @DeleteMapping("delete/{id_warehouse}")
    private void delete(@PathVariable final Long id_warehouse) {
        this.warehouseService.deleteById(id_warehouse);
    }

}