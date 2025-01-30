package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unit; // e.g. g or ml

    @OneToMany(mappedBy = "measurement")
    private List<Product> products;

    public Measurement() {}

    @NotBlank(message = "Unit is required")
    public Measurement(String unit) {
        this.unit = unit;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
