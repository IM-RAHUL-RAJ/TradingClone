package com.fidelity.model;


public class FMTS {
	double askPrice;
    double bidPrice;
    String priceTimeStamp;
    Instrument instrument;
	public FMTS(double askPrice, double bidPrice, String priceTimeStamp, Instrument instrument) {
		if(instrument.equals(null)) {
			throw new IllegalArgumentException("Instrument cannot be null");
		}
		this.askPrice = askPrice;
		this.bidPrice = bidPrice;
		this.priceTimeStamp = priceTimeStamp;
		this.instrument = instrument;
	}

	public double getAskPrice() {
		return askPrice;
	}
	
	public double getBidPrice() {
		return bidPrice;
	}
	


	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}
	
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getPriceTimeStamp() {
		return priceTimeStamp;
	}
	public void setPriceTimeStamp(String priceTimeStamp) {
		this.priceTimeStamp = priceTimeStamp;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}


}
