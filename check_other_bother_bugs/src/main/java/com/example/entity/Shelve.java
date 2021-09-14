package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shelve")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shelve {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shelve")
    private Long id_shelve;

    @Column(name = "description_shelve")
    private String description_shelve;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "war_id", referencedColumnName = "id_warehouse")
    private Warehouse war_id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product_id")
    private List<Management> management_shelve = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "shelve_product_id")
    private List<Product> products = new ArrayList<>();

    public Shelve() {

    }

    public Long getId_shelve() {
        return id_shelve;
    }

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

    public List<Management> getManagement_shelve() {
        return management_shelve;
    }

    public void setManagement_shelve(List<Management> management_shelve) {
        this.management_shelve = management_shelve;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
