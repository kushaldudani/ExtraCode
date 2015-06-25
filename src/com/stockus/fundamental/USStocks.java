//package com.stockus.fundamental;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Calendar;
//import java.util.List;
//
//import com.stockdata.util.SynQueue;
//import com.stockus.model.USRecord;
//import com.stockus.net.USDataDownloader;
//
//public class USStocks {
//	
//	
//	
//	public static void main(String[] args) {
//		
//		SynQueue<String> stocks = new SynQueue<String>();
//		InputStreamReader is = null;
//		BufferedReader br = null;
//		try {
//			is = new InputStreamReader(new FileInputStream(new 
//					File("data/usstocks.txt")));
//			br =  new BufferedReader(is);
//			String line;
//			while ((line = br.readLine()) != null) {
//				String symbol = line.trim();
//				stocks.enqueue(symbol);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			 try {
//				br.close();
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		String symbol;
//		List<USRecord> records;
//		while((symbol = stocks.dequeue()) != null){
//			Calendar lastRecord = Calendar.getInstance();
//			lastRecord.set(2015, 1, 18); //This date is the the last date upto which data needs to be pulled
//			USDataDownloader downloader = new USDataDownloader(lastRecord.getTime(), -365);
//			records = downloader.downloadDataQUANDL(symbol);
//			for(USRecord record : records){
//				System.out.println(record);
//			}
//		}
//		
//		
//		
//	}
//
//}
