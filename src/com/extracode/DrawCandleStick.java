//package com.extracode;
//import java.awt.Color;
//import java.awt.Stroke;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.ValueMarker;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.data.xy.DefaultHighLowDataset;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.Layer;
//
//import com.stockdata.model.Record;
//
//
//
//
//public class DrawCandleStick extends ApplicationFrame {
//
//	private double min = 0.0;
//	private double max = 9999999.0;
//	  
//	private static final long serialVersionUID = 2539310640968329357L;
//
//	public DrawCandleStick(String symbol, List<Record> records,
//			double high, double low, double close) {
//		super(symbol);
//
//		final DefaultHighLowDataset dataset = createDataset(records);
//		final JFreeChart chart = createChart(dataset,symbol, high, low, close);
//		final ChartPanel chartPanel = new ChartPanel(chart);
//		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 650));
//		setContentPane(chartPanel);
//  }
//
//  private DefaultHighLowDataset createDataset(List<Record> records) {
//
//	  int serice = records.size();
//	  Date[] date = new Date[serice];
//	  double[] high = new double[serice];
//	  double[] low = new double[serice];
//	  double[] open = new double[serice];
//	  double[] close = new double[serice];
//	  double[] volume = new double[serice];
//
//	  
//	  for (int i = 0; i < serice; i++) {
//		  date[i] = records.get(i).getTime();
//		  high[i] = records.get(i).getHigh();
//		  low[i] = records.get(i).getLow();
//		  open[i] = records.get(i).getOpen();
//		  close[i] = records.get(i).getClose();
//		  volume[i] = records.get(i).getVolume();
//		  if(min < low[i]){
//			  min = low[i];
//		  }
//		  if(max > high[i]){
//			  max  = high[i];
//		  }
//	  }
//
//	  DefaultHighLowDataset data = new DefaultHighLowDataset("", date, high, low, 
//			  open, close, volume);
//	  return data;
//  }
//
//  private Date createData(int year, int month, int date,int hour) {
//	  Calendar calendar = Calendar.getInstance();
//	  calendar.set(year, month - 1, date);
//	  calendar.set(Calendar.HOUR, hour);
//	  return calendar.getTime();
//  }
//
//  private JFreeChart createChart(final DefaultHighLowDataset dataset, String symbol,
//		  double high, double low, double close) {
//	  final JFreeChart chart = ChartFactory.createCandlestickChart(symbol, 
//			  "Time", "Price", dataset, false);
//	    
//	  double pp = (high+low+close)/3;
//	  double s1 = (pp*2) - high;
//	  double r1 = (pp*2) - low;
//	  double s2 = pp - (high-low);
//	  double r2 = pp + (high-low);
//	  System.out.println(pp);
//	  System.out.println(s1);
//	  System.out.println(s2);
//	  System.out.println(r1);
//	  System.out.println(r2);
//	  ValueMarker marker1 = new ValueMarker(pp);  
//	  marker1.setLabel("pp"); 
//	  marker1.setPaint(Color.ORANGE);
//	  ValueMarker marker2 = new ValueMarker(s1);  
//	  marker2.setLabel("s1"); 
//	  marker2.setPaint(Color.GREEN);
//	  ValueMarker marker3 = new ValueMarker(s2);  
//	  marker3.setLabel("s2"); 
//	  marker3.setPaint(Color.GREEN);
//	  ValueMarker marker4 = new ValueMarker(r1);  
//	  marker4.setLabel("r1"); 
//	  marker4.setPaint(Color.RED);
//	  ValueMarker marker5 = new ValueMarker(r2);  
//	  marker5.setLabel("r2"); 
//	  marker5.setPaint(Color.RED);
//	  
//	  double minline = Math.min(min, s2);
//	  double maxline = Math.max(max, r2);
//	  chart.getXYPlot().getRangeAxis().setRange(minline*0.98, maxline*1.02);
//	  XYPlot plot = (XYPlot) chart.getPlot();
//	  plot.addRangeMarker(marker1, Layer.BACKGROUND);
//	  plot.addRangeMarker(marker2, Layer.BACKGROUND);
//	  plot.addRangeMarker(marker3, Layer.BACKGROUND);
//	  plot.addRangeMarker(marker4, Layer.BACKGROUND);
//	  plot.addRangeMarker(marker5, Layer.BACKGROUND);
//	  
//	  return chart;
//  }
//
// 
//}