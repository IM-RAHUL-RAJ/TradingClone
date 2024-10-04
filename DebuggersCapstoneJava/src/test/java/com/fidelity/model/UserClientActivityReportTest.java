package com.fidelity.model;
import com.fidelity.model.Person;
import com.fidelity.model.Preferences;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserClientActivityReportTest {
	
	/*UserClientActivityReport(Person person, String name, long id, LocalDate dateOfBirth, String country,
	String postalCode, Preferences preference, String investmentPurpose, String riskTolerance,
	String incomeCategory, String lengthOfInvestment)*/
	
	private UserClientActivityReport user;
	
	
	Person p1=new Person("abs@gmail.com", 1,LocalDate.of(2017, 1, 13) ,"India","420011");
	Person p2=new Person("abf@gmail.com", 2,LocalDate.of(2018, 2, 2) ,"India","420781");
	Person p3=new Person("abg@gmail.com", 3,LocalDate.of(2019, 5, 3) ,"India","420531");
	
	Preferences pr1=new Preferences("College","Low","10,000-25,000","10");
	Preferences pr2=new Preferences("Retirement","Medium","25,000-35,000","15");
	Preferences pr3=new Preferences("Loan","High","35,000-45,000","20");

	@Test
	@DisplayName("Positive - User client report created successfully")
	void chkNotNullTest() {
		user= new UserClientActivityReport(p1,"Ananya",1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10");
		assertNotNull(user);
		
	}
	
	@Test
	@DisplayName("Positive - get client details")
	void chkEqualNameTest() {
		user= new UserClientActivityReport(p1,"Ananya",1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10");
		assertEquals("Ananya",user.name);
		
	}
	
	@Test
	@DisplayName("Negative - Set invalid PIN")
	void chkEqualPinTest() {
		user= new UserClientActivityReport(p1,"Ananya",1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10");
		assertNotEquals("420011111",user.postalCode);
		
	}
	@Test
	void chkEqualriskToleranceTest() {
		user= new UserClientActivityReport(p1,"Ananya",1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10");
		assertEquals("Low",user.riskTolerance);
		
	}
	@Test
	void chkEqualDateTest() {
		user= new UserClientActivityReport(p1,"Ananya",1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10");
		assertEquals(LocalDate.of(2017, 1, 13),user.dateOfBirth);
		
	}
	@Test
	void chkEqualCOuntryTest() {
		user= new UserClientActivityReport(p1,"Ananya",1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10");
		assertEquals("India",user.country);
		
	}
	
	@Test
	void testNameConstructionThrowsException() {
		assertThrows(IllegalArgumentException.class, () ->
		user = new UserClientActivityReport(p1,null,1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10"));
	}
	
	
	@Test
	void testIdConstructionThrowsException() {
		assertThrows(IllegalArgumentException.class, () ->
		user = new UserClientActivityReport(p1,null,0,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College","Low","10,000-25,000","10"));
	}
	
	
	@Test
	void testCountryConstructionThrowsException() {
		assertThrows(IllegalArgumentException.class, () ->
		user = new UserClientActivityReport(p1,null,1,LocalDate.of(2017, 1, 13) , null,"420011",pr1,"College","Low","10,000-25,000","10"));
	}
	
	
	@Test
	void testPostalCodeConstructionThrowsException() {
		assertThrows(IllegalArgumentException.class, () ->
		user = new UserClientActivityReport(p1,null,1,LocalDate.of(2017, 1, 13) , "India",null,pr1,"College","Low","10,000-25,000","10"));
	}
	
	
	@Test
	@DisplayName("Negative - Illegal Argument in user client report")
	void testRiskToleranceConstructionThrowsException() {
		assertThrows(IllegalArgumentException.class, () ->
		user = new UserClientActivityReport(p1,null,1,LocalDate.of(2017, 1, 13) , "India","420011",pr1,"College",null,"10,000-25,000","10"));
	}
	
	
	

}
