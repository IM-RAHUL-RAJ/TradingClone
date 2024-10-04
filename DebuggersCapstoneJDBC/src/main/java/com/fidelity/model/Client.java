package com.fidelity.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Client extends Person {
//	private ClientValidator cValidator;
//	private Set<Client>clients=new HashSet<>();
	
	double cashBalance;
	public Client(String email, String username, LocalDate dateOfBirth, String country) {
		super(email, username, dateOfBirth, country);
		
//		
	}
	
//	public Client(String firstName, String lastName, String emailId, String username, String country, LocalDate dateOfBirth, String panCardIdentification, String password, long phoneNumber) {
//		super(firstName, lastName, emailId, username, country, dateOfBirth, panCardIdentification,password,phoneNumber);
//	}
	
	public void setCashBalance(double amt) {
		cashBalance = amt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cashBalance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Double.doubleToLongBits(cashBalance) == Double.doubleToLongBits(other.cashBalance);
	}

	@Override
	public String toString() {
		return "Client [cashBalance=" + cashBalance + "]";
	}
	
	
	
	
}
