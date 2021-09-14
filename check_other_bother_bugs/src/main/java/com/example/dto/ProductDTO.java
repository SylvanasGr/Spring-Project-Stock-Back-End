package com.example.dto;

import com.example.entity.Shelve;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private Long id_product;
    private String description_product;
    private int quantity_product;
    private Shelve shelve_product_id;


    public ProductDTO() {

    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getDescription_product() {
        return description_product;
    }

    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public Shelve getShelve_product_id() {
        return shelve_product_id;
    }

    public void setShelve_product_id(Shelve shelve_product_id) {
        this.shelve_product_id = shelve_product_id;
    }
}

