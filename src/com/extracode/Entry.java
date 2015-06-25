package com.extracode;

public class Entry {
	
	private String symbol;
	private double close;
	private double high;
	private double low;
	private String url;
	
	/**
	 * @param symbol
	 * @param close
	 * @param high
	 * @param low
	 * @param url
	 */
	public Entry(String symbol, double close, double high, double low,
			String url) {
		super();
		this.symbol = symbol;
		this.close = close;
		this.high = high;
		this.low = low;
		this.url = url;
	}
	
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the close
	 */
	public double getClose() {
		return close;
	}
	/**
	 * @param close the close to set
	 */
	public void setClose(double close) {
		this.close = close;
	}
	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(double high) {
		this.high = high;
	}
	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}
	/**
	 * @param low the low to set
	 */
	public void setLow(double low) {
		this.low = low;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
