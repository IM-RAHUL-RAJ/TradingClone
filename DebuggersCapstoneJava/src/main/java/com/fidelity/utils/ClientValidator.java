package com.fidelity.utils;

import java.util.HashSet;
import java.util.Set;

import com.fidelity.model.Client;

public class ClientValidator {

//	public boolean isEmailValid(String email,Set<Client>clients) {   //valid email check 
//		if(email==null || email.isEmpty()) {
//			throw new IllegalArgumentException("email entered is null");
//		}
//		for(Client client:clients) {
//			if(client.getEmail().equals(email)) {
//				throw new IllegalArgumentException("email alrady registered with us! try again with new email id");
//			}
//		}
//		
//		return true;
//		
//	}
	
	private Set<Client> registeredClients=new HashSet<>();
	
	public ClientValidator() {
		;
	}
	public boolean isEmailValid(String email) {
		return email!=null && !email.isEmpty();
	}
	public boolean isClientRegistered(Client client) {
		return registeredClients.contains(client);
	}
	public boolean registerClient(Client client) {
		if(!isEmailValid(client.getEmail()) || isClientRegistered(client)) {
			return false;
		}
		if(client.getPostalCode()==null) {
			throw new NullPointerException("null value given to postal code");
		}
		registeredClients.add(client);
		return true;
	}
	public boolean removeClient(Client client) {
		if(isClientRegistered(client)) {
			registeredClients.remove(client);
			return true;
		}
		return false;
	}
}
