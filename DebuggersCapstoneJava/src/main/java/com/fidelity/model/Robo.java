package com.fidelity.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fidelity.model.Preferences;

public class Robo {
	
//	private Collection<Instrument> HTrades;
//	private Collection<Instrument> LTrades;
//	private Collection<Instrument> MTrades;
//	private Collection<Instrument> NTrades;
	private String investmentPurpose, riskTolerance, incomeCategory, lengthOfInvestment;
	
	Collection<Instrument> HTrades = new ArrayList<>();

    // Create some Instrument objects
    Instrument high1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK","Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument high2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK","Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument high3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK","Google", 1000.0, 1.0);

    
//    HTrades.add(high1);
//    HTrades.add(high2);
    
	Collection<Instrument> LTrades = new ArrayList<>();


    Instrument low1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK",
            "Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument low2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument low3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Google", 1000.0, 1.0);

  
//    LTrades.add(low1);
//    LTrades.add(low2);
//    
	Collection<Instrument> MTrades = new ArrayList<>();


    Instrument medium1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK",
            "Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument medium2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument medium3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Google", 1000.0, 1.0);

  
//    MTrades.add(medium1);
//    MTrades.add(medium2);
    
    
	Collection<Instrument> NTrades = new ArrayList<>();


    Instrument normal1 = new Instrument("Q123", "CUSIP", "02079K107", "STOCK",
            "Alphabet Inc. Class C Capital Stock", 1000.0, 1.0);
    Instrument normal2 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Tesla, Inc. Common Stock", 1000.0, 1.0);
    Instrument normal3 = new Instrument("Q456", "CUSIP", "88160R101", "STOCK",
            "Google", 1000.0, 1.0);

  
//    NTrades.add(normal1);
//    NTrades.add(normal2);
//	

	
//	public Robo() {
////		Preferences preference=new Preferences("Education","LOW","100000-200000","4");
////		riskTolerance=preference.getRiskTolerance();
////		if(riskTolerance==null) {
////			throw new IllegalArgumentException("Risk Tolerance cannot be null");
////		}
//	}
	
	public Collection<Instrument> adviceTrades(String rTolerance) {
		HTrades.add(high1);
		HTrades.add(high2);
		HTrades.add(high3);
		LTrades.add(low1);
		LTrades.add(low2);
		LTrades.add(low3);
		NTrades.add(normal1);
		NTrades.add(normal2);
		NTrades.add(normal3);
		MTrades.add(medium1);
		MTrades.add(medium2);
		MTrades.add(medium3);
		switch(rTolerance) {
			case("HIGH"):
				return HTrades;
			case("LOW"):
				return LTrades;
			case("MEDIUM"):
				return MTrades;
			default:
				return NTrades;
		}
	}
	
	
	
	

}
