package com.example.dto;

import com.example.entity.Product;
import com.example.entity.Warehouse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShelveDTO {


    private Long id_shelve;
    private String description_shelve;
//    private List<Product> products;
    //warehouse_shelve == war_id == the connection with Warehouse table
    private Warehouse war_id;
    private List<Product> products;


    public ShelveDTO() {

    }

    public Long getId_shelve() {
        return id_shelve;
    }

//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }


    public void setId_shelve(Long id_shelve) {
        this.id_shelve = id_shelve;
    }

    public String getDescription_shelve() {
        return description_shelve;
    }

    public void setDescription_shelve(String description_shelve) {
        this.description_shelve = description_shelve;
    }

    public Warehouse getWar_id() {
        return war_id;
    }

    public void setWar_id(Warehouse war_id) {
        this.war_id = war_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
