package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.*;

public interface ClientDao {
	
	Client getClient(String emailId);
	void addClient(Person person);
	void addPreference(Preferences preference);
	void updatePreference(Preferences preference);
	List<Portfolio> getPortfolio();
	List<TradeHistory> getTradeHistory();
	void addBuyTrade(String instrumentName, int quantity);
	void addSellTrade(String instrumentName, int quantity);
	void deleteTradeFromPortfolioOnSell(String instrumentName, int quantity);
}
