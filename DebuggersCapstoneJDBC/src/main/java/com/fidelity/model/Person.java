package com.fidelity.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Person {
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String username;
	private String country;
	private LocalDate dateOfBirth;
	private String panCardIdentification;
	private String password;
	private long phoneNumber;
	private String postalCode;
	

	public Person(String email, String username, LocalDate dateOfBirth, String country)
	{
		if(username==null || username.length()==0) {
			throw new IllegalArgumentException("id not correct");
		}
		if(country==null || country.length()==0) {
			throw new NullPointerException("country value can't be null");
		}
		this.username=username;
		this.emailId=email;
		this.dateOfBirth=dateOfBirth;
		this.country=country;
			
	}


	public Person(String firstName2, String lastName2, String emailId2, String username2, String country2,
			LocalDate dateOfBirth2, String panCardIdentification2, String password2, long phoneNumber2) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.emailId = emailId2;
		this.username = username2;
		this.country = country2;
		this.dateOfBirth = dateOfBirth2;
		this.panCardIdentification = panCardIdentification2;
		this.password = password2;
		this.phoneNumber = phoneNumber2;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPanCardIdentification() {
		return panCardIdentification;
	}


	public void setPanCardIdentification(String panCardIdentification) {
		this.panCardIdentification = panCardIdentification;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(country, dateOfBirth, emailId, firstName, lastName, panCardIdentification, password,
				phoneNumber, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(country, other.country) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(panCardIdentification, other.panCardIdentification)
				&& Objects.equals(password, other.password) && phoneNumber == other.phoneNumber
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", username="
				+ username + ", country=" + country + ", dateOfBirth=" + dateOfBirth + ", panCardIdentification="
				+ panCardIdentification + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
