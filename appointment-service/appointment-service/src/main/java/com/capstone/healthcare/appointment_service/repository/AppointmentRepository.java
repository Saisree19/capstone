package com.capstone.healthcare.appointment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.healthcare.appointment_service.bean.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
}
