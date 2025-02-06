package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

@Getter
@Entity
public class ProductUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Setter
    @Column(name = "expiry_date")
    @NotBlank(message = "Expiry Date is required")
    private LocalDate expiryDate;

    @Setter
    @Min(0)
    @NotBlank(message = "Quantity is required")
    private int quantity;
}
