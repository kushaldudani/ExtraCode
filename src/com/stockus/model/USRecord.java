package com.stockus.model;
import java.util.Date;


public class USRecord {
	
	private Date time;
	private double open;
	private double high;
	private double low;
	private double close;
	private double volume;
	
	public USRecord(Date time, double open, double high, double low,
			double close, double volume) {
		super();
		this.time = time;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
	}

	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}

	/**
	 * @return the close
	 */
	public double getClose() {
		return close;
	}

	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Record [time=" + time + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", volume=" + volume
				+ "]";
	}
	
	

}
