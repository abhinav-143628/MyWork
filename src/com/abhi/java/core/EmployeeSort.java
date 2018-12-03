package com.abhi.java.core;

import java.util.concurrent.ThreadPoolExecutor;

public class EmployeeSort implements Comparable<EmployeeSort> {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(EmployeeSort o) {
		return this.getName().compareTo(o.getName());
	}
	
}
