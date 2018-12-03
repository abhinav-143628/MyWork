package com.abhi.java.core;

public abstract class MyAbstractClass {
	abstract int area(int area);
	
	public int totalLength(int... length){
		int totalLenght = 0;
		for(int l : length)
			totalLenght += l;
		
		return totalLenght;
	}
	

}
