package com.example.dto;

import com.example.entity.Product;
import com.example.entity.Shelve;
import com.example.entity.Warehouse;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagementDTO {

    private Long id_action;
    private String action_description;
    private String supplier;
    private String recipient;
    private String date;
    private Warehouse war_id;
    private Product product_id;
    private Shelve shelve_id;

    public ManagementDTO() {
    }
    public Long getId_action() {
        return id_action;
    }

    public void setId_action(Long id_action) {
        this.id_action = id_action;
    }

    public String getAction_description() {
        return action_description;
    }

    public void setAction_description(String action_description) {
        this.action_description = action_description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Warehouse getWar_id() {
        return war_id;
    }

    public void setWar_id(Warehouse war_id) {
        this.war_id = war_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Shelve getShelve_id() {
        return shelve_id;
    }

    public void setShelve_id(Shelve shelve_id) {
        this.shelve_id = shelve_id;
    }
}




