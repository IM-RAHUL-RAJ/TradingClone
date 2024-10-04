package com.fidelity.model;

public class Trade {
    private double cashValue;
    private int quantity;
    private String direction;
    private String instrumentId;
    private String clientId;
    private String tradeId;
    private double executionPrice;
	public Trade(double cashValue, int quantity, String direction, String instrumentId, String clientId, String tradeId,
			double executionPrice) {
		super();
		this.cashValue = cashValue;
		this.quantity = quantity;
		this.direction = direction;
		this.instrumentId = instrumentId;
		this.clientId = clientId;
		this.tradeId = tradeId;
		this.executionPrice = executionPrice;
	}
	
	public double getCashValue() {
		return cashValue;
	}
	public void setCashValue(double cashValue) {
		this.cashValue = cashValue;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public double getExecutionPrice() {
		return executionPrice;
	}
	public void setExecutionPrice(double executionPrice) {
		this.executionPrice = executionPrice;
	}
}