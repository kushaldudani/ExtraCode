//package com.stockus.net;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//import com.stockus.model.USRecord;
//
//
//
//
//public class USDataDownloader {
//	
//	
//	private static final String quandlbaseUrl = "https://www.quandl.com/api/v1/datasets/";
//	private HttpClient client;
//	private Date fromdate;
//	private Date todate;
//	private SimpleDateFormat sdf;
//	
//	public USDataDownloader(Date startdate, int basedays) {
//		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*1000).setConnectTimeout(10*1000).build();
//		client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
//		
//		int daysinpast = getDaysinpast(startdate);
//		Calendar fromdatecal = Calendar.getInstance();
//		int daysforenddate = basedays - daysinpast; // basedays is negative
//		fromdatecal.add(Calendar.DATE, daysforenddate);
//		todate = startdate;
//		fromdate = fromdatecal.getTime();
//		sdf = new SimpleDateFormat("yyyy-MM-dd");
//	}
//	
//	public List<USRecord> downloadDataQUANDL(String symbol){
//		
//		List<USRecord> records = new ArrayList<USRecord>();
//		String url = getPriceURLQuandl(symbol);
//		InputStreamReader inputStreamReader = null;
//		BufferedReader bufferedReader = null;
//		try{
//			HttpResponse response = retryQuandl(url);
//			if(response.getStatusLine().getStatusCode() == 200){
//				inputStreamReader = new InputStreamReader(response.getEntity().getContent());
//				bufferedReader = new BufferedReader(inputStreamReader);
//				String line;
//				while ((line = bufferedReader.readLine()) != null) {
//					if (!Character.isDigit(line.charAt(0))) {
//						continue;
//					}
//            
//					String[] values = line.split(",");
//					Date date = (Date) sdf.parse(values[0]);
//            	
//					records.add(new USRecord(date, Double.parseDouble(values[1]), 
//            			Double.parseDouble(values[2]), Double.parseDouble(values[3]), 
//            			Double.parseDouble(values[4]), Double.parseDouble(values[5])));
//				}
//				
//			}else{
//				System.out.println("Data fetch failed for " + symbol);
//				return null;
//			}
//		}catch(Exception e){
//			System.out.println("Data fetch failed for " + symbol);
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
//		return records;
//	}
//	
//	private int getDaysinpast(Date startdate) {
//		Calendar cal1 = Calendar.getInstance();
//		cal1.setTime(startdate);
//		Calendar cal2 = Calendar.getInstance();
//		long milis1 = cal1.getTimeInMillis();
//        long milis2 = cal2.getTimeInMillis();
//        long diff = milis2 - milis1;
//        long diffDays = diff / (24 * 60 * 60 * 1000);
//		return (int) diffDays;
//	}
//
//	private HttpResponse retryQuandl(String url){
//		HttpGet request = new HttpGet(url);
//		System.out.println(url);
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
//	
//	
//	
//	private String getPriceURLQuandl(String symbol) {
//		String url = quandlbaseUrl + "WIKI/"; 
//		Calendar fromDate = Calendar.getInstance();
//		fromDate.setTime(fromdate);
//		Calendar toDate = Calendar.getInstance();
//		toDate.setTime(todate);
//		String frommonth = String.format("%02d",(fromDate.get(Calendar.MONTH)+1));
//		String fromday = String.format("%02d",fromDate.get(Calendar.DAY_OF_MONTH));
//		String fromyear = String.format("%02d",fromDate.get(Calendar.YEAR));
//		String tomonth = String.format("%02d",(toDate.get(Calendar.MONTH)+1));
//		String today = String.format("%02d",toDate.get(Calendar.DAY_OF_MONTH));
//		String toyear = String.format("%02d",toDate.get(Calendar.YEAR));
//	
//		return url + symbol + ".csv?auth_token=ZoVSx7zMTiAVUptENc_K&sort_order=asc&collapse=daily&trim_start="+fromyear + "-" + frommonth + "-" + fromday + "&trim_end=" + toyear + "-" + tomonth + "-" + today;
//	}
//
//
//}
