package com.example.dto;

public class StockRecoveryDTO {

    private Long id_product;
    private String date;
    private int quantity_product;
    private String action_description;
    private long id_action;

    public StockRecoveryDTO() {

    }

    public StockRecoveryDTO(Long id_product, String date, int quantity_product, String action_description, long id_action) {
        this.id_product = id_product;
        this.date = date;
        this.quantity_product = quantity_product;
        this.action_description = action_description;
        this.id_action = id_action;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public String getAction_description() {
        return action_description;
    }

    public void setAction_description(String action_description) {
        this.action_description = action_description;
    }

    public long getId_action() {
        return id_action;
    }

    public void setId_action(long id_action) {
        this.id_action = id_action;
    }
}
