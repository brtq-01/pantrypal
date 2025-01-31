package com.example.pantrypal.repository;

import com.example.pantrypal.model.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductUserRepository extends JpaRepository<ProductUser, Long> {
}
