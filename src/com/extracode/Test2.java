package com.extracode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test2 {
	
	
	public static void main(String[] args) {
//		Calendar fromdate = Calendar.getInstance();
//		fromdate.add(Calendar.DATE, -1);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = fromdate.getTime();
//		System.out.println(sdf.format(date));
		
		
		InputStreamReader is = null;
		BufferedReader br = null;
		Map<String,Integer> companys = new HashMap<String,Integer>();
		try {
			is = new InputStreamReader(new FileInputStream(new 
					File("symbollist/niftytotal")));
			br =  new BufferedReader(is);
			String line; 
			while ((line = br.readLine()) != null) {
				String stk = line.trim();
				if(companys.get(stk) == null){
					companys.put(stk,0);
				}
				companys.put(stk, (companys.get(stk)+1));
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
		
		is = null;
		br = null;
		List<String> datas = new ArrayList<String>();
		try {
			is = new InputStreamReader(new FileInputStream(new 
					File("symbollist/avgvol50K")));
			br =  new BufferedReader(is);
			String line; 
			while ((line = br.readLine()) != null) {
				datas.add(line);
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
		
		
		Set<String> keyset = companys.keySet();
		for(String key : keyset){
			if(companys.get(key) > 1){
				System.out.println("duplicate");
			}
		}
		
		for(String dt : datas){
			String symbol = dt.trim();
			if(companys.get(symbol) == null){
				System.out.println(dt);
			}
		}
		
	}

}
