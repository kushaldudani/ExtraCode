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
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class Test3 {
//	
//	public static void main(String[] args) {
//		
//		InputStreamReader is = null;
//		BufferedReader br = null;
//		List<String> companys = new ArrayList<String>();
//		MCDummy mcdummy = new MCDummy();
//		try {
//			is = new InputStreamReader(new FileInputStream(new 
//					File("data/completefilteredurls.txt")));
//			br =  new BufferedReader(is);
//			String line; 
//			while ((line = br.readLine()) != null) {
//				String id = mcdummy.downloadData(line);
//				companys.add(line+" "+id);
//				
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
//		
//		OutputStreamWriter out = null;
//		BufferedWriter bw = null;
//		try{
//			out = new OutputStreamWriter(new FileOutputStream(new 
//					File("data/urlsid.txt"),true));
//			bw =  new BufferedWriter(out);
//			for(String company : companys){
//				bw.write(company);
//				bw.write("\n");
//			}
//		
//		
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
//		
//	}
//
//}
