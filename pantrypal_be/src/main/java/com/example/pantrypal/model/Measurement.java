package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Getter
@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String unit; // e.g. g or ml

    @Setter
    @OneToMany(mappedBy = "measurement")
    private List<Product> products;

    public Measurement() {}

    @NotBlank(message = "Unit is required")
    public Measurement(String unit) {
        this.unit = unit;
    }
}
