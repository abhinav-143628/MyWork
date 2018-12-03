package com.abhi.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapSortbyValue {
	
	private static Map<String, Integer> sortMap(Map m1){
		List<Map.Entry<String,Integer>> it = new ArrayList<>(m1.entrySet());
		
		Collections.sort(it, new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		Map<String,Integer> m2 = new LinkedHashMap<>();
		for(Entry<String,Integer> nt : it){
			m2.put(nt.getKey(), nt.getValue());
		}
		
		return m2;
	}
	
	private static void sortMapKey(Map m1){
		List<String> it = new ArrayList<>(m1.keySet());
		
		Collections.sort(it);
		
		 for (String x : it)  
	            System.out.println("Key = " + x +  
	                        ", Value = " + m1.get(x)); 
		
	}


	public static void main(String[] args) {
		Map<String,Integer> m = new HashMap<>();
		m.put("abc1", 2);
		m.put("abc2", 1);
		m.put("abc5", 5);
		m.put("abc4", 8);
		
		Map<String,Integer> hm1 = sortMap(m);
		System.out.println("by key");
		sortMapKey(m);
		
		System.out.println("by value");
        for (Map.Entry<String, Integer> en : hm1.entrySet()) { 
            System.out.println("Key = " + en.getKey() +  
                          ", Value = " + en.getValue()); 
        } 
	}

}
