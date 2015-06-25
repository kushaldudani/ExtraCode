package com.extracode;
//package com.stockdata.backtest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//public class BacktestLbbChecker {
//	
//	
//	public static void main(String[] args) {
//		
//		BacktestDbManager db =  new BacktestDbManager();
//		db.openSession();
//		List<Backtest> completelist = db.downloadData();
//		db.closeSession();
//		Map<String,List<Backtest>> map = new HashMap<String,List<Backtest>>();
//		for(Backtest value : completelist){
//			String stock = value.getSymbol().split("-")[0];
//			if(map.get(stock) == null){
//				map.put(stock, new ArrayList<Backtest>());
//			}
//			(map.get(stock)).add(value);
//		}
//		
////		Map<Double,Integer> lbbmap1 = new HashMap<Double,Integer>();
////		Map<Double,List<Backtest>> lbbmap2 = new HashMap<Double,List<Backtest>>();
////		for(Backtest bt : completelist){
////			double lbbslope = nearestLbbRange(bt.getLbbRange());
////			if(lbbmap1.get(lbbslope) == null){
////				lbbmap1.put(lbbslope, 0);
////				lbbmap2.put(lbbslope, new ArrayList<Backtest>());
////			}
////			(lbbmap2.get(lbbslope)).add(bt);
////			if(bt.isSuccess()){ 
////				int count = (lbbmap1.get(lbbslope));
////				lbbmap1.put(lbbslope, (count+1));
////			}
////		}
////		
////		
////		printValues(lbbmap1, lbbmap2);
//		
//		
//		
//		
//		
//		
//		/*Map<Double,List<Backtest>> slbbmap2 = new TreeMap<Double,List<Backtest>>(lbbmap2);
//		Set set2 = slbbmap2.entrySet();
//        Iterator iterator2 = set2.iterator();
//        int cnt=0;
//        while(iterator2.hasNext()) {
//             Map.Entry me2 = (Map.Entry)iterator2.next();
//             List<Backtest> plist = (List<Backtest>) me2.getValue();
//             Map<Double,Integer> rangemap1 = new HashMap<Double,Integer>();
//     		Map<Double,List<Backtest>> rangemap2 = new HashMap<Double,List<Backtest>>();
//     		for(Backtest btt : plist){
//     			double lbbrange = nearestLbbRange(btt.getLbbRange());
//     			if(rangemap1.get(lbbrange) == null){
//     				rangemap1.put(lbbrange, 0);
//     				rangemap2.put(lbbrange, new ArrayList<Backtest>());
//     			}
//     			(rangemap2.get(lbbrange)).add(btt);
//     			if(btt.isSuccess()){ 
//     				int count = (rangemap1.get(lbbrange));
//     				rangemap1.put(lbbrange, (count+1));
//     			}
//     		}
//     		
//     		printValues(rangemap1, rangemap2, me2.getKey());
//             
//        }*/
//		//System.out.println(nearestLbbRange(15.827603554477));
//        
//	}
//	
//	private static void printValues(Map<Double, Integer> rangemap1,
//			Map<Double, List<Backtest>> rangemap2) {
//		Map<Double,Integer> srangemap1 = new TreeMap<Double,Integer>(rangemap1);
//		Set set2 = srangemap1.entrySet();
//        Iterator iterator2 = set2.iterator();
//        int cnt=0;
//        while(iterator2.hasNext()) {
//             Map.Entry me2 = (Map.Entry)iterator2.next();
//             //System.out.print(frt + ": ");
//             System.out.print(me2.getKey() + ": ");
//             System.out.print(me2.getValue() + ": ");
//             System.out.println(rangemap2.get(me2.getKey()).size());
//             //cnt = cnt + lbbmap2.get(me2.getKey()).size();
//        }
//		
//        //System.out.println(cnt);
//	}
//
//	private static double nearestLbbRange(double lbbrange){
//		int temp1 = (int) (lbbrange*10);
//		int temp2 = temp1/5;
//		temp2 = temp2*5;
//		return ((double)(temp2)/(double)(10));
//	}
//	
//	private static double nearestLbbSlope(double lbbslope){
//		int temp1 = (int) (lbbslope*100);
//		int temp2 = temp1/5;
//		temp2 = temp2*5;
//		return ((double)(temp2)/(double)(100));
//	}
//
//}
