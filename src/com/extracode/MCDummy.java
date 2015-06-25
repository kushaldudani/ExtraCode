//package com.extracode;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//public class MCDummy {
//	
//	private static final String baseUrl = "http://www.moneycontrol.com";
//	private HttpClient client;
//	
//	public MCDummy() {
//		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*1000).setConnectTimeout(10*1000).build();
//		client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
//	}
//	
//	
//	public String downloadData(String u){
//		String id = null;
//		String url = baseUrl + u;
//		System.out.println(url);
//		InputStreamReader inputStreamReader = null;
//		BufferedReader bufferedReader = null;
//		try{
//			HttpResponse response = retry(url);
//			if(response.getStatusLine().getStatusCode() == 200){
//				inputStreamReader = new InputStreamReader(response.getEntity().getContent());
//				bufferedReader = new BufferedReader(inputStreamReader);
//				String line;
//				while ((line = bufferedReader.readLine()) != null) {
//					if(line.contains("//get_data_disp(")){
//						String[] values = line.split(",");
//						id = values[2].substring(1,(values[2].length()-1));
//						break;
//					}
//				}
//				
//			}else{
//				System.out.println("Data fetch failed for " + u);
//				return null;
//			}
//		}catch(Exception e){
//			System.out.println("Data fetch failed for " + u);
//			return null;
//		}finally{
//			if(bufferedReader != null){
//				try {
//					bufferedReader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if(inputStreamReader != null){
//				try {
//					inputStreamReader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return id;
//	}
//	
//	
//	private HttpResponse retry(String url){
//		HttpGet request = new HttpGet(url);
//		int responsecode=0;
//		int nooftries = 1;
//		HttpResponse response=null;
//		while(responsecode != 200 && nooftries <= 5){
//			try{
//				response = client.execute(request);
//				responsecode = response.getStatusLine().getStatusCode();
//			}catch(Exception e){}
//			try {
//				Thread.sleep(nooftries * 1000);
//			} catch (InterruptedException e) {}
//			nooftries++;
//		}
//		
//		return response;
//	}
//
//}
