package com.example.pantrypal.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "Product name is required")
    private String name;

    @Setter
    @Min(0)
    private BigDecimal calories;

    @Setter
    @Min(0)
    private BigDecimal carbohydrates;

    @Setter
    @Min(0)
    private BigDecimal sugars;

    @Setter
    @Min(0)
    private BigDecimal fats;

    @Setter
    @Min(0)
    private BigDecimal proteins;

    @Setter
    @Min(0)
    private BigDecimal fibers;

    @Setter
    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

    @Setter
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductUser> productUsers;

    // Many-to-many relationship with DietaryLabel
    @Setter
    @ManyToMany
    @JoinTable(
            name = "product_dietary_label",  // The name of the join table
            joinColumns = @JoinColumn(name = "product_id"),  // Foreign key to Product
            inverseJoinColumns = @JoinColumn(name = "dietary_label_id")  // Foreign key to DietaryLabel
    )
    private Set<DietaryLabel> dietaryLabels = new HashSet<>();

    // Many-to-many relationship with Recipe
    @Setter
    @ManyToMany
    @JoinTable(
            name = "product_recipe",  // The name of the join table
            joinColumns = @JoinColumn(name = "product_id"),  // Foreign key to Product
            inverseJoinColumns = @JoinColumn(name = "recipe_id")  // Foreign key to DietaryLabel
    )
    private Set<Recipe> recipes = new HashSet<>();

    public Product() {}
    public Product(Long id, String name, BigDecimal calories, BigDecimal carbohydrates, BigDecimal fats, BigDecimal sugars, BigDecimal proteins, BigDecimal fibers, Measurement measurement) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.sugars = sugars;
        this.proteins = proteins;
        this.fibers = fibers;
        this.measurement = measurement;
    }
}
