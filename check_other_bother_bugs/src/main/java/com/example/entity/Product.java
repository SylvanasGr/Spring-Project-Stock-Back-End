package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "description_product")
    private String description_product;

    @Column(name = "quantity_product")
    private int quantity_product;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name ="shelve_product_id", referencedColumnName = "id_shelve")
    @JsonIgnore
    private Shelve shelve_product_id;
//
//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product_id")
//    private List<Management> management_product = new ArrayList<>();


    public Product() {
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

//    public List<Management> getManagement_product() {
//        return management_product;
//    }
//
//    public void setManagement_product(List<Management> management_product) {
//        this.management_product = management_product;
//    }
}
