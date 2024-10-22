package com.capstone.healthcare.appointment_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.healthcare.appointment_service.dto.PatientDTO;

@FeignClient(name = "patient-service")
public interface PatientServiceClient {

    @GetMapping("/patient/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);
}
