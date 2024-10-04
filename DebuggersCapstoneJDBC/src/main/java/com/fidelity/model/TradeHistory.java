package com.fidelity.model;

public class TradeHistory {
	

	private double bidPrice; 
    private double askPrice;
    private double totalPrice;//cashValue-->total price
    private int quantity;
    private String action;
    private String instrumentId;
    private int tradeId;
    

	public TradeHistory(int tradeId,String instrumentId,double bidPrice, double askPrice,int quantity,double totalPrice, String action) {
		
		this.bidPrice = bidPrice;
		this.askPrice = askPrice;
		this.totalPrice = totalPrice;
		this.instrumentId = instrumentId;
		this.quantity = quantity;
		this.action = action;
		this.instrumentId = instrumentId;

		this.tradeId = tradeId;
	}
	
	
	
    public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}
	
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	

}
