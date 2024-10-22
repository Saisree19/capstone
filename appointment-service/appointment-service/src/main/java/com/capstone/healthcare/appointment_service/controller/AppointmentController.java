package com.capstone.healthcare.appointment_service.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.healthcare.appointment_service.bean.Appointment;
import com.capstone.healthcare.appointment_service.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<Appointment> createAppointment(
            @RequestParam Long patientId,
            @RequestParam String doctor,
            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
            @RequestParam  @DateTimeFormat(pattern = "HH:mm") LocalTime appointmentTime) {

        Appointment appointment = appointmentService.createAppointment(patientId, doctor, appointmentDate, appointmentTime);

        return ResponseEntity.ok(appointment);
    }
}
