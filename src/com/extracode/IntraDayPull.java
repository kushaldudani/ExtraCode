//package com.extracode;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.stockdata.net.MoneyControl;
//
//
//
//
//public class IntraDayPull {
//	
//	
//	public static void main(String[] args) {
//		
//		
//		List<Entry> entries = new ArrayList<Entry>();
//		InputStreamReader is = null;
//		BufferedReader br = null;
//		try {
//			is = new InputStreamReader(new FileInputStream(new 
//					File("data/intraday.txt")));
//			br =  new BufferedReader(is);
//			String line;
//			while ((line = br.readLine()) != null) {
//				String[] values = line.split("\t");
//				entries.add(new Entry(values[0],Double.parseDouble(values[1]),
//						Double.parseDouble(values[2]),
//						Double.parseDouble(values[3]),values[4]));
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
//		List<IntradayData> datas = new ArrayList<IntradayData>(); 
//		for(Entry entry : entries){
//			double high = entry.getHigh();
//			double low = entry.getLow();
//			double close = entry.getClose();
//			double pp = (high+low+close)/3;
//			double s1 = (pp*2) - high;
//			double r1 = (pp*2) - low;
//			double s2 = pp - (high-low);
//			double r2 = pp + (high-low);
//			datas.add(new IntradayData(entry.getSymbol(), close, s1, s2, r1, r2,
//					entry.getUrl()));
//		}
//		MoneyControl mc = new MoneyControl();
//		
//		while(true){
//		for(IntradayData iddata : datas){
//			String value = mc.downloadData(iddata.getUrl());
//			if(value != null){
//				//System.out.println(value);
//				iddata.addLastprices(Double.parseDouble((value.split("/"))[0]));
//				iddata.setTodaysLow(Double.parseDouble((value.split("/"))[1]));
//			}else{
//				//System.out.println(0.0);
//				//iddata.addLastprices(0.0);
//				//iddata.setTodaysLow(0.0);
//			}
//		}
//		OutputStreamWriter out = null;
//		BufferedWriter bw = null;
//		try{
//			out = new OutputStreamWriter(new FileOutputStream(new 
//					File("/Library/WebServer/Documents/intradayresult.txt"),false));
//			bw =  new BufferedWriter(out);
//			for(IntradayData iddata : datas){
//				//String level = getClosest(iddata.getLastprices().getLast(),
//				//		iddata.getS1(),iddata.getS2(),iddata.getR1(),iddata.getR2());
//				double level = Math.min(iddata.getLastclose(), iddata.getTodaysLow());
//				int sz = iddata.getLastprices().size();
//				String prs=""; int k=sz-1; int cntr=0; 
//				while(k >=0){
//					prs = prs + iddata.getLastprices().get(k) + " ";
//					cntr++; k--;
//					if(cntr>=10){
//						break;
//					}
//				}
//				String line = iddata.getSymbol() + " " + iddata.getLastclose() + " " +
//						level + "             " + prs ;
//				bw.write(line + "\n");
//			}
//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			 try {
//				bw.close();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		try {
//			Thread.sleep(25000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		}
//		
//		
//		//GoogleDownloader gd = new GoogleDownloader();
//		//List<Record> records = gd.downloadData(symbol, interval);
//		//Check for doji
//		
//		//for(Record record : records){
//		//	System.out.println(record.toString());
//		//}
//		//ExcelWriter writer = new ExcelWriter();
//		//writer.writeRecords(filename, records, symbol);
//		//Map<Integer,String> map = BuiltinFormats.getBuiltinFormats();
//		//System.out.println(map);
//		//DrawCandleStick chart = new DrawCandleStick(symbol, records, high, low, close);
//		//chart.pack();
//		//RefineryUtilities.centerFrameOnScreen(chart);
//		//chart.setVisible(true);
//		
//	}
//
//	/*private static String getClosest(Double last, double s1, double s2,
//			double r1, double r2) {
//		DecimalFormat df = new DecimalFormat("#.##");
//		if(last>= r2){
//			return df.format(r2)+"r2";
//		}
//		if(last>=r1){
//			return df.format(r1)+"r1";
//		}
//		if(last>=s1){
//			return df.format(s1)+"s1";
//		}
//		if(last>=s2){
//			return df.format(s2)+"s2";
//		}
//		return "0";
//	}*/
//
//}
