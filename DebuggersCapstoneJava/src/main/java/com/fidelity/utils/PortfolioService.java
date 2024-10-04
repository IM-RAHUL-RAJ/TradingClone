package com.fidelity.utils;

import java.util.*;
import java.util.Map;

import com.fidelity.model.Direction;
import com.fidelity.model.FMTS;
import com.fidelity.model.Portfolio;
import com.fidelity.model.Trade;
import java.util.Collections;
import java.util.Comparator;
import com.fidelity.model.Order;
//import com.fidelity.model.Client;

//public class PortfolioService {
//	private Map<String, List<FMTS>> portfolioData ;
//	private Map<String, List<FMTS>> tradeHistoryData;
//	public PortfolioService(Map<String, List<FMTS>> portfolioData,Map<String, List<FMTS>> tradeHistoryData) {
//		this.portfolioData = portfolioData;
//		this.tradeHistoryData = tradeHistoryData;
//	}
//    public List<FMTS> getPortfolioData(String email) {	
//         return portfolioData.get(email);
//    }
//    public List<FMTS> getTradeHistoryData(String email) {
//        List<FMTS> tradeHistory = this.tradeHistoryData.get(email);
//        return tradeHistory;
//    }
//    public List<FMTS> getClientTradeHistorySorted(String email) {
//        List<FMTS> tradeHistory = tradeHistoryData.get(email);
//        if (tradeHistory == null) {
//            return Collections.emptyList(); 
//        }
//           //tradeHistory.sort(Comparator.comparingDouble(Trade::getCashValue).reversed());
//           if (tradeHistory.size() > 100) {
//            tradeHistory = tradeHistory.subList(0, 100);
//        }
//        return tradeHistory;
//    }
//    

//    
//    public void updatePortfolio(FMTS trade, String direction, int quantity) {
//    	
//    }
//}

public class PortfolioService {
	private Map<String, List<Order>> portfolioData;
	private Map<String, List<Order>> tradeHistoryData;

	private List<Order> portfolio;
	private List<Order> tradeHistory;

//	public PortfolioService(Map<String, List<Order>> portfolioData2,
//			Map<String, List<Order>> tradeHistoryData2) {
//		this.portfolioData = portfolioData2;
//		this.tradeHistoryData = tradeHistoryData2;
//	}
	public PortfolioService() {
		portfolio = new ArrayList<>();
		tradeHistory = new ArrayList<>();
	}

//	public List<Order> getPortfolio(String email) {
//		return portfolioData.get(email);
//	}
	
	public List<Order> getPortfolio(){
		return portfolio;
	}
	public void setPortfolio(Order portfolio) {
		this.portfolio.add(portfolio);
	}
	
	public void setTradeHistory(Order trade) {
		this.tradeHistory.add(trade);
	}
	
	public List<Order> getTradeHistory() {
		return tradeHistory;
	}
	public void updatePortfolio(FMTS trade, String direction, int quantity) {
		portfolio.add(new Order(trade.getInstrument().getInstrumentId(), 
				quantity, trade.getAskPrice(), direction, "ABC", "1"));
	}

	public List<Order> updateTradeHistory(FMTS trade, String direction, int quantity) {
		tradeHistory.add(new Order(trade.getInstrument().getInstrumentId(), 
				quantity, trade.getAskPrice(), direction, "ABC", "1"));
		return tradeHistory;
	}
	
//	public void addPortfolio(String email, Portfolio portfolio) {
//		if(portfolioData.containsKey(email)) {
//			int index = portfolioData.get(email).indexOf(portfolio);
//			if(index >= 0) {
//				Portfolio tempPortfolio = portfolioData.get(email).get(index);
//				tempPortfolio.setCurrentHoldings(portfolio.getCurrentHoldings() + tempPortfolio.getCurrentHoldings());
//			}
//			else {
//				portfolioData.get(email).add(portfolio);
//			}
//		}
//		else {
//			throw new IllegalStateException("Not Allowed, Register first");
//		}
//	}

//	public void sellPortfolio(String email, Portfolio portfolio, double quantity) {
//		if(portfolioData.containsKey(email)) {
//			int index = portfolioData.get(email).indexOf(portfolio);
//			Portfolio tempPortfolio = portfolioData.get(email).get(index);
//			if(tempPortfolio.getCurrentHoldings() == quantity) {
//				portfolioData.get(email).remove(index);
//			}
//			else {
//				tempPortfolio.setCurrentHoldings(tempPortfolio.getCurrentHoldings() - quantity);
//			}
//		}
//		else {
//			throw new IllegalStateException("Not Allowed, Register first");
//		}
//	}

 

//	public List<Portfolio> getPortfolioData(String email) {	
//         return portfolioData.get(email);
//    }
//
//    public List<Trade> getTradeHistoryData(String email) {
//        List<Trade> tradeHistory = this.tradeHistoryData.get(email);
//        return tradeHistory;
//    }
//
//    public List<Trade> getClientTradeHistorySorted(String email) {
//        List<Trade> tradeHistory = tradeHistoryData.get(email);
//        if (tradeHistory == null) {
//            return Collections.emptyList(); 
//        }
//           tradeHistory.sort(Comparator.comparingDouble(Trade::getCashValue).reversed());
//           if (tradeHistory.size() > 100) {
//            tradeHistory = tradeHistory.subList(0, 100);
//        }
//
// 
//
//        return tradeHistory;
//    }

 

}