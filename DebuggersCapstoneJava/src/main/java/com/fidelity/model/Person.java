package com.fidelity.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fidelity.utils.ClientValidator;

public class Person {
	
	private String email;
	private long id;
	private LocalDate dateOfBirth;
	private String country;
	private String postalCode;
	

	public Person(String email, long id, LocalDate dateOfBirth, String country, String postalCode)
	{
		if(id<=0) {
			throw new IllegalArgumentException("id not correct");
		}
		if(country==null) {
			throw new NullPointerException("country value can't be null");
		}
		if(postalCode==null) {
			throw new NullPointerException("postal code can't be null");
		}
		this.email=email;
		this.id=id;
		this.dateOfBirth=dateOfBirth;
		this.country=country;
		this.postalCode=postalCode;
			
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	

}
