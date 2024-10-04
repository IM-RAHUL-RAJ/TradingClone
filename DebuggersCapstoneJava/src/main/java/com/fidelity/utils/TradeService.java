package com.fidelity.utils;



import java.util.List;

import com.fidelity.model.Client;
import com.fidelity.model.FMTS;
import com.fidelity.model.Order;

public class TradeService {
	List<Order> tradeHistory;
	Client client;
	
	public List<Order> getTradeHistory() {
		return tradeHistory;
	}

	public void setTradeHistory(List<Order> tradeHistory) {
		this.tradeHistory = tradeHistory;
	}
	

	public void buyTrade(FMTS tradeToBuy, int buyQuantity, int clientCashBalance) {
		if(clientCashBalance < tradeToBuy.getAskPrice()*buyQuantity) {
			throw new IllegalArgumentException("Cash balance Insufficient");
		}
		if(buyQuantity<1) {
			throw new IllegalArgumentException("Buy quantity cannot be negative");
		}
		PortfolioService ps = new PortfolioService();
		ps.updatePortfolio(tradeToBuy, "BUY", buyQuantity);
		tradeHistory = ps.updateTradeHistory(tradeToBuy, "BUY", buyQuantity);
	}
	
	public void sellTrade(FMTS tradeToBuy, int sellQuantity, int clientCashBalance) {
		if(clientCashBalance < tradeToBuy.getAskPrice()*sellQuantity) {
			throw new IllegalArgumentException("Cash balance Insufficient");
		}
		if(sellQuantity<1) {
			throw new IllegalArgumentException("Buy quantity cannot be negative");
		}
		PortfolioService ps = new PortfolioService();
		ps.updatePortfolio(tradeToBuy, "SELL", sellQuantity);
		tradeHistory = ps.updateTradeHistory(tradeToBuy, "SELL", sellQuantity);
	}
	
	
}
