package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_management")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_action")
    private Long id_action;

    @Column(name = "action_description")
    private String action_description;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "war_id", referencedColumnName = "id_warehouse")
    @JsonIgnore
    private Warehouse war_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id_product")
    @JsonIgnore
    private Product product_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelve_id", referencedColumnName = "id_shelve")
    @JsonIgnore
    private Shelve shelve_id;

    public Management() {

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
