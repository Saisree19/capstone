package com.capstone.healthcare.patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.healthcare.patient_service.bean.Patient;
import com.capstone.healthcare.patient_service.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	  	@Autowired
	    private PatientService patientService; // Service to handle patient-related logic

	  	@PostMapping("/createPatient")
	    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
	        Patient createdPatient = patientService.createPatient(patient);
	        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Patient> getPatientDetails(@PathVariable Long id) {
	        Patient patient = patientService.getPatientById(id);
	        if (patient != null) {
	            return new ResponseEntity<>(patient, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 if patient not found
	        }
	    }
	
	
	
}
