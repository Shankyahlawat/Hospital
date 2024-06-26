package com.example.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.exception.InvalidException;

public class CommonException {
	
	public void checkName(String name) {
		if(name.length() < 3)
			throw new InvalidException("name should be of 3 characters");
	}
	public void checkCity(String city) {
		if(city.length() > 20)
			throw new InvalidException("city should have max  20 characters");
	}
	
	public void checkEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);

	    if (!matcher.matches()) {
	        throw new InvalidException("Invalid email format");
	    }
	}
	
	public void checkPhoneNumber(String phoneNumber) {
	    // Regular expression for validating phone numbers with optional leading '+' and at least 10 digits
	    String phoneRegex = "^\\+?[0-9]{10,}$";

	    // Compile the regex pattern
	    Pattern pattern = Pattern.compile(phoneRegex);

	    // Use Matcher to check if the phone number matches the pattern
	    Matcher matcher = pattern.matcher(phoneNumber);

	    // Check if the phone number matches the pattern
	    if (!matcher.matches()) {
	        throw new InvalidException("Invalid phone number format");
	    }
	}



	

}
