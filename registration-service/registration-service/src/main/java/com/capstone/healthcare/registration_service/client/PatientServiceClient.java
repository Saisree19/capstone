package com.capstone.healthcare.registration_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.healthcare.registration_service.bean.Patient;
import com.capstone.healthcare.registration_service.dto.PatientDTO;


@FeignClient(name = "patient-service") // Use the service name registered in Eureka
public interface PatientServiceClient {

    @GetMapping("/patient/{id}") // Define the endpoint to call
    Patient getPatientDetails(@PathVariable("id") Long id);
    
    @PostMapping("/patient/createPatient") // Define the endpoint to call
    Patient createPatient(@RequestBody Patient patient);
}
