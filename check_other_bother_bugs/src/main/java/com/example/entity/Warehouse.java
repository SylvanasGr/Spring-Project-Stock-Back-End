package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="warehouse")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_warehouse")
    private Long id_warehouse;

    @Column(name="description_warehouse")
    private String description_warehouse;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "war_id")
    @JsonBackReference
    private List<Shelve> shelves = new ArrayList<>();

//    @OneToMany(mappedBy = "war_id")
//    private List<Management> managements_warehouse = new ArrayList<>();

    public Warehouse() {
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

    public List<Shelve> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelve> shelves) {
        this.shelves = shelves;
    }

//    public List<Management> getManagements_warehouse() {
//        return managements_warehouse;
//    }
//
//    public void setManagements_warehouse(List<Management> managements_warehouse) {
//        this.managements_warehouse = managements_warehouse;
//    }
}