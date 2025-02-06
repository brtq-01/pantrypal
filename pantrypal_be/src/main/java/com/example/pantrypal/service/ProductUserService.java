package com.example.pantrypal.service;

import com.example.pantrypal.model.Product;
import com.example.pantrypal.model.ProductUser;
import com.example.pantrypal.model.User;
import com.example.pantrypal.repository.ProductRepository;
import com.example.pantrypal.repository.ProductUserRepository;
import com.example.pantrypal.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductUserService {

    @Autowired
    private ProductUserRepository productUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public ProductUser addProductToUser(Long userId, Long productId, LocalDate expiryDate, int quantity) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        ProductUser productUser = new ProductUser();
        productUser.setUser(user);
        productUser.setProduct(product);
        productUser.setExpiryDate(expiryDate);
        productUser.setQuantity(quantity);

        return productUserRepository.save(productUser);
    }
}
