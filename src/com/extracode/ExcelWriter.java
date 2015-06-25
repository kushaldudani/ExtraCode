//package com.extracode;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.TimeZone;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.stockdata.model.Record;
//
//
//public class ExcelWriter {
//
//	
//	
//	public void writeRecords(String filename, List<Record> records, String symbol){
//		try{
//			FileInputStream file = new FileInputStream(new File(filename));
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			XSSFSheet sheet = workbook.getSheet(symbol);
//			if(null == sheet){
//				sheet = workbook.createSheet(symbol);
//			}else{
//				List<Row> rows = new ArrayList<Row>();
//				for (Row row : sheet) {
//					rows.add(row);
//				}
//				for(Row row : rows){
//					sheet.removeRow(row);
//				}
//			}
//			
//			Object[] header = new Object[] {"Date","Open","High","Low","Close","Volume"};
//			Row row = sheet.createRow(0);
//			int cellnum=0;
//			for(Object obj : header){
//				Cell cell = row.createCell(cellnum++);
//				cell.setCellValue((String)obj);
//			}
//			
//			CellStyle cellStyle = workbook.createCellStyle();
//			XSSFCreationHelper createHelper = workbook.getCreationHelper();
//			cellStyle.setDataFormat(
//			    createHelper.createDataFormat().getFormat("h:mm"));
//			
//			int rownum=1;
//			for(Record record : records){
//				row = sheet.createRow(rownum++);
//				Cell cell = row.createCell(0);
//				cell.setCellValue(getTime(record.getTime()));
//				//cell.setCellStyle(cellStyle);
//				cell = row.createCell(1);
//				cell.setCellValue(record.getOpen());
//				cell = row.createCell(2);
//				cell.setCellValue(record.getHigh());
//				cell = row.createCell(3);
//				cell.setCellValue(record.getLow());
//				cell = row.createCell(4);
//				cell.setCellValue(record.getClose());
//				cell = row.createCell(5);
//				cell.setCellValue(record.getVolume());
//			}
//			
//			FileOutputStream out = new FileOutputStream(new File(filename));
//            workbook.write(out);
//            out.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	
//	public String getTime(Date date){
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTimeZone(TimeZone.getTimeZone("IST"));
//		cal.setTime(date);
//        return "" + cal.get(Calendar.HOUR_OF_DAY) +":" +
//                (cal.get(Calendar.MINUTE)) + ":" + cal.get(Calendar.SECOND);
//    }
//	
//}
