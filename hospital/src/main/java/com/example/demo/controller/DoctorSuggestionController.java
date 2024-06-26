package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class DoctorSuggestionController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public List<Doctor> suggestDoctors(@RequestParam Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            throw new RuntimeException("Patient not found with ID: " + patientId);
        }

        // Get doctors based on patient's city and symptom
        List<Doctor> abc = doctorService.findDoctorsByCityAndSpeciality(patient.getCity(), patient.getSymptom());
        return abc;
    }
}
