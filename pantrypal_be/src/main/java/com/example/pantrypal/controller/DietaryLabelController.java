package com.example.pantrypal.controller;


import com.example.pantrypal.model.DietaryLabel;
import com.example.pantrypal.service.DietaryLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dietarylabels")
public class DietaryLabelController {

    @Autowired
    private DietaryLabelService dietaryLabelService;

    @GetMapping
    public List<DietaryLabel> getAllDietaryLabels() {
        return dietaryLabelService.getAllDietaryLabels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietaryLabel> getDietaryLabelById(@PathVariable Long id){
        return ResponseEntity.ok(dietaryLabelService.getDietaryLabelById(id));
    }

    @PostMapping
    public ResponseEntity<DietaryLabel> createDietaryLabel(@RequestBody DietaryLabel dietaryLabel) {
        DietaryLabel savedDietaryLabel = dietaryLabelService.createDietaryLabel(dietaryLabel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDietaryLabel);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DietaryLabel> updateDietaryLabel(@PathVariable Long id, @RequestBody DietaryLabel dietaryLabel) {
        return ResponseEntity.ok(dietaryLabelService.updateDietaryLabel(id, dietaryLabel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDietaryLabel(@PathVariable Long id) {
        dietaryLabelService.deleteDietaryLabel(id);
        return ResponseEntity.noContent().build();
    }

}
