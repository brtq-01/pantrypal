package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "Name is required")
    private String name;

    @Setter
    @NotBlank(message = "Country is required")
    private String country;

    // Many-to-many relationship with Product
    @Setter
    @ManyToMany(mappedBy = "recipes")  // The "mappedBy" refers to the field in Product
    private Set<Product> products = new HashSet<>();

    public Recipe() {}

    public Recipe(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
