//package com.extracode;
//
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
//import java.util.Map;
//
//import com.stockdata.util.StockDataUtil;
//
//public class InitData {
//	
//	
//	public static void main(String[] args) {
//		
//		Map<String,String> symbolmap = StockDataUtil.buildSymbolMap();
//		List<String> entries = new ArrayList<String>();
//		InputStreamReader is = null;
//		BufferedReader br = null;
//		try {
//			is = new InputStreamReader(new FileInputStream(new 
//					File("data/intraday.txt")));
//			br =  new BufferedReader(is);
//			String line; 
//			while ((line = br.readLine()) != null) {
//				entries.add(line);
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
//		OutputStreamWriter out = null;
//		BufferedWriter bw = null;
//		try{
//			out = new OutputStreamWriter(new FileOutputStream(new 
//					File("data/intraday.txt"),false));
//			bw =  new BufferedWriter(out);
//			for(String entry : entries){
//				String[] values = entry.split("\t");
//				String url = symbolmap.get(values[0]);
//				bw.write(entry+"\t"+url);
//				bw.write("\n");
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			 try {
//				 bw.close();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//	}
//
//}
