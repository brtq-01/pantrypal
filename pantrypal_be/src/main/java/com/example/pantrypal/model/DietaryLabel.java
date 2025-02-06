package com.example.pantrypal.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DietaryLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "Name is required")
    private String name;

    // Many-to-many relationship with Product
    @Setter
    @ManyToMany(mappedBy = "dietaryLabels")  // The "mappedBy" refers to the field in Product
    private Set<Product> products = new HashSet<>();

    public DietaryLabel() {}
    public DietaryLabel(String name) {
        this.name = name;
    }
}
