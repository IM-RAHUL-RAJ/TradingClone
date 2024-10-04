package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {
	@Test
	@DisplayName("Positive - Valid User")
	public void testClientConstructor() {
		Client client=new Client("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
		assertEquals("John@gmail.com", client.getEmail());
	}
	
	
	//negative test
	@Test
	@DisplayName("Negative - Invalid Test Case")
	public void testClientConstructor2() {
		assertThrows(NullPointerException.class, ()->{
			Person p4=new Person("John@gmail.com",1,LocalDate.of(2000, 5, 16),null,"826002");
		});
		
	}
}
