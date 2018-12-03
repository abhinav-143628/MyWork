package com.abhi.java.core;

public class GenericClass<T> {
	
	public String add(T a, T b){
		return a.toString()+b.toString();
	}

}
