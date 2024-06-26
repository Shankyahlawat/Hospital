package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.DoctorRepository1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private DoctorRepository1 doctorRepository1;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    public List<Doctor> findDoctorsByCityAndSpeciality(String city, String symptom){
    	List<Doctor>doctors= doctorRepository1.findDoctorsByCityAndSpeciality(city,symptom);
		return doctors;
    	
    	
    }
}
