package com.capstone.healthcare.registration_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.healthcare.registration_service.bean.Patient;
import com.capstone.healthcare.registration_service.client.PatientServiceClient;

@Service
public class RegistrationService {

    @Autowired
    private PatientServiceClient patientServiceClient;

    public Patient getPatient(Long patientId) {
        return patientServiceClient.getPatientDetails(patientId); // Call patient service
    }
}
