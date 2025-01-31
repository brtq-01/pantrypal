package com.example.pantrypal.service;

import com.example.pantrypal.model.Measurement;
import com.example.pantrypal.repository.MeasurementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Measurement getMeasurementById(Long id) {
        return measurementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Measurement not found"));
    }

    public Measurement createMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public Measurement updateMeasurement(Long id, Measurement updatedMeasurement) {
        Measurement existingMeasurement = getMeasurementById(id);

        // Update Measurement

        return measurementRepository.save(existingMeasurement);
    }

    public void deleteMeasurement(Long id) {
        measurementRepository.deleteById(id);
    }
}
