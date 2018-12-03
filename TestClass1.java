package com.abhi.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestClass1 {

	public static void main(String[] args) {
		GenericClass g = new GenericClass<>();
		System.out.println(g.add("abc", "tc"));
		System.out.println(g.add(3, 2));

		GenericClass<String> g1 = new GenericClass<String>();
		System.out.println(g1.add("abc", "tc"));
		// below will give error as it is String type obj
		// System.out.println(g1.add(3, 2));

		GenericClass<Integer> g2 = new GenericClass<Integer>();
		// Below will give error as this obj is integer type
		// System.out.println(g2.add("abc", "tc"));
		System.out.println(g2.add(3, 2));

		GeneriMethodClass m = new GeneriMethodClass();
		m.<Integer>add(1, 2);

		List<String> st = new ArrayList<>();
		st.add("abc");
		st.add("bd");

		List<Integer> st1 = new ArrayList<>();
		st1.add(1);
		st1.add(2);

		List<Double> st2 = new ArrayList<>();
		st2.add(1.0);
		st2.add(22.4);

		List<Number> st3 = new ArrayList<>();
		st3.add(1.0);
		st3.add(22.4);

		// as st is string this list will not be allowed
		// m.checkUpperBound(st);

		// Integer and double both extend from number so we can pass it to this
		// method
		m.checkUpperBound(st1);
		m.checkUpperBound(st2);

		// st2 is double list to it cannot be allowed as double doesn't hold
		// integer
		// m.checkLowerBound(st2);

		// st3 is number so Integer is type of Number so Number list can take
		// integer inside it though we have added double values in st3 list
		m.checkLowerBound(st3);
		
		m.checkLowerBound(st1);
		
		
		
		/******* Comparator - Comparable **********/
		
		EmployeeSort sort1 = new EmployeeSort();
		sort1.setId(10);
		sort1.setName("abc2");
		
		EmployeeSort sort2 = new EmployeeSort();
		sort2.setId(11);
		sort2.setName("abc1");
		
		EmployeeSort sort3 = new EmployeeSort();
		sort3.setId(1);
		sort3.setName("abc3");
		
		List<EmployeeSort> ls = new ArrayList<>();
		ls.add(sort1);
		ls.add(sort2);
		ls.add(sort3);
		
		//If class doesn't implement Comparable in class then below line will not work, it will give compile time error.
		//sort method check for comparable in below line
		Collections.sort(ls);
		
		System.out.println("Based on Comparable");
		for(EmployeeSort s : ls)
			System.out.println(s.getName());
		
		System.out.println("Based on Comparator");
		
		Collections.sort(ls, new Comparator<EmployeeSort>() {

			@Override
			public int compare(EmployeeSort o1, EmployeeSort o2) {
				if(o1.getId() > o2.getId())
					return 1;
				else if(o1.getId() < o2.getId())
					return -1;
				else
					return 0;
			}
		});
		
		for(EmployeeSort s : ls)
			System.out.println(s.getId());
		
	}
}
