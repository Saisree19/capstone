package com.capstone.healthcare.patient_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.healthcare.patient_service.bean.Patient;
import com.capstone.healthcare.patient_service.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Create a new patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient); // Save the patient to the database
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null); // Return the patient if found, or null
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll(); // Retrieve all patients
    }
}
