package com.capstone.healthcare.patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.healthcare.patient_service.bean.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}
