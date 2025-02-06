package com.example.pantrypal.controller;

import com.example.pantrypal.model.DietaryLabel;
import com.example.pantrypal.model.Product;
import com.example.pantrypal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PostMapping("/addList")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        return ResponseEntity.ok(productService.saveAll(products));
    }

    @PostMapping("/{id}/add-dietary-labels")
    public ResponseEntity<Product> addDietaryLabels(@PathVariable Long id, @RequestBody List<String> dietaryLabels) {
        return ResponseEntity.ok(productService.addDietaryLabels(id, dietaryLabels));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
