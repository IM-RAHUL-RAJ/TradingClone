package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fidelity.utils.ClientValidator;

public class ClientValidatorTest {
	ClientValidator validator;
	
	@BeforeEach
	public void setUp() {
		validator=new ClientValidator();
	}
	
	
	@Test
	@DisplayName("Positive - valid Email")
	public void testIsEmailValid() {
		assertTrue(validator.isEmailValid("rahul@gmail.com"));
		assertFalse(validator.isEmailValid(null));
		
	}
	@Test
	@DisplayName("Positive - valid Client Registration")
	public void testRegisterFunction() {
		Client c1=new Client("Bosh@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
		assertTrue(validator.registerClient(c1));
		Client c2=new Client("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
		assertTrue(validator.registerClient(c2));
		Client c3=new Client("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
		assertTrue(validator.registerClient(c3));
	}
	@Test
	@DisplayName("Positive - New valid client created")
	public void testRegisterFunction2() {
		Client c1=new Client("Bosh@gmail.com",1,LocalDate.of(2000, 5, 16),"India","82600");
		
		
	}
	@Test
	@DisplayName("Positive - valid Client remove")
	public void testRemoveClient() {
		Client client1=new Client("Bosh@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
		validator.registerClient(client1);
		assertTrue(validator.removeClient(client1));
		assertFalse(validator.removeClient(client1));  //client already removed
	}
}
