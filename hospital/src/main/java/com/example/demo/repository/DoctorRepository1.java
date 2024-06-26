package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.InvalidException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DoctorRepository1 {
	
	 @PersistenceContext
	    private EntityManager entityManager;
	
	


	public List<Doctor> findDoctorsByCityAndSpeciality(String city, String symptom) {
		// Create a map to store specialties and their corresponding symptoms
        Map<String, List<String>> specialitySymptomMap = new HashMap<>();
        List<String> speciality = new ArrayList<String>();
        List<Doctor> abc1 = null;

        // Populate the map with specialties and symptoms
        List<String> orthopaedicSymptoms = new ArrayList<>();
        orthopaedicSymptoms.add("Arthritis");
        orthopaedicSymptoms.add("Back Pain");
        orthopaedicSymptoms.add("Tissue injuries");
        specialitySymptomMap.put("Orthopaedic", orthopaedicSymptoms);

        List<String> gynecologySymptoms = new ArrayList<>();
        gynecologySymptoms.add("Dysmenorrhea");
        specialitySymptomMap.put("Gynecology", gynecologySymptoms);

        List<String> dermatologySymptoms = new ArrayList<>();
        dermatologySymptoms.add("Skin infection");
        dermatologySymptoms.add("Skin burn");
        specialitySymptomMap.put("Dermatology", dermatologySymptoms);
        
		List<Doctor> abc = entityManager.createQuery(
                "SELECT d FROM Doctor d WHERE d.city = :city", Doctor.class)
                .setParameter("city", city)
                .getResultList();
		if(abc == null || abc.size() < 1)
			throw new InvalidException("We are still waiting to expand to your location");
		for (Entry<String, List<String>> value : specialitySymptomMap.entrySet()) {
			String spe = value.getKey();
			List<String> val = value.getValue();
			if(val.contains(symptom))
				speciality.add(spe);
		}
		
			abc1 = new ArrayList<Doctor>();
			for (Doctor doctor : abc) {
				if(speciality.contains(doctor.getSpeciality()))
					abc1.add(doctor);
			}
					
		if(abc1 == null  || abc1.size() < 1)
			throw new InvalidException("There isn’t any doctor present at your location for your symptom");
		
		return abc1;
	}
	
	
	}

