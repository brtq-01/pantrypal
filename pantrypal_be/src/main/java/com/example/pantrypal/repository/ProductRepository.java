package com.example.pantrypal.repository;

import com.example.pantrypal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByCalorieDesc();
    List<Product> findByDietaryLabelId(Long dietaryLabelId);
    Optional<Product> findByName(String name);
}
