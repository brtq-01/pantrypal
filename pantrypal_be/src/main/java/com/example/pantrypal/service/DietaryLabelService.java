package com.example.pantrypal.service;

import com.example.pantrypal.model.DietaryLabel;
import com.example.pantrypal.repository.DietaryLabelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietaryLabelService {

    @Autowired
    private DietaryLabelRepository dietaryLabelRepository;

    public List<DietaryLabel> getAllDietaryLabels() {
        return dietaryLabelRepository.findAll();
    }

    public DietaryLabel getDietaryLabelById(Long id) {
        return dietaryLabelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dietary Label not found"));
    }

    public DietaryLabel createDietaryLabel(DietaryLabel dietaryLabel) {
        return dietaryLabelRepository.save(dietaryLabel);
    }

    public DietaryLabel updateDietaryLabel(Long id, DietaryLabel updatedDietaryLabel) {
        DietaryLabel existingDietaryLabel = getDietaryLabelById(id);

       // Update Dietary Label

       return dietaryLabelRepository.save(existingDietaryLabel);
    }

    public void deleteDietaryLabel(Long id) {
        dietaryLabelRepository.deleteById(id);
    }
}
