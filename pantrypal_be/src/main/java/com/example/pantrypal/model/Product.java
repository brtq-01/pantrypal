package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @Min(0)
    private BigDecimal calories;

    @Min(0)
    private BigDecimal carbohydrates;

    @Min(0)
    private BigDecimal sugars;

    @Min(0)
    private BigDecimal fats;

    @Min(0)
    private BigDecimal proteins;

    @Min(0)
    private BigDecimal fibers;

    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductUser> productUsers;

    // Many-to-many relationship with DietaryLabel
    @ManyToMany
    @JoinTable(
            name = "product_dietary_label",  // The name of the join table
            joinColumns = @JoinColumn(name = "product_id"),  // Foreign key to Product
            inverseJoinColumns = @JoinColumn(name = "dietary_label_id")  // Foreign key to DietaryLabel
    )
    private Set<DietaryLabel> dietaryLabels = new HashSet<>();

    // Many-to-many relationship with Recipe
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

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public BigDecimal getFibers() {
        return fibers;
    }

    public void setFibers(BigDecimal fibers) {
        this.fibers = fibers;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public void setProteins(BigDecimal proteins) {
        this.proteins = proteins;
    }

    public BigDecimal getFats() {
        return fats;
    }

    public void setFats(BigDecimal fats) {
        this.fats = fats;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public BigDecimal getSugars() {
        return sugars;
    }

    public void setSugars(BigDecimal sugars) {
        this.sugars = sugars;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<DietaryLabel> getDietaryLabels() {
        return dietaryLabels;
    }

    public void setDietaryLabels(Set<DietaryLabel> dietaryLabels) {
        this.dietaryLabels = dietaryLabels;
    }

    public List<ProductUser> getProductUsers() {
        return productUsers;
    }

    public void setProductUsers(List<ProductUser> productUsers) {
        this.productUsers = productUsers;
    }
}
