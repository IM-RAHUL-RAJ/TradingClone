package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	@DisplayName("Positive - Person added successfully")
	public void testPersonConstructor() {
		Person person=new Person("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");

		assertEquals("John@gmail.com",person.getEmail());
	}
	
	@Test
	@DisplayName("Positive - Get postal code")
	public void testPersonConstructor2() {
		Person person=new Person("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");

		assertEquals("826001",person.getPostalCode());
	}
	//negative 
	@Test
	@DisplayName("Negative - Illegal argument passed in Person Constructor")
	public void testPersonConstructor3() {
		assertThrows(NullPointerException.class, ()->{
			Person p4=new Person("John@gmail.com",1,LocalDate.of(2000, 5, 16),null,"826002");
		});
		
	}
	
}
