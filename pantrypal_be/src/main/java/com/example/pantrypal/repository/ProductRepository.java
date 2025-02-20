package com.example.pantrypal.repository;

import com.example.pantrypal.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByCaloriesDesc();

    @Query("SELECT p FROM Product p JOIN p.dietaryLabels d WHERE d.name = :labelName")
    List<Product> findByDietaryLabel(@Param("labelName") String labelName);

    List<Product> findAll(Sort sort);

    Optional<Product> findByName(String name);

}
