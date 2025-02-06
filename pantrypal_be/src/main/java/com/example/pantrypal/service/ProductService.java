package com.example.pantrypal.service;

import com.example.pantrypal.model.DietaryLabel;
import com.example.pantrypal.model.Product;
import com.example.pantrypal.repository.DietaryLabelRepository;
import com.example.pantrypal.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DietaryLabelRepository dietaryLabelRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);

        // Update Product

        return productRepository.save(existingProduct);
    }

    public Product addDietaryLabels(Long id, List<String> dietaryLabels) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        List<DietaryLabel> labels = dietaryLabelRepository.findByNameIn(dietaryLabels);
        System.out.println(labels);

        product.getDietaryLabels().addAll(labels);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
