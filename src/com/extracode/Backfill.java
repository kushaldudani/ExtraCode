package com.extracode;
//package com.stockdata.net;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TimeZone;
//
//
//public class Backfill {
//	
//	
//	public static void main(String[] args) {
//		
//		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
//		List<String> stocks = new ArrayList<String>();
//		//String source = args[0];
//		InputStreamReader is = null;
//		BufferedReader br = null;
//		try {
//			is = new InputStreamReader(new FileInputStream(new 
//					File("olddata/failed1.txt")));
//			br =  new BufferedReader(is);
//			String line;
//			while ((line = br.readLine()) != null) {
//				String symbol = line.trim();
//				stocks.add(symbol);
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
//		QuandlDownloader downloader = new QuandlDownloader(null, null);
//		for(String filname : stocks){
//			List<PastRecord> pastrecords = new ArrayList<PastRecord>();
//			is = null;
//			br = null;
//			try {
//				is = new InputStreamReader(new FileInputStream(new 
//						File("/Users/kushd/Downloads/stocks/"+filname)));
//				br =  new BufferedReader(is);
//				String line;
//				while ((line = br.readLine()) != null) {
//					if (!Character.isDigit(line.charAt(0))) {
//						continue;
//					}else if(Double.parseDouble(line.substring(0, 4)) < 2009){
//						continue;
//					}
//            
//					String[] values = line.split(",");
//					//Date date = (Date) sdf.parse(values[0]);
//					PastRecord pastrecord = new PastRecord();
//					String temp = filname.split("-")[1];
//					String symbol = temp.split("\\.")[0];
//					pastrecord.setSymbol(symbol+"-"+values[0]);
//					//pastrecord.setTime(date);
//					pastrecord.setOpen(Double.parseDouble(values[1]));
//					pastrecord.setHigh(Double.parseDouble(values[2]));
//					pastrecord.setLow(Double.parseDouble(values[3]));
//					pastrecord.setClose(Double.parseDouble(values[5]));
//					pastrecord.setVolume(Double.parseDouble(values[6]));
//					pastrecords.add(pastrecord);
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}finally{
//				 try {
//					br.close();
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			downloader.populate(pastrecords);
//		}
//		
//	}
//
//}
