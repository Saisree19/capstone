package com.capstone.healthcare.registration_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capstone.healthcare.registration_service.bean.Patient;
import com.capstone.healthcare.registration_service.client.PatientServiceClient;
import com.capstone.healthcare.registration_service.dto.PatientDTO;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    
    @Autowired
    private PatientServiceClient patientServiceClient; // Injecting the Feign client


    private Map<String, PatientDTO> registeredPatients = new HashMap<>();

    // Register a new patient
    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody PatientDTO patientDTO) {
        
        String patientKey = patientDTO.getName() + patientDTO.getDateOfBirth();
        if (registeredPatients.containsKey(patientKey)) {
            return ResponseEntity.badRequest().body("Duplicate entry: Patient already registered.");
        }

        Patient patient = new Patient(patientDTO.getName(), patientDTO.getDateOfBirth(), patientDTO.getInsurer());
        
        Patient createdPatient = patientServiceClient.createPatient(patient);
        
        PatientDTO createdPatientDTO = new PatientDTO(createdPatient);

        registeredPatients.put(patientKey, createdPatientDTO);

        return ResponseEntity.status(201).body("Patient registered successfully with ID: " + createdPatient.getId());
    }
}
