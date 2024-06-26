package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.InvalidException;
import com.example.demo.service.DoctorService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    CommonException commonException = new CommonException();

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
    	List<String> cities = Arrays.asList("Delhi", "Noida", "Faridabad");
    	List<String> specialities = Arrays.asList("Orthopaedic", "Gynecology", "Dermatology", "ENT");
    	CommonException commonException = new CommonException();
		commonException.checkName(doctor.getName());
		commonException.checkCity(doctor.getCity());
		commonException.checkEmail(doctor.getEmail());
		commonException.checkPhoneNumber(doctor.getPhoneNumber());
    	if(doctor.getId() == null) {
    	if (!cities.contains(doctor.getCity())) {
    		throw new InvalidException("City not allowed: " + doctor.getCity());
    	}
    	if(!specialities.contains(doctor.getSpeciality())) {
    		throw new InvalidException("Speciality not allowed: " + doctor.getSpeciality());
    	} 
    	}
    	if(doctor.getId() != null && StringUtils.isNotBlank(doctor.getId().toString())){
    		doctorService.deleteDoctor(doctor.getId());
    	}
    	else {
        return doctorService.saveDoctor(doctor);
    	}
		return doctor;
    }
}