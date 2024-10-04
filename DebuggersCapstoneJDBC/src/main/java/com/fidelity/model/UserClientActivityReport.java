package com.fidelity.model;

import com.fidelity.model.Person;
import com.fidelity.model.Preferences;
import java.time.LocalDate;
import com.fidelity.model.Client; 


public class UserClientActivityReport {
	

	

	Person person;
	String name;
	long id;
	LocalDate dateOfBirth;
	String country;
	String postalCode;
	
	Preferences preference;
    String investmentPurpose, riskTolerance, incomeCategory, lengthOfInvestment;
//	public UserClientActivityReport(Person person, String name, long id, LocalDate dateOfBirth, String country,
//			String postalCode) {
//		super();
//		this.person = person;
//		this.name = name;
//		this.id = id;
//		this.dateOfBirth = dateOfBirth;
//		this.country = country;
//		this.postalCode = postalCode;
//	}
//	
	public UserClientActivityReport(Person person, String name, long id, LocalDate dateOfBirth, String country,
			String postalCode, Preferences preference, String investmentPurpose, String riskTolerance,
			String incomeCategory, String lengthOfInvestment) {
		super();
		LocalDate today= LocalDate.now();
		if(person==null)
			throw new IllegalArgumentException("Person cannot be null");
		if(name==null)
			throw new IllegalArgumentException("Name cannot be null");
		if(id<=0)
			throw new IllegalArgumentException("id needs to be greater than 0");
//		if(dateOfBirth>today)
//			throw new IllegalArgumentException("Person cannot be null");
		if(country==null)
			throw new IllegalArgumentException("Country cannot be null");
		if(postalCode==null)
			throw new IllegalArgumentException("Postal Code cannot be null");
		if(preference==null)
			throw new IllegalArgumentException("Preference cannot be null");
		if(riskTolerance==null)
			throw new IllegalArgumentException("Risk Tolerance cannot be null");
		if(investmentPurpose==null)
			throw new IllegalArgumentException("Investment Purpose cannot be null");
		if(lengthOfInvestment==null)
			throw new IllegalArgumentException("Length Of Investment cannot be null");
		
		
		
		this.person = person;
		this.name = name;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.postalCode = postalCode;
		this.preference = preference;
		this.investmentPurpose = investmentPurpose;
		this.riskTolerance = riskTolerance;
		this.incomeCategory = incomeCategory;
		this.lengthOfInvestment = lengthOfInvestment;
	}

    
	
}
	


//	
////	System.out.println("----------------------------Client report---------------------------------");
//	
//	Person person=new Person(abs@gmail.com, long id, LocalDate dateOfBirth, String country, String postalCode);
//	
//
//}
//
//Person p=new person()
//UserClientRP(p.name,p.email)