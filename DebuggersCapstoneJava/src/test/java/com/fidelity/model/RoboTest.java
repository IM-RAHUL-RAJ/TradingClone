package com.fidelity.model;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoboTest {
	
	
	Collection<Instrument> HTrades = new ArrayList<>();

    Instrument high1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK","Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument high2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK","Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument high3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK","Google", 1000.0, 1.0);

    

    
	Collection<Instrument> LTrades = new ArrayList<>();


    Instrument low1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK",
            "Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument low2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument low3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Google", 1000.0, 1.0);

  
    
	Collection<Instrument> MTrades = new ArrayList<>();


    Instrument medium1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK",
            "Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument medium2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument medium3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Google", 1000.0, 1.0);

  

    
    
	Collection<Instrument> NTrades = new ArrayList<>();


    Instrument normal1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK",
            "Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument normal2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument normal3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Google", 1000.0, 1.0);

  

	

	@Test
	@DisplayName("Positive-Robo Advisor advicing trades for risk category = HIGH")
	void testHighPositive() {
		HTrades.add(high1);
		HTrades.add(high2);
		HTrades.add(high3);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("HIGH");
		assertEquals(HTrades.size(),result.size());
	}
	@Test
	@DisplayName("Positive-Robo Advisor advicing trades for risk category = LOW")
	void testLowPositive() {
		LTrades.add(low1);
		LTrades.add(low2);
		LTrades.add(low3);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("LOW");
		assertEquals(LTrades.size(),result.size());
	}
	@Test
	@DisplayName("Positive-Robo Advisor advicing trades for risk category = MEDIUM")
	void testMediumPositive() {
		MTrades.add(medium1);
		MTrades.add(medium2);
		MTrades.add(medium3);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("MEDIUM");
		assertEquals(MTrades.size(),result.size());
	}
	@Test
	@DisplayName("Positive-Robo Advisor advicing trades for risk category = NORMAL")
	void testSizeNormalPositive() {
		NTrades.add(normal1);
		NTrades.add(normal2);
		NTrades.add(normal3);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("NORMAL");
		assertEquals(NTrades.size(),result.size());
	}
	
	
	@Test
	@DisplayName("Negative-Robo Advisor advicing trades for risk category = NORMAL")
	void testSizeNormalNegative() {
		NTrades.add(normal1);
		NTrades.add(normal2);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("NORMAL");
		assertNotEquals(NTrades.size(),result.size());
	}
	
	@Test
	@DisplayName("Negative-Robo Advisor advicing trades for risk category = HIGH")
	void testHighNegative() {
		HTrades.add(high1);
		HTrades.add(high2);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("HIGH");
		assertNotEquals(HTrades.size(),result.size());
	}
	@Test
	@DisplayName("Negative-Robo Advisor advicing trades for risk category = LOW")
	void testLowNegative() {
		LTrades.add(low1);
		LTrades.add(low2);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("LOW");
		assertNotEquals(LTrades.size(),result.size());
	}
	@Test
	@DisplayName("Negative-Robo Advisor advicing trades for risk category = MEDIUM")
	void testMediumNegative() {
		MTrades.add(medium1);
		MTrades.add(medium2);
		Robo roboObj=new Robo();
		Collection<Instrument> result=roboObj.adviceTrades("MEDIUM");
		assertNotEquals(MTrades.size(),result.size());
	}
	


}
