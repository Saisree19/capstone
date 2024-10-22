package com.capstone.healthcare.appointment_service.dto;

import java.time.LocalDate;

import com.capstone.healthcare.appointment_service.bean.Patient;


public class PatientDTO {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String insurer;

    // Constructors
    public PatientDTO() {}

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.dateOfBirth = patient.getDateOfBirth();
        this.insurer = patient.getInsurer();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

   
}
