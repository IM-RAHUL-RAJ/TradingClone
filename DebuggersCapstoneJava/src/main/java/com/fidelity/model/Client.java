package com.fidelity.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fidelity.utils.ClientValidator;

public class Client extends Person {
//	private ClientValidator cValidator;
//	private Set<Client>clients=new HashSet<>();
	
	double cashBalance;
	public Client(String email, long id, LocalDate dateOfBirth, String country, String postalCode) {
		super(email, id, dateOfBirth, country, postalCode);
		
//		
	}
	
	public void setCashBalance(double amt) {
		cashBalance = amt;
	}
	
	
}
