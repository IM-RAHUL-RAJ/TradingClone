package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fidelity.utils.TradeService;

public class TradeServiceTest {
	TradeService ts;
	
	@BeforeEach
	public void setup() {
		ts = new TradeService();
	}
	
	@Test
	@DisplayName("Positive - FMTS returns a list of instruments")
	public void get_instruments_valid() {
		
		Instrument testInstrument = new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100);
		FMTS fmts = new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",testInstrument);
		assertEquals(fmts.getInstrument(), testInstrument);
	}
	
	@Test
	@DisplayName("Negative - FMTS returns a null list or throws an exception")
	public void get_instruments_invalid() {
		
		Instrument testInstrument = null;
		
		assertThrows(NullPointerException.class, () -> {
			FMTS fmts = new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",testInstrument);
		});
		
	}
	
	@Test
	@DisplayName("Negative - client cash balance less than buy price")
	public void buy_invalid() {
		Instrument testInstrument = new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100);
		FMTS fmts = new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",testInstrument);
		assertThrows(IllegalArgumentException.class, () -> {
			ts.buyTrade(fmts, 10, 100);
		});	
	}
	
	@Test
	@DisplayName("Positive - client successfully completes the buy trade")
	public void buy_trade_valid() {
		
		Instrument testInstrument = new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100);
		FMTS fmts = new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",testInstrument);
		
		ts.buyTrade(fmts, 10, 10000);
		List<Order> expectedTradeHist = new ArrayList<>();
		expectedTradeHist.add(new Order("T67880", 10, 104.75, "BUY", "ABC", "1"));
		assertEquals(expectedTradeHist.get(0).getDirection(), ts.getTradeHistory().get(0).getDirection());
	}
	
	@Test
	@DisplayName("Positive - client successfully completes the sell trade")
	public void sell_trade_valid() {
		
		Instrument testInstrument = new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100);
		FMTS fmts = new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",testInstrument);
		
		ts.sellTrade(fmts, 10, 10000);
		List<Order> expectedTradeHist = new ArrayList<>();
		expectedTradeHist.add(new Order("T67880", 10, 104.75, "SELL", "ABC", "1"));
		assertEquals(expectedTradeHist.get(0).getDirection(), ts.getTradeHistory().get(0).getDirection());
	}
	@Test
	@DisplayName("Negative - 0 buyQuantity sent to buy method")
	public void invalid_buy_0_quantity() {
		Instrument testInstrument = new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100);
		FMTS fmts = new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",testInstrument);
		assertThrows(IllegalArgumentException.class, () -> {
			ts.buyTrade(fmts, 0, 1000);
		});
	}
	
	
}
