package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DietaryLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    // Many-to-many relationship with Product
    @ManyToMany(mappedBy = "dietaryLabels")  // The "mappedBy" refers to the field in Product
    private Set<Product> products = new HashSet<>();

    public DietaryLabel() {}
    public DietaryLabel(String name) {
        this.name = name;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
