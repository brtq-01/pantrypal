package com.example.pantrypal.repository;

import com.example.pantrypal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
