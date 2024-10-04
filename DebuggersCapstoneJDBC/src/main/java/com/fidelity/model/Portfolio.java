package com.fidelity.model;
//import java.time.LocalDate;
//
//public class Portfolio {
//
//	private String externalId;
//	private String externalType;
//	private String categoryId;
//	private LocalDate priceTimestamp;
//	private String instrumentDescription;
//	private Number bidPrice;
//	private Number askPrice;
//	private Number currentHoldings;
//	public Portfolio(String externalType, String externalId, String categoryId, LocalDate priceTimestamp,
//		              String instrumentDescription, double bidPrice, double askPrice, double currentHoldings) {
//		 this.externalType = externalType;
//		 this.externalId = externalId;
//		 this.categoryId = categoryId;
//		 this.priceTimestamp = priceTimestamp;
//		 this.instrumentDescription = instrumentDescription;
//		 this.bidPrice = bidPrice;
//		 this.askPrice = askPrice;
//		 this.currentHoldings = currentHoldings;
//	}
//	
//	public String getExternalId() {
//		return externalId;
//	}
//	public void setExternalId(String externalId) {
//		this.externalId = externalId;
//	}
//	public String getExternalType() {
//		return externalType;
//	}
//	public void setExternalType(String externalType) {
//		this.externalType = externalType;
//	}
//	public String getCategoryId() {
//		return categoryId;
//	}
//	public void setCategoryId(String categoryId) {
//		this.categoryId = categoryId;
//	}
//	public LocalDate getPriceTimestamp() {
//		return priceTimestamp;
//	}
//	public void setPriceTimestamp(LocalDate priceTimestamp) {
//		this.priceTimestamp = priceTimestamp;
//	}
//	public String getInstrumentDescription() {
//		return instrumentDescription;
//	}
//	public void setInstrumentDescription(String instrumentDescription) {
//		this.instrumentDescription = instrumentDescription;
//	}
//	public Number getBidPrice() {
//		return bidPrice;
//	}
//	public void setBidPrice(Number bidPrice) {
//		this.bidPrice = bidPrice;
//	}
//	public Number getAskPrice() {
//		return askPrice;
//	}
//	public void setAskPrice(Number askPrice) {
//		this.askPrice = askPrice;
//	}
//	public Number getCurrentHoldingNumber() {
//		return currentHoldings;
//	}
//	public void setCurrentHoldingNumber(Number currentHoldingNumber) {
//		this.currentHoldings = currentHoldingNumber;
//	}
//	
//}


import java.util.Objects;



public class Portfolio {
	private String externalId;
	private String externalType;
    private String priceTimestamp;
    private String instrumentDescription;
    private double bidPrice;
    private double askPrice;
    private double currentHoldings;

	public Portfolio(String externalId, String externalType, String priceTimestamp, String instrumentDescription,
			double bidPrice, double askPrice, double currentHoldings) {
		this.externalId = externalId;
		this.externalType = externalType;
		this.priceTimestamp = priceTimestamp;
		this.instrumentDescription = instrumentDescription;
		this.bidPrice = bidPrice;
		this.askPrice = askPrice;
		this.currentHoldings = currentHoldings;
	}

 

	public String getExternalId() {
		return externalId;
	}

 

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

 

	public String getExternalType() {
		return externalType;
	}

 

	public void setExternalType(String externalType) {
		this.externalType = externalType;
	}

 

	public String getPriceTimestamp() {
		return priceTimestamp;
	}

 

	public void setPriceTimestamp(String priceTimestamp) {
		this.priceTimestamp = priceTimestamp;
	}

 

	public String getInstrumentDescription() {
		return instrumentDescription;
	}

 

	public void setInstrumentDescription(String instrumentDescription) {
		this.instrumentDescription = instrumentDescription;
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

 

	public double getCurrentHoldings() {
		return currentHoldings;
	}

 

	public void setCurrentHoldings(double currentHoldings) {
		this.currentHoldings = currentHoldings;
	}

 

	@Override
	public int hashCode() {
		return Objects.hash(askPrice, bidPrice, externalId, externalType, instrumentDescription, priceTimestamp);
	}

 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolio other = (Portfolio) obj;
		return Double.doubleToLongBits(askPrice) == Double.doubleToLongBits(other.askPrice)
&& Double.doubleToLongBits(bidPrice) == Double.doubleToLongBits(other.bidPrice)
&& Objects.equals(externalId, other.externalId) && Objects.equals(externalType, other.externalType)
&& Objects.equals(instrumentDescription, other.instrumentDescription)
&& Objects.equals(priceTimestamp, other.priceTimestamp);
	}


}
