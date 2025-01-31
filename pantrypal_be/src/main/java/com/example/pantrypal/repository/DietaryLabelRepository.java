package com.example.pantrypal.repository;

import com.example.pantrypal.model.DietaryLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DietaryLabelRepository extends JpaRepository<DietaryLabel, Long> {
    Optional<DietaryLabel> findByName(String name);
}
