package com.fidelity.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.fidelity.utils.PortfolioService;
import static org.junit.jupiter.api.Assertions.*;

class PortfolioServiceTest {

	public PortfolioService portfolioService;
	  Map<String, List<Portfolio>>portfolioData;
	  Map<String, List<Trade>> tradeHistoryData;
	  List<Order> listOfPortfolio;
	  List<Order> listOfTradeHistory;

	  @BeforeEach
	  void setUp() {
		  portfolioService =new PortfolioService();
//			 portfolioData = new HashMap<>();
//			 tradeHistoryData = new HashMap<>();
			 listOfTradeHistory = new ArrayList<>();
			 listOfPortfolio = new ArrayList<>();
//			 listOfTradeHistory.add(new Trade(100, 10, "Bond", "alpha", "tech", "test", 0));
			 listOfPortfolio.add(new Order("ABC", 2, 1000, "BUY", "ABC", "1"));
			 listOfPortfolio.add(new Order("BCD", 3, 3000, "SELL", "EGF", "2"));
			 listOfPortfolio.add(new Order("CDE", 4, 4000, "BUY", "XYZ", "3"));
			 
			 listOfTradeHistory.add(new Order("ABC", 2, 1000, "BUY", "ABC", "1"));
			 listOfTradeHistory.add(new Order("BCD", 3, 3000, "SELL", "EGF", "2"));
			 listOfTradeHistory.add(new Order("CDE", 4, 4000, "BUY", "XYZ", "3"));
			 //listOfPortfolio.add(new Portfolio("Bond", "alpha", "Technology", LocalDate.now(), "Google Inc. bond",100,20,1));
//			 portfolioData.put("test1@gmail.com", listOfPortfolio);
//			 tradeHistoryData.put("history1@gmail.com", listOfTradeHistory);
			 //portfolioService = new PortfolioService(portfolioData,tradeHistoryData);
	  }

	  @Test
	  @DisplayName("Positive - successfully retrieve all portfolios")
	  void testforGetPortolioData() {
		  portfolioService.setPortfolio(listOfPortfolio.get(0));
		  portfolioService.setPortfolio(listOfPortfolio.get(1));
		  portfolioService.setPortfolio(listOfPortfolio.get(2));
		  assertEquals(listOfPortfolio, portfolioService.getPortfolio());
	  }
	  
	  
	  @Test
	  @DisplayName("Positive - successfully retrieve all Trade History")
	  void testforGetTradeHistory() {
		  portfolioService.setTradeHistory(listOfTradeHistory.get(0));
		  portfolioService.setTradeHistory(listOfTradeHistory.get(1));
		  portfolioService.setTradeHistory(listOfTradeHistory.get(2));
		  assertEquals(listOfTradeHistory, portfolioService.getTradeHistory());
	  }
	  
	  @Test
	  @DisplayName("Negative - Client Portfolio is null")
	  void testforNullPortfolio() {
		  assertEquals(0, portfolioService.getPortfolio().size());
	  }
//	  @Test
//	  void testforGetHistoryData() {
//		  List<Trade> listOfTrade= portfolioService.getTradeHistoryData("history1@gmail.com");
//		  assertEquals(tradeHistoryData.get("history1@gmail.com"),listOfTrade );
//
//	  }
//
//
//	    @Test
//	    void testForInvalidClient() {
//	        List<Portfolio> listOfPortfolio = portfolioService.getPortfolio("invalidmail@gmail.com");
//	        assertNull(listOfPortfolio, "Expected null for an invalid client");
//	    }
//
//	    @Test
//	    void testForInvalidClientForTrade() {
//	        List<Trade> listOfTrade = portfolioService.getTradeHistoryData("invalidmail@gmail.com");
//	        assertNull(listOfTrade, "Expected null for an invalid client");
//	    }
//
//
//	  @Test
//	    void testForClientWithoutPortfolio() {
//	        List<Portfolio> listOfPortfolio = portfolioService.getPortfolio("nonexistent@gmail.com");
//	        assertNull(listOfPortfolio, "Expected null for a client with no portfolio");
//	    }
//
//	  @Test
//	    void testForClientWithPortfolio() {
//	        List<Portfolio> expectedPortfolio = portfolioData.get("test1@gmail.com");
//	        List<Portfolio> actualPortfolio = portfolioService.getPortfolio("test1@gmail.com");
//	        assertNotNull(actualPortfolio, "Expected non-null data for a client with a portfolio");
//	        assertEquals(expectedPortfolio, actualPortfolio, "Expected portfolio data to match");
//	    }
//
//	  @Test
//	    void testForClientWithoutTrade() {
//	        List<Trade> listofTrade = portfolioService.getTradeHistoryData("nonexistent@gmail.com");
//	        assertNull(listofTrade, "Expected null for a client with no trade history");
//	    }
//
//	  @Test
//	    void testForClientWithTrade() {
//	        List<Trade> expectedTrade = tradeHistoryData.get("history1@gmail.com");
//	        List<Trade> actualTrade = portfolioService.getTradeHistoryData("history1@gmail.com");
//	        assertNotNull(actualTrade, "Expected non-null data for a client with a portfolio");
//	        assertEquals(expectedTrade, actualTrade, "Expected portfolio data to match");
//	    }
//
//
//
// 
//
//	  @Test
//	  void testForClientTradeHistoryLessThan100() {
//	      List<Trade> listOfTradeHistory = new ArrayList<>();
//	      for (int i = 0; i < 80; i++) {
//	          listOfTradeHistory.add(new Trade(100, 10, "Bond", "alpha", "tech", "test", 0));
//	      }
//	      tradeHistoryData.put("history1@gmail.com", listOfTradeHistory);
//	      List<Trade> listOfTrade = portfolioService.getClientTradeHistorySorted("history1@gmail.com");
//	      assertNotNull(listOfTrade, "Expected non-null trade history data");
//	      assertTrue(listOfTrade.size() < 100, "Expected trade history count to be less than 100");
//	  }
//
// 
//
//	  @Test
//	  void testForClientTradeHistoryMoreThan100() {
//	      List<Trade> listOfTradeHistory = new ArrayList<>();
//	      for (int i = 0; i < 150; i++) {
//	          listOfTradeHistory.add(new Trade(100, 10, "Bond", "alpha", "tech", "test", 0));
//	      }
//	      tradeHistoryData.put("history1@gmail.com", listOfTradeHistory);
//	      List<Trade> listOfTrade = portfolioService.getClientTradeHistorySorted("history1@gmail.com");
//	      assertNotNull(listOfTrade, "Expected non-null trade history data");
//	      assertFalse(listOfTrade.size() > 100, "Expected trade history count to be more than 100");
//	  }
//
// 
//
//	  @Test
//	  void testForClientTradeHistoryExactly100() {
//	      List<Trade> listOfTradeHistory = new ArrayList<>();
//	      for (int i = 0; i < 100; i++) {
//	          listOfTradeHistory.add(new Trade(100, 10, "Bond", "alpha", "tech", "test", 0));
//	      }
//	      tradeHistoryData.put("history@gmail.com", listOfTradeHistory);
//	      List<Trade> listOfTrade = portfolioService.getClientTradeHistorySorted("history@gmail.com");
//	      assertNotNull(listOfTrade, "Expected non-null trade history data");
//	      assertEquals(100, listOfTrade.size(), "Expected trade history count to be exactly 100");
//	  }
}