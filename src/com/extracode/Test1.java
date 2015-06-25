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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

	
	public static void main(String[] args) {
		InputStreamReader is = null;
		BufferedReader br = null;
		List<String> urls = new ArrayList<String>();
		try {
			is = new InputStreamReader(new FileInputStream(new 
					File("data/finalurls.txt")));
			br =  new BufferedReader(is);
			String line; 
			while ((line = br.readLine()) != null) {
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
		
		is = null;
		br = null;
		List<String> lines = new ArrayList<String>();
		try {
			is = new InputStreamReader(new FileInputStream(new 
					File("olddata/mc.txt")));
			br =  new BufferedReader(is);
			String line; 
			while ((line = br.readLine()) != null) {
				lines.add(line);
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
		
		List<String> cnx100 = new ArrayList<String>();
		for(String url : urls){
			String mc = url.split(" ")[0];
			for(String line : lines){
				if(line.contains(mc)){
					cnx100.add(url.split("qqq")[1]);
				}
			}
		}
		
		for(String symbol : cnx100){
			System.out.println(symbol);
		}
		
	}
	
}
