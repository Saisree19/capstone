package com.capstone.healthcare.appointment_service.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.healthcare.appointment_service.bean.Appointment;
import com.capstone.healthcare.appointment_service.bean.Patient;
import com.capstone.healthcare.appointment_service.client.PatientServiceClient;
import com.capstone.healthcare.appointment_service.dto.PatientDTO;
import com.capstone.healthcare.appointment_service.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientServiceClient patientServiceClient;

	// Method to create an appointment
	public Appointment createAppointment(Long patientId, String doctor, LocalDate appointmentDate,
			LocalTime appointmentTime) {

		// Verify if the patient is registered by calling the PatientService via Feign
		// Client
		PatientDTO patientDTO = patientServiceClient.getPatientById(patientId);

		if (patientDTO == null) {
			throw new RuntimeException("Patient not found: Cannot create an appointment for an unregistered patient.");
		}
		Patient patient = new Patient(patientDTO.getName(), patientDTO.getDateOfBirth(), patientDTO.getInsurer());
		patient.setId(patientDTO.getId());

		// Create new Appointment entity
		Appointment appointment = new Appointment(patient, doctor, appointmentDate, appointmentTime);

		// Save the appointment to the database
		return appointmentRepository.save(appointment);
	}
}
