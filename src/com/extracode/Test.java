package com.extracode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Test {
	
	
	
	public static void main(String[] args) {
		
		//Date date = new Date();
		//Calendar cal = Calendar.getInstance();
		//cal.setTime(date);
		
		//System.out.println(cal.get(Calendar.MONTH));
		//System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		//System.out.println(cal.get(Calendar.YEAR));
		InputStreamReader is = null;
		BufferedReader br = null;
		List<String> urls = new ArrayList<String>();
		
		try {
			is = new InputStreamReader(new FileInputStream(new 
					File("/Users/kushd/Documents/workspace/stocktrading/StockData/config/result")));
			br =  new BufferedReader(is);
			
			
			String line; 
			while ((line = br.readLine()) != null) {
				//String date = (line.split(","))[0];
					urls.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			 try {
				br.close();
				is.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		OutputStreamWriter out = null;
		BufferedWriter bw = null;
		try{
			out = new OutputStreamWriter(new FileOutputStream(new 
					File("/Users/kushd/Downloads/RHQ.csv"),true));
			bw =  new BufferedWriter(out);
		int size = urls.size();
		for(int i=0;i<size;i++){
			String date = urls.get(i);
			date = date.replace("  ", ";");
			bw.write(date);
			bw.write("\n");
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			 try {
				 bw.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static boolean isSubSequence(String string, String company) {
		int x=0;
		for(int i=0;i<company.length();i++){
			if(Character.toLowerCase(string.charAt(x)) == Character.toLowerCase(company.charAt(i))){
				x++;
			}
			if(x == string.length()){
				return true;
			}
		}
		if(x == string.length()){
			return true;
		}
		return false;
	}

}
