package com.extracode;

import java.util.LinkedList;

public class IntradayData {
	
	private String symbol;
	private LinkedList<Double> lastprices;
	private double lastclose;
	private double s1;
	private double s2;
	private double r1;
	private double r2;
	private String url;
	private double todayslow;
	
	
	
	
	/**
	 * @param symbol
	 * @param lastclose
	 * @param s1
	 * @param s2
	 * @param r1
	 * @param r2
	 */
	public IntradayData(String symbol, double lastclose, double s1, 
			double s2, double r1, double r2, String url) {
		super();
		this.symbol = symbol;
		this.lastprices = new LinkedList<Double>();
		this.lastclose = lastclose;
		this.s1 = s1;
		this.s2 = s2;
		this.r1 = r1;
		this.r2 = r2;
		this.setUrl(url);
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
	 * @return the lastprices
	 */
	public LinkedList<Double> getLastprices() {
		return lastprices;
	}
	
	public void addLastprices(double value) {
		if(lastprices.size() >= 10){
			lastprices.removeFirst();
		}
		lastprices.add(value);
	}
	/**
	 * @return the lastclose
	 */
	public double getLastclose() {
		return lastclose;
	}
	/**
	 * @param lastclose the lastclose to set
	 */
	public void setLastclose(double lastclose) {
		this.lastclose = lastclose;
	}
	/**
	 * @return the s1
	 */
	public double getS1() {
		return s1;
	}
	/**
	 * @param s1 the s1 to set
	 */
	public void setS1(double s1) {
		this.s1 = s1;
	}
	/**
	 * @return the s2
	 */
	public double getS2() {
		return s2;
	}
	/**
	 * @param s2 the s2 to set
	 */
	public void setS2(double s2) {
		this.s2 = s2;
	}
	/**
	 * @return the r1
	 */
	public double getR1() {
		return r1;
	}
	/**
	 * @param r1 the r1 to set
	 */
	public void setR1(double r1) {
		this.r1 = r1;
	}
	/**
	 * @return the r2
	 */
	public double getR2() {
		return r2;
	}
	/**
	 * @param r2 the r2 to set
	 */
	public void setR2(double r2) {
		this.r2 = r2;
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
	public void setTodaysLow(double todayslow) {
		this.todayslow = todayslow;
		
	}
	
	public double getTodaysLow(){
		return this.todayslow;
	}

}
