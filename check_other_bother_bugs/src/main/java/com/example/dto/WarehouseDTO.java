package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarehouseDTO {
    private Long id_warehouse;
    private String description_warehouse;
//    private List<Management> warehouse_requests;
//    private List<Shelve> shelves;

    public WarehouseDTO() {
    }

    public Long getId_warehouse() {
        return id_warehouse;
    }

    public void setId_warehouse(Long id_warehouse) {
        this.id_warehouse = id_warehouse;
    }

    public String getDescription_warehouse() {
        return description_warehouse;
    }

    public void setDescription_warehouse(String description_warehouse) {
        this.description_warehouse = description_warehouse;
    }

//    public List<Management> getWarehouse_requests() {
//        return warehouse_requests;
//    }
//
//    public void setWarehouse_requests(List<Management> warehouse_requests) {
//        this.warehouse_requests = warehouse_requests;
//    }
//
//    public List<Shelve> getShelves() {
//        return shelves;
//    }
//
//    public void setShelves(List<Shelve> shelves) {
//        this.shelves = shelves;
//    }
}